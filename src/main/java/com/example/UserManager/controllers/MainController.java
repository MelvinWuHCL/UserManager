package com.example.UserManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class MainController {
	
	 @GetMapping(value="/")
     public String showIndexPage(ModelMap model, 
    		 @RequestParam(value="name", required=false, defaultValue="World") String name){
	     model.addAttribute("name", name);    
		 return "index";
     }

}

