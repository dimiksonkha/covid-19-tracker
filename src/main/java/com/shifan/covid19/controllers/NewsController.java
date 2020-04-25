/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.controllers;

import com.shifan.covid19.models.News;
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
public class NewsController {
    private List newsList= new ArrayList<>();
    String result;
    
    public void loadData(){
    
         
          try {
          
            String url = "https://newsapi.org/v2/everything?q=COVID&from=2020-03-25&sortBy=publishedAt&apiKey=ce408267c85e44b1b938536c8f538595&pageSize=100&page=1";
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
            
             JSONObject jsonObject = new JSONObject(result.toString());
             JSONArray jsonArray = jsonObject.getJSONArray("articles");
             
              for (int i = 0; i < jsonArray.length(); i++) {
                  JSONObject newsObject = jsonArray.getJSONObject(i);
                  News news = new News();
                  
//                  if(newsObject.isNull(newsObject.getString("auther"))){
//                   
//                  }else{
//                  news.setAuthor(newsObject.getString("author"));
//                  }
                 
                  news.setContent(newsObject.getString("content"));
                  news.setDescription(newsObject.getString("description"));
                  news.setTitle(newsObject.getString("title"));
                  news.setUrl(newsObject.getString("url"));
                  
                  
                  JSONObject source = newsObject.getJSONObject("source");
                  
                  news.setSource(source.getString("name"));
                  
                  newsList.add(news);
              }
   
           
                  
        } catch (Exception e) {
            // TODO: handle exception
        }
    
    }
    
    
    @RequestMapping("/news")
    public String showNews(Model model){
     
     loadData();
     
     model.addAttribute("newsList",newsList);
     model.addAttribute("result", result);
     
       return "news"; 
    }
}
