package com.ezerski.vladislav.virtualstock.dto;

import android.support.v7.app.AppCompatActivity;

public class Robot extends AppCompatActivity{

    public int ID;
    public double latitude;
    public double longitude;
    public double movement_direction;

    public Robot() {
    }

    public Robot(int ID, double latitude, double longitude, double movement_direction) {
        this.ID = ID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.movement_direction = movement_direction;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getMovement_direction() {
        return movement_direction;
    }

    public void setMovement_direction(double movement_direction) {
        this.movement_direction = movement_direction;
    }
}
