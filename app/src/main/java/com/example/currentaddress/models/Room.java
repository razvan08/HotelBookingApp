package com.example.currentaddress.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {

    public Integer room_id;

    public RoomType room_type;

    public ArrayList<String> facilities;

    public Boolean isAvailable;

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public RoomType getRoom_type() {
        return room_type;
    }

    public void setRoom_type(RoomType room_type) {
        this.room_type = room_type;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void addFacility(String facility){
        this.facilities.add(facility);
    }

    public String getFacility(int facility_index){
        return this.facilities.get(facility_index);
    }
}
