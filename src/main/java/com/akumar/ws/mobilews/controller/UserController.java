package com.akumar.ws.mobilews.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {


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
    @GetMapping("/{userId}")
    public String getUser(@PathVariable final String userId) {
        return "Get user was called with userId " + userId;
    }

    @PostMapping
    public  String createUser() {
        return "Post user was called";
    }

    @PutMapping
    public String updateUser() {
        return "Update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete user was called";
    }
}
