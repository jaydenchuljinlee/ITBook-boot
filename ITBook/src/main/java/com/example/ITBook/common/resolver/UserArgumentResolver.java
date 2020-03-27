package com.example.ITBook.common.resolver;

import com.example.ITBook.common.annotation.SocialUser;
import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.common.exception.DoNotUpdateOrInsertException;
import com.example.ITBook.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
	
	@Autowired
    private UserRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter){

        log.info("UserArgumentResolver.supportsParameter :::");

        return (parameter.getParameterAnnotation(SocialUser.class) != null) &&
                parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

        log.info("UserArgumentResolver.resolveArgument :::");

        User user = (User) session.getAttribute("user");

        return  getUser(user, session);
    }

    private User getUser(User user, HttpSession session) throws Exception{

        log.info("UserArgumentResolver.getUser :::");

        OAuth2AuthenticationToken auth2AuthenticationToken =
                (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> attributes = auth2AuthenticationToken.getPrincipal().getAttributes();
        
        User convertUser = convertUser(auth2AuthenticationToken.getAuthorizedClientRegistrationId(), attributes);
        
        Optional<User> identity = userRepository.findByIdentity(convertUser.getIdentity());

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

        log.info("UserArgumentResolver.convertUser :::");

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

        log.info("UserArgumentResolver.getModernUser :::");

        return User.builder()
                .name(String.valueOf(attributes.get("name")))
                .email(String.valueOf(attributes.get("email")))
                .identity(String.valueOf(attributes.get("id")))
                .socialType(socialType)
                .build();

    }

    private User getKakaoUser(Map<String, Object> attributes) {

        log.info("UserArgumentResolver.getKakaoUser :::");

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


     private void setRoleIfNotSame(User user, OAuth2AuthenticationToken auth2AuthenticationToken, Map<String, Object> attributes) {

         log.info("UserArgumentResolver.setRoleIfNotSame :::");

        if (auth2AuthenticationToken.getAuthorities().contains(new SimpleGrantedAuthority(user.getSocialType().getRoleType()))) {

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(attributes, "N/A",
                            AuthorityUtils.createAuthorityList(user.getSocialType().getRoleType()))
            );
        }
    }

}
