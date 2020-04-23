/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.controllers;

import com.shifan.covid19.models.CovidStatus;
import com.shifan.covid19.models.Location;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimiksonkha
 */
@Controller
public class HomeController {
    

    List list = new ArrayList<>();
    List locations = new ArrayList<>();
    
    @RequestMapping("/status")
    public String showHomePage(Model model) {
      String newConfirmed = ""; 
      String newRecoverd = "";
      String newDeaths = ""; 
      String totalConfirmed = ""; 
      String totalRecoverd = "";
      String totalDeaths = "";
      
      JSONArray jsonArray =null;
         
          try {
          
            String url = "https://api.covid19api.com/summary";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();
            
//            Extracting Global and Country wise status
              String result = response.toString();
              
              String [] strArray = result.split(",\"Countries");
              result = strArray[0].toString();
              String [] global = result.split("Global\":");
              String globalStatus = global[1];

              JSONObject jsonObject = new JSONObject(globalStatus.toString());
              newConfirmed = jsonObject.getInt("NewConfirmed") + "";
              newRecoverd = jsonObject.getInt("NewRecovered") + "";
              newDeaths = jsonObject.getInt("NewDeaths") + "";
              totalConfirmed = jsonObject.getInt("TotalConfirmed") + "";
              totalRecoverd = jsonObject.getInt("TotalRecovered") + "";
              totalDeaths = jsonObject.getInt("TotalDeaths") + "";
              
              JSONObject jsonObject2 = new JSONObject(response.toString());
              
              jsonArray = jsonObject2.getJSONArray("Countries");
              
              for (int i = 0; i <=jsonArray.length(); i++) {
                  
                  JSONObject tempJsonObject = jsonArray.getJSONObject(i);
                  
                  String country = tempJsonObject.getString("Country");
                  Integer confirmed = tempJsonObject.getInt("TotalConfirmed");
                  Integer recovered = tempJsonObject.getInt("TotalRecovered");
                  Integer deaths = tempJsonObject.getInt("TotalDeaths");
                  
                  CovidStatus cs = new CovidStatus();
                  cs.setCountry(country);
                  cs.setConfirmed(confirmed);
                  cs.setRecovered(recovered);
                  cs.setDeaths(deaths);
                  
                  list.add(cs);
                  
              }
              
              
              
              
              
            
        } catch (Exception e) {
            // TODO: handle exception
        }
         
        
        model.addAttribute("covidStatus", list);
        model.addAttribute("newConfirmed", newConfirmed);
        model.addAttribute("newRecovered", newRecoverd);
        model.addAttribute("newDeaths", newDeaths);
        model.addAttribute("totalConfirmed", totalConfirmed);
        model.addAttribute("totalRecovered", totalRecoverd);
        model.addAttribute("totalDeaths", totalDeaths);
     
        model.addAttribute("jsondata",jsonArray);
     
        return "index";
               
	}
    @RequestMapping("/")
    public String showMap(Model model){
        Location location1 = new Location();
        location1.setLat(23.810);
        location1.setLon(90.412);
        location1.setConfirmed(1000);
        location1.setRecovered(100);
        location1.setDeaths(101);
        
        Location location2 = new Location();
        location2.setLat(23.239);
        location2.setLon(90.187);
        location2.setConfirmed(20);
        location2.setRecovered(3);
        location2.setDeaths(4);
        
        Location location3 = new Location();
        location3.setLat(22.673);
        location3.setLon(89.396);
        location3.setConfirmed(5);
        location3.setRecovered(3);
        location3.setDeaths(1);
        
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        
        model.addAttribute("locations",locations);
        return "map";
    
    }
    
}
