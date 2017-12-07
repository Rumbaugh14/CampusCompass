package com.example.shane.campuscompass;

/**
 * Created by Shane on 10/29/2017.
 */

public class Course {
    private int id;
    private String name;
    private String location;
    private String timeSt;
    private String timeEd;
    private String dow;

    //Constructor

    public Course(int id, String name, String location, String timeS,String timeE, String dow) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.timeSt = timeS;
        this.timeEd = timeE;
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

    public String getTimeSt() {
        return timeSt;
    }

    public void setTimeSt(String time) {
        this.timeSt = time;
    }
    public String getTimeEd() {
        return timeEd;
    }

    public void setTimeEd(String time) {
        this.timeEd = time;
    }
}
