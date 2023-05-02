package com.example.currentaddress.models;

import java.util.ArrayList;

public class Hotel {

    public Integer hotel_id;

    public ArrayList<Room> rooms;

    public ArrayList<Reservation> reservations;

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Room getRoom(Integer index){
        return this.rooms.get(index);
    }

    public void setRoom(Room room){
        this.rooms.add(room);
    }

    public Reservation getReservation(Integer index){
        return this.reservations.get(index);
    }

    public void setReservation(Reservation reservation){
        this.reservations.add(reservation);
    }
}
