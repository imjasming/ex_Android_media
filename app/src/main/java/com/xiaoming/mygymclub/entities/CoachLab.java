package com.xiaoming.mygymclub.entities;

import java.util.ArrayList;

public class CoachLab {
    private ArrayList<Coach> mCoaches = new ArrayList<>();
    private static CoachLab instance;

    private CoachLab(){}

    public void addCoach(Coach coach){
        mCoaches.add(coach);
    }

    public ArrayList<Coach> getCoaches() {
        return mCoaches;
    }

    public void addAllCoaches(ArrayList<Coach> coaches) {
        mCoaches = coaches;
    }

    public static CoachLab getInstance() {
        if (instance == null){
            instance = new CoachLab();
        }
        return instance;
    }

    public static void setInstance(CoachLab instance) {
        CoachLab.instance = instance;
    }
}
