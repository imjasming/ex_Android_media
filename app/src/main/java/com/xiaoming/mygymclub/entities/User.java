package com.xiaoming.mygymclub.entities;

import android.support.annotation.NonNull;


public class User {
    private long mId;
    private String mNickName;
    private String mPassword;
    private String mEmail;
    //private int mTelNum;

    public User(){}

    public User(long id, String nickName, String password, String email){
        mId = id;
        mNickName = nickName;
        mPassword = password;
        mEmail = email;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getNickName() {
        return mNickName;
    }

    public void setNickName(String nickName) {
        mNickName = nickName;
    }

//    public int getTelNum() {
//        return mTelNum;
//    }
//
//    public void setTelNum(int telNum) {
//        this.mTelNum = telNum;
//    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @NonNull
    @Override
    public String toString() {
        return mNickName;
    }
}
