package com.xiaoming.mygymclub.entities;

import java.util.Date;

public class Course {
    private String name;
    private String description;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course(String name, String description, Date date) {

        this.name = name;
        this.description = description;
        this.date = date;
    }
}
