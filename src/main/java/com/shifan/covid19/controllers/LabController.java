/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.controllers;

import com.shifan.covid19.models.Address;
import com.shifan.covid19.models.CovidLab;
import com.shifan.covid19.models.Schedule;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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
public class LabController {
    
    private List labs= new ArrayList<>();
    String result;
    
    public void loadData(){
    
         
          try {
          
            String url = "https://covid-19-testing.github.io/locations/florida/complete.json";
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
            } 
            in .close();
            
            
             result = response.toString();
            
              JSONArray jsonArray =  new JSONArray(result.toString());
              
           
              for (int i = 0; i <=jsonArray.length(); i++) {
                  
                  JSONObject tempJsonObject = jsonArray.getJSONObject(i);
                  CovidLab lab = new CovidLab();
                  lab.setName(tempJsonObject.getString("name"));
                  lab.setAlternateName(tempJsonObject.getString("alternate_name"));
                  lab.setDescription(tempJsonObject.getString("description"));
                  lab.setTransportation(tempJsonObject.getString("transportation"));
                  
                  Address address = new Address();
                  JSONArray jsonArray2 = tempJsonObject.getJSONArray("physical_address");
                  JSONObject tempJsonObject2 = jsonArray2.getJSONObject(0);
                  address.setAddressOne(tempJsonObject2.getString("address_1"));
                  address.setCity(tempJsonObject2.getString("city"));
                  address.setRegion(tempJsonObject2.getString("region"));
                  address.setStateProvince(tempJsonObject2.getString("state_province"));
                  address.setPostalCode(tempJsonObject2.getString("postal_code"));
                  address.setCountry(tempJsonObject2.getString("country"));
                  
                  JSONArray phoneArray = tempJsonObject.getJSONArray("phones");
                  JSONObject phoneObject = phoneArray.getJSONObject(0);
                  
                  JSONArray scheduleArray = tempJsonObject.getJSONArray("regular_schedule");
                  
                  ArrayList schedules = new ArrayList();
                  for (int j = 0; j < scheduleArray.length(); j++) {
                       JSONObject scheduleObject = scheduleArray.getJSONObject(j);
                       Schedule schedule = new Schedule();
                       schedule.setWeekDay(scheduleObject.getString("weekday"));
                       schedule.setOpensAt(scheduleObject.getString("opens_at"));
                       schedule.setClosesAt(scheduleObject.getString("closes_at"));
                       schedules.add(schedule);
          
                  }
                  lab.setPhysicalAddress(address);
                  lab.setPhone(phoneObject.getString("number"));
                  lab.setSchedules(schedules);
                  labs.add(lab);
                  
              } 
                  
        } catch (Exception e) {
            // TODO: handle exception
        }
    
    }
    
    @RequestMapping("/labs")
    public String showLabs(Model model){
     
     loadData();
     
     model.addAttribute("labs",labs);
     
       return "lab"; 
    }
}
