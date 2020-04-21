/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.models;

/**
 *
 * @author dimiksonkha
 *  "Country": "ALA Aland Islands",
            "CountryCode": "AX",
            "Slug": "ala-aland-islands",
            "NewConfirmed": 0,
            "TotalConfirmed": 0,
            "NewDeaths": 0,
            "TotalDeaths": 0,
            "NewRecovered": 0,
            "TotalRecovered": 0,
            "Date": "2020-04-21T15:31:29Z"
 */
public class CovidStatus {
    private String  country;
    private Integer confirmed;
    private Integer recovered;
    private Integer deaths;
    
    
    public CovidStatus(){
    
    }
    
    public CovidStatus(String  country,Integer confirmed,
            Integer recovered,Integer deaths){
        this.country = country;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;  
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }
}
