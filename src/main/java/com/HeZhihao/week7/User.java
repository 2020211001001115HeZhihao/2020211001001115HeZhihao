package com.HeZhihao.week7;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private String email;
    private String gender;
    private Date birthdate;
    private int id;

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", Birthdate='" + Birthdate + '\'' +
                '}';
    }

    private String Birthdate;

    public User(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public User(String username, String password, String email, String gender, String Birthdate){
        this.Birthdate = Birthdate;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }
}
