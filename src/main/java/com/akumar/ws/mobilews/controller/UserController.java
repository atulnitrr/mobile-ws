package com.akumar.ws.mobilews.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.akumar.ws.mobilews.exceptions.UserServiceException;
import com.akumar.ws.mobilews.modal.request.UpdateUserRequest;
import com.akumar.ws.mobilews.modal.request.UserRequest;
import com.akumar.ws.mobilews.modal.response.User;
import com.akumar.ws.mobilews.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private Map<String, User> users;

    @Autowired
    private UserService userService;


    // Query string or Request param example
    // http://localhost:8080/users?limit=20&page=2
    @GetMapping
    public String getUsers(@RequestParam(value ="page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "25") int limit)
    {
        return "Get users for page  " + page + " limit  " + limit;
    }


    // path parameter or path variable example
//    http://localhost:8080/users/890
    @GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<User> getUser(@PathVariable final String userId) {

        if (true) {
            throw new UserServiceException(" A new user service exception is thrown ");
        }

        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.OK);

    }

    @PutMapping(path = "{userId}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public User updateUser(@PathVariable final String userId,
            @Valid @RequestBody final UpdateUserRequest updateUserRequest) {

        final User storedUser = users.get(userId);
        storedUser.setFirstName(updateUserRequest.getFirstName());
        storedUser.setLastName(updateUserRequest.getLastName());
        users.put(userId, storedUser);
        return storedUser;
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable final String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
