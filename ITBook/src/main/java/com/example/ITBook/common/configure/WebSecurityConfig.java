package com.example.ITBook.common.configure;

import com.example.ITBook.common.enums.Authority;
import com.example.ITBook.common.enums.SocialType;
import com.example.ITBook.oauth2.CustomOAuth2Provider;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
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
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity // ?��?��?��리티 ?��?��?��겠다?�� ?��?��?��?��?��
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        
		/*
		 * filter.setEncoding("UTF-8"); filter.setForceEncoding(true);
		 */

        http.authorizeRequests()
                .antMatchers("/", "/oauth2/**", "/login/**","/css/**", "/images/**", "/js/**", "/console/**")
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
                .csrf().disable();
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
                    // ?��북의 graph API?�� scope로는 ?��?��?�� ?��?���? 반환?��주�? ?��?�� idm name, email, link�? ?��?��미터�? ?��?�� ?���??��?���? ?��?��
                    .userInfoUri("https://graph.facebook.com/me?fields=id,name,email,link")
                    .scope("email")
                    .build();
        }

        return null;
    }
}
