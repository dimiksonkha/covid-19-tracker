/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.controllers;

import com.shifan.covid19.models.CovidStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimiksonkha
 */
@Controller
public class HomeController {
    
    private List<CovidStatus> covidStatues = new ArrayList<CovidStatus>();
    CovidStatus covSta1= new CovidStatus("Bangladesh", 2445, 12.17, 75, 91);
    
    @RequestMapping("/")
    public String showMessage(Model model) {
	model.addAttribute("status",covSta1);
        return "index";
               
	}
    
}
