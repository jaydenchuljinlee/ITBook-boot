package com.example.ITBook.restApi.event;

import com.example.ITBook.common.domain.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class UserEventHandler {

    @HandleBeforeCreate
    public void beforCreateUser(User user) {

        user.setCreatedDate();
    }

    public void beforeSaveUser(User user) {
        user.setUpdatedDate();
    }
}
