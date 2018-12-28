package com.xiaoming.mygymclub.entities;

public class Coach {
    private String name;
    private String sex;
    private Course course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Coach(String name, String sex, Course course) {

        this.name = name;
        this.sex = sex;
        this.course = course;
    }

    public Coach(String name, String sex) {

        this.name = name;
        this.sex = sex;
    }
}
