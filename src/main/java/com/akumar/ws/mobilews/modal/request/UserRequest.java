package com.akumar.ws.mobilews.modal.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserRequest {


    @NotNull(message = "firstName can not be null")
    @Size(min = 2, message = "firstName should be of minimum 2 chars")
    private String firstName;

    @NotNull(message = "lastName can not be null")
    @Size(min = 2, message = "lastName should be of minimum 2 chars")
    private String lastName;

    @NotNull(message = "email can not be null")
    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "password can not be null")
    @Size(min = 4, max = 8, message = "Password should be greater than 4 character and less than equal to 8 character")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
