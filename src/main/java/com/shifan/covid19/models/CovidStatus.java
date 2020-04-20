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
public class CovidStatus {
    private String  country;
    private Integer confirmed;
    private Double  casesPerMillion; 
    private Integer recovered;
    private Integer deaths;
    
    public CovidStatus(String  country,Integer confirmed, Double  casesPerMillion,
            Integer recovered,Integer deaths){
        this.country = country;
        this.confirmed = confirmed;
        this.casesPerMillion = casesPerMillion;
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

    public Double getCasesPerMillion() {
        return casesPerMillion;
    }

    public void setCasesPerMillion(Double casesPerMillion) {
        this.casesPerMillion = casesPerMillion;
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

    public void setDeaths(Integer Deaths) {
        this.deaths = deaths;
    }
}
