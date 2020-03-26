회원 정보 등록 
-
- 회원 가입, 회원 정보 변경, oauth2 로그인

OAuath2로그인
- 
- 로그인은 oatuh2 방식으로 진행하였고, (Todo : 일반로그인 -> oauth2 통합)
- 연동 로그인을 할 떄, 데이터 베이스를 조회하여
- 같은 정보의 연동 기록이 있을 경우
- 데이터를 insert하지 않고, 그 데이터를 불러와 세션에 저장하는 방식으로 진행했습니다.
- 세션 관련 readme는 [ITBook-boot/manaul/aop]에 설명을 적어놨습니다.


스프링 부트 시큐리티 적용
- 
- 스프링 시큐리티는 [처음 배우는 스프링 부트2] 라는 도서를 구현을 했습니다
- Todo : 기존에 작성했던 주석이 한글 인코딩 과정에서 깨지는 바람에 다시 작성 중입니다.
- 시큐리티 config [WebSecurityConfig.java]
```java
package com.example.ITBook.common.configure;

import com.example.ITBook.common.enums.Authority;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.oauth2.CustomOAuth2Provider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity // 웹 시큐리티
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // @toto: 일반 로그인 provider 구현
   /* @Autowired
    private AuthenticationProvider authenticationProvier;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvier);

        super.configure(auth);
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        
		/*
		 * filter.setEncoding("UTF-8"); filter.setForceEncoding(true);
		 */

        http.authorizeRequests()
                .antMatchers("/","/api/**","/file/**","/loginCheck","/oauth2/**", "/login/**","/join/**","/webapp/**","/css/**", "/images/**", "/js/**", "/console/**","/admin/css/**","/admin/images/**","/admin/js/**","/itbook/js/**","/itbook/js/images","/itbook/css/**","/itbook/fonts/**")
                    .permitAll()
                .antMatchers("/admin/**")
                	.hasAnyAuthority(Authority.ADMIN.getRoleType())
                .antMatchers("/facebook")
                    .hasAnyAuthority(SocialType.FACEBOOK.getRoleType())
                .antMatchers("/google")
                    .hasAnyAuthority(SocialType.GOOGLE.getRoleType())
                .antMatchers("/kakao")
                    .hasAnyAuthority(SocialType.KAKAO.getRoleType())
                .anyRequest()
                    .authenticated()
            .and()
                .oauth2Login()
                    .defaultSuccessUrl("/loginSuccess")
                    .failureUrl("/loginFailure")
            .and()
                .headers()
                    .frameOptions().disable()
            .and()
                .exceptionHandling()
                    .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
            .and()
                .formLogin()
                    .successForwardUrl("/main")
            .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
            .and()
               .addFilterBefore(filter, CsrfFilter.class)
                .csrf().disable()
            /*.addFilter(jwtAuthenticationFilter())
            .addFilter(jwtAuthorizationFilter())*/
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)
            ;
    }


    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(OAuth2ClientProperties oAuth2ClientProperties, @Value("${custom.oauth2.kakao.client-id}") String kakaoClientId) {
        List<ClientRegistration> registrationList =
                oAuth2ClientProperties.getRegistration().keySet().stream()
                .map(client -> getRegistration(oAuth2ClientProperties, client))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        registrationList.add(CustomOAuth2Provider.KAKAO.getBuilder("kakao")
            .clientId(kakaoClientId)
            .clientSecret("test")
            .jwkSetUri("test")
            .build());

        return new InMemoryClientRegistrationRepository(registrationList);
    }

    private ClientRegistration getRegistration(OAuth2ClientProperties oAuth2ClientProperties, String client) {
        if ("google".equals(client)) {
            OAuth2ClientProperties.Registration registration =
                    oAuth2ClientProperties.getRegistration().get("google");

            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope("email", "profile")
                    .build();
        }

        if ("facebook".equals(client)) {
            OAuth2ClientProperties.Registration registration =
                    oAuth2ClientProperties.getRegistration().get("facebook");

            return CommonOAuth2Provider.FACEBOOK.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())

                    .userInfoUri("https://graph.facebook.com/me?fields=id,name,email,link")
                    .scope("email")
                    .build();
        }

        return null;
    }
}

```

- 연동 로그인 정보를 제공하는 provider [CustomOAuth2Provider.java]
```java
package com.example.ITBook.oauth2;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

public enum CustomOAuth2Provider {
    KAKAO {

        @Override
        public ClientRegistration.Builder getBuilder(String registrationId) {
            ClientRegistration.Builder builder = getBuilder(registrationId,
                    ClientAuthenticationMethod.POST, DEFAULT_LOGIN_REDIRECT_URL);
            builder.scope("profile");
            builder.authorizationUri("https://kauth.kakao.com/oauth/authorize");
            builder.tokenUri("https://kauth.kakao.com/oauth/token");
            builder.userInfoUri("https://kapi.kakao.com/v1/user/me");
            builder.userNameAttributeName("id");
            builder.clientName("Kakao");
            return builder;
        }
    };

    private static final String DEFAULT_LOGIN_REDIRECT_URL = "{baseUrl}/login/oauth2/code/{registrationId}";

    protected final ClientRegistration.Builder getBuilder(String registrationId,
                                                          ClientAuthenticationMethod method, String redirectUri) {
        ClientRegistration.Builder builder = ClientRegistration.withRegistrationId(registrationId);
        builder.clientAuthenticationMethod(method);
        builder.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE);
        builder.redirectUriTemplate(redirectUri);
        return builder;
    }

    /**
     * Create a new
     * {@link org.springframework.security.oauth2.client.registration.ClientRegistration.Builder
     * ClientRegistration.Builder} pre-configured with provider defaults.
     * @param registrationId the registration-id used with the new builder
     * @return a builder instance
     */
    public abstract ClientRegistration.Builder getBuilder(String registrationId);

}

```

- 로그인 성공시 소셜 정보를 갖고 있는 여부를 판단하고 처리하는 resolver [UserArgumentResolver.java]
```java
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

```

- 로그인 컨트롤러 [LoginController.java]
```java
package com.example.ITBook.user.web;

import com.example.ITBook.common.annotation.SocialUser;
import com.example.ITBook.common.domain.User;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
* 로그인 관련 컨트롤러
* */

@Slf4j
@SessionAttributes("user")
@Controller
public class LoginController {

	/*
	* 로그인 메인 페이지
	* */
	@GetMapping("/login")
    public String login() {

	    log.info("LoginController.login :::");

        return "login/login.tiles2";
    }

    /*
    * @todo : 시큐리티에서 oauth2와 일반 사용자 로그인 통합
    * 로그인 체크
    * */
    @PostMapping("/loginCheck")
    public String loginCheck(@RequestParam String identity,@RequestParam String password) {

        log.info("LoginController.loginCheck :::");

        return "login/login.tiles2";
    }

    /*
    * 로그인 성공 페이지
    * */
	@RequestMapping("/loginSuccess")
    public String loginSuccess(@SocialUser User user) {
        log.info("LoginController.loginSuccess :::");
        return "redirect:/main";
    }
}

```

- 로그인 성공 메서드의 파라미터에서 소셜 정보를 확인할 annotation [SocialUser.java]
```java
package com.example.ITBook.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 소셜 정보 확인 annotation
* */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface SocialUser {

}

```
