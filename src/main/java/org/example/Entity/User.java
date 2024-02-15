package org.example.Entity;

public class User {
    private String userId;
    private String name;
    private String email;
    private String mobilenumber;

    public User(String userId, String name, String email, String mobilenumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobilenumber = mobilenumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
}
