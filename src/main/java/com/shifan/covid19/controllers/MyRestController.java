/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.controllers;

import com.shifan.covid19.models.CovidStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dimiksonkha
 */
@RestController
public class MyRestController {
    
    List list = new ArrayList<>();
    CovidStatus cs1= new CovidStatus("Worldwide", 2435876, 639239, 167369);
    CovidStatus cs2= new CovidStatus("Bangladesh", 2948, 85, 101);
    CovidStatus cs3= new CovidStatus("India", 17656,2842, 559);
    
    @GetMapping("/hello")
    public String showMessage(Model model){
        list.add(cs1);
        list.add(cs2);
        list.add(cs3);
        
        model.addAttribute("covidStatus", list);
        return "index";
    }
}
