/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimiksonkha
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String showMessage() {
		return "index";
	}
    
}
