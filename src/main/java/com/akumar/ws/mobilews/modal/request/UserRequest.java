package com.akumar.ws.mobilews.modal.request;

public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String passWord;

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(final String passWord) {
        this.passWord = passWord;
    }
}
