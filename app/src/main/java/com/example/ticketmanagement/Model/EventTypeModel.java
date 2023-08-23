package com.example.ticketmanagement.Model;

public class EventTypeModel {

    private int eventTypeId;
    private String name;

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EventTypeModel{" +
                "eventTypeId=" + eventTypeId +
                ", name='" + name + '\'' +
                '}';
    }

    public EventTypeModel(int eventTypeId, String name) {
        this.eventTypeId = eventTypeId;
        this.name = name;
    }

}