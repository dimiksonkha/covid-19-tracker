/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.models;

/**
 *
 * @author dimiksonkha
 */
public class LatLng {
    private Double Lat;
    private Double Lng;

    public LatLng(Double lat, Double lng){
        this.Lat =lat;
        this.Lng =lng;
    }
    public Double getLat() {
        return Lat;
    }

    public void setLat(Double Lat) {
        this.Lat = Lat;
    }

    public Double getLng() {
        return Lng;
    }

    public void setLng(Double Lng) {
        this.Lng = Lng;
    }
    
    
}
