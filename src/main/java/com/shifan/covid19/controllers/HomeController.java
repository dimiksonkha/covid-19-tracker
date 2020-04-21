/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.controllers;

import com.shifan.covid19.models.CovidStatus;
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
public class HomeController {
    

    List list = new ArrayList<>();
    
    @RequestMapping("/")
    public String showHomePage(Model model) {
       
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
        model.addAttribute("totalConfirmed", totalConfirmed);
        model.addAttribute("totalRecovered", totalRecoverd);
        model.addAttribute("totalDeaths", totalDeaths);
     
        model.addAttribute("jsondata",jsonArray);
     
        return "index";
               
	}
    
}
