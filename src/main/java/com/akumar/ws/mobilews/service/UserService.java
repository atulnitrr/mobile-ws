package com.akumar.ws.mobilews.service;

import com.akumar.ws.mobilews.modal.request.UserRequest;
import com.akumar.ws.mobilews.modal.response.User;


public interface UserService {

    User createUser(final UserRequest userRequest);
}
