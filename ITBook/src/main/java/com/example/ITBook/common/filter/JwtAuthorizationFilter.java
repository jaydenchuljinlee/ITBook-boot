package com.example.ITBook.common.filter;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.Authority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        logger.debug("JwtAuthorizationFilter.doFilterInternal :::");

        /*
         * 쿠키 인증 토큰을 검사한다.
         * 만약 토큰 및 헤더에 대한 검사에 실패한다면,
         * AuthennticationEntryPoit에 위임하거나 혹은 HttpResponse에 적절한
         * 상태코드와 메시지를 담아서 리턴해준다.
         */


        super.doFilterInternal(request, response, chain);
    }

    /*
    * 성공시 처리 메서드
    * */
    @Override
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {

        logger.debug("JwtAuthorizationFilter.onSuccessfulAuthentication :::");

        HttpSession session = request.getSession();

        User user = User.builder()
                        .identity(String.valueOf(authResult.getCredentials()))
                        .password(String.valueOf(authResult.getCredentials()))
                        .build();

        session.setAttribute("user",user);
        session.setAttribute("authorites",authResult.getAuthorities());

        super.onSuccessfulAuthentication(request, response, authResult);
    }

    /*
    * 실패시 처리 메서드
    * */
    @Override
    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {

        logger.debug("JwtAuthorizationFilter.onUnsuccessfulAuthentication :::");

        super.onUnsuccessfulAuthentication(request, response, failed);
    }
}
