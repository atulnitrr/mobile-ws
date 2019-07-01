package com.akumar.ws.mobilews.modal.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UpdateUserRequest {

    @NotNull(message = "firstName can not be null")
    @Size(min = 2, message = "firstName should be of minimum 2 chars")
    private String firstName;

    @NotNull(message = "lastName can not be null")
    @Size(min = 2, message = "lastName should be of minimum 2 chars")
    private String lastName;

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
}
