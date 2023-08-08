package com.example.ticketmanagement.Model;

public class VenueModel {
    private int venueId;
    private String location;
    private String type;
    private int capacity;

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "VenueModel{" +
                "venueId=" + venueId +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}