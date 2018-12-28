package com.xiaoming.mygymclub.entities;

public class UserClient {
    private User mUser;
    private static UserClient instance;

    private UserClient(){}

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public static UserClient getInstance() {
        if (instance == null){
            instance = new UserClient();
        }
        return instance;
    }

    public static void setInstance(UserClient instance) {
        UserClient.instance = instance;
    }
}
