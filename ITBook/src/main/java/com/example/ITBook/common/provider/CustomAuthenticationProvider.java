package com.example.ITBook.common.provider;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.debug("CustomAuthenticationProvider.authenticate :::");

        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        String id = token.getName();

        Optional<User> user = null;

        if (!StringUtils.isEmpty(id)) {

            user = userRepository.findByIdentity(id);

        }

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Invalid name!!");
        }

        String password = user.get().getPassword();

        if (encoder.matches(String.valueOf(token.getCredentials()),password)) {

            throw new BadCredentialsException("Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(user,password);
    }

    @Override
    public boolean supports(Class<?> authentication) {

        log.debug("CustomAuthenticationProvider.supports :::");

        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
