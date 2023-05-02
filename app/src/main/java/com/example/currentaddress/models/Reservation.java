package com.example.currentaddress.models;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {

    public Customer_Test customer;

    public  Room reserved_room;

    public String start_date;

    public Integer no_of_days;

    public Customer_Test getCustomer() {
        return customer;
    }

    public void setCustomer(Customer_Test customer) {
        this.customer = customer;
    }

    public Room getReserved_room() {
        return reserved_room;
    }

    public void setReserved_room(Room reserved_room) {
        this.reserved_room = reserved_room;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public Integer getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(Integer no_of_days) {
        this.no_of_days = no_of_days;
    }
}
