package com.example.ITBook.common.domain.projection;

import org.springframework.data.rest.core.config.Projection;

import com.example.ITBook.common.domain.User;

@Projection(name = "getOnlyName", types = {User.class})
public interface UserOnlyContainName {
    String getName();
}
