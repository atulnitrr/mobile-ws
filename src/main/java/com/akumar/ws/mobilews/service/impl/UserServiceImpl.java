package com.akumar.ws.mobilews.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.akumar.ws.mobilews.modal.request.UserRequest;
import com.akumar.ws.mobilews.modal.response.User;
import com.akumar.ws.mobilews.service.UserService;
import com.akumar.ws.mobilews.utils.Utils;


@Service
public class UserServiceImpl implements UserService {

    private Map<String, User> users;
    private Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(final Utils utils) {
        this.utils = utils;
    }

    @Override public User createUser(final UserRequest userRequest) {
        final User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());

        final String userId = utils.getUserId();
        user.setUserId(userId);

        if (users == null) {
            users = new HashMap<>();
        }
        users.put(userId, user);
        return user;
    }
}
