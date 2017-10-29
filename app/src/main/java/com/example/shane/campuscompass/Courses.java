package com.example.shane.campuscompass;

/**
 * Created by Shane on 10/29/2017.
 */

public class Courses {
    private int id;
    private String name;
    private String location;
    private int time;
    private String dow;

    //Constructor

    public Courses(int id, String name, String location, int time, String dow) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.time = time;
        this.dow = dow;
    }

    //setter getter
    public String getdow() {
        return dow;
    }

    public void setdow( String dow) {
        this.dow = dow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
