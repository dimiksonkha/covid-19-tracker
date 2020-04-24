/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.models;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author dimiksonkha
 * 

    "phones": [
      {
        "id": "1",
        "location_id": "1",
        "number": " +1 (813) 559-1888",
        "extension": "None",
        "type": "Office",
        "language": "EN",
        "description": "description"
      }
    ],
    "regular_schedule": [
      {
        "id": "1",
        "location_id": "1",
        "weekday": "1",
        "opens_at": "9:00 AM",
        "closes_at": "12:00 PM"
      },
      {
        "id": "1",
        "location_id": "1",
        "weekday": "2",
        "opens_at": "9:00 AM",
        "closes_at": "12:00 PM"
      },
      {
        "id": "1",
        "location_id": "1",
        "weekday": "3",
        "opens_at": "9:00 AM",
        "closes_at": "12:00 PM"
      },
      {
        "id": "1",
        "location_id": "1",
        "weekday": "4",
        "opens_at": "9:00 AM",
        "closes_at": "12:00 PM"
      },
      {
        "id": "1",
        "location_id": "1",
        "weekday": "5",
        "opens_at": "9:00 AM",
        "closes_at": "12:00 PM"
      },
      {
        "id": "1",
        "location_id": "1",
        "weekday": "6",
        "opens_at": "9:00 AM",
        "closes_at": "12:00 PM"
      },
      {
        "id": "1",
        "location_id": "1",
        "weekday": "7",
        "opens_at": "9:00 AM",
        "closes_at": "12:00 PM"
      }

 */
public class CovidLab {
    
    private String name;
    private String alternateName;
    private String description;
    private String transportation;
    private Address physicalAddress;
    private String phone;
    private ArrayList<Schedule> schedules;

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(Address physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
            }   
