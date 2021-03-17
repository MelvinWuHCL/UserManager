package com.example.UserManager.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.mapping.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	private int id;
    Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		
		
		logger.info("Getting all Users");
		Iterable<User> users = userService.GetAllUsers();
		
		
		
		logger.info("Passing users to view");
	    model.addAttribute("users", users);    
		
        return "users";
    }
	
	@PostMapping("/users")
	public String enterID(ModelMap model, @RequestParam(value="id") int userID) {
		
		this.id = userID;
		logger.info("Getting user");
		User user = userService.GetUserById(userID);
		Iterable<User> users = Arrays.asList(user);
		
		
		logger.info("Passing users to view");
	    model.addAttribute("users", users);    
		
        return "edit";
    }
	
	
	@PostMapping("/edit")
	public String editUser(ModelMap model, @RequestParam(value="name") String userName, 
			@RequestParam(value="email") String userEmail, @RequestParam(value="password") String userPass) {
		
		if(!userName.isEmpty() && !userEmail.isEmpty() && !userPass.isEmpty()) {
			User user = new User();
			user.setEmail(userEmail);
			user.setName(userName);
			user.setPassword(userPass);
			user.setId(id);
			userService.UpdateUser(user);
			return "success";
		} else return "fail";
    }

}
