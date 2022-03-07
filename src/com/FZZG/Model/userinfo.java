package com.FZZG.Model;

public class userinfo {
    private String username;
    private String password;
    private int ifAdmin;

    public userinfo() {
    }

    public userinfo(String username, String password, int ifAdmin) {
        this.username = username;
        this.password = password;
        this.ifAdmin = ifAdmin;
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

    public int getIfAdmin() {
        return ifAdmin;
    }

    public void setIfAdmin(int ifAdmin) {
        this.ifAdmin = ifAdmin;
    }
}
