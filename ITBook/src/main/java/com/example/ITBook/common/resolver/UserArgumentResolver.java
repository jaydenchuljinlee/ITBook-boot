package com.example.ITBook.common.resolver;

import com.example.ITBook.common.annotation.SocialUser;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.user.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
	private static final Logger logger = LoggerFactory.getLogger(UserArgumentResolver.class);
	
	@Autowired
    private UserRepository userRepository;

	/*
	 * 메서드의 파라미터 검사
	 * */
    @Override
    public boolean supportsParameter(MethodParameter parameter){
    	
        return (parameter.getParameterAnnotation(SocialUser.class) != null) &&
                parameter.getParameterType().equals(User.class);
    }

    /*
     * 메서드 파라미터를 가져와 검사 후 세션에 담음
     * */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

        User user = (User) session.getAttribute("user");

        return  getUser(user, session);
    }

    /*
     * user 객체를 검사하여 세션에 담음
     * */
    private User getUser(User user, HttpSession session) throws Exception{
    	
    	//oauth2 토큰의 컨텍스트에서 인증 정보를 가져옴
        OAuth2AuthenticationToken auth2AuthenticationToken =
                (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        //인증정보는 key,value형의 map타입을 반환
        Map<String, Object> attributes = auth2AuthenticationToken.getPrincipal().getAttributes();
        
        User convertUser = convertUser(auth2AuthenticationToken.getAuthorizedClientRegistrationId(), attributes);
        
        Optional<User> identity = userRepository.findByIdentity(convertUser.getIdentity());
        
        //존재하는 user라면 user 객체에 가져온 정보를 담는다
        if (identity.isPresent()) user = identity.get();
        else {
        	
        	 user = userRepository.save(convertUser);
        	
        	if (user == null) throw new DoNotUpdateOrInsertException();
        	
        }

        setRoleIfNotSame(user, auth2AuthenticationToken, attributes);
        session.setAttribute("user",user);

        return user;
    }

    private User convertUser(String authority, Map<String, Object> attributes) throws Exception{
        if (SocialType.FACEBOOK.isEuqals(authority)) {
            return getModernUser(SocialType.FACEBOOK,attributes);
        } else if (SocialType.GOOGLE.isEuqals(authority)) {
            return getModernUser(SocialType.GOOGLE,attributes);
        } else if (SocialType.KAKAO.isEuqals(authority)) {
            return getKakaoUser(attributes);
        }
        return null;
    }

    private User getModernUser(SocialType socialType, Map<String, Object> attributes) throws Exception{
        return User.builder()
                .name(String.valueOf(attributes.get("name")))
                .email(String.valueOf(attributes.get("email")))
                .identity(String.valueOf(attributes.get("id")))
                .socialType(socialType)
                .build();

    }

    //카카오 타입은 제공해주는 정보가 다름
    private User getKakaoUser(Map<String, Object> attributes) {
        Map<String, String> propertiesMap =
                (HashMap<String, String>) attributes.get("properties");

        String email = String.valueOf(attributes.get("id")) + "@community.com";

                return User.builder()
                        .name(propertiesMap.get("nickName"))
                        //.email(String.valueOf(attributes.get("kaccount_email")))
                        .principal(String.valueOf(attributes.get("id")))
                        .socialType(SocialType.KAKAO)
                        .createdDate(LocalDateTime.now())
                        .build();
    }


    //인증 정보가 권한 리스트를 포함하고 있으면, 인증 정보에 권한 리스트를 넣어준다.
    private void setRoleIfNotSame(User user, OAuth2AuthenticationToken auth2AuthenticationToken, Map<String, Object> attributes) {
        if (auth2AuthenticationToken.getAuthorities().contains(new SimpleGrantedAuthority(user.getSocialType().getRoleType()))) {

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(attributes, "N/A",
                            AuthorityUtils.createAuthorityList(user.getSocialType().getRoleType()))
            );
        }
    }

}
