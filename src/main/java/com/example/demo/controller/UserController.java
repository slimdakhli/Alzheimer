package com.example.demo.controller;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Personne;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/login")
    public String showSignUpLogin(User user) {
        return "login";
    }
	
	@PostMapping("/login_auth")
	public String login_Auth(@Valid User user, BindingResult result, Model model) {
		 if (result.hasErrors()) {
	            return "login";
	        }
		  String sts =user.getLogin();
	      String nt = user.getNature();
	      User userToLog ;
	      userToLog = userService.getByLogin(sts).orElseThrow(()-> new NoSuchElementException());
	      if(user.getPassword().equals(userToLog.getPassword())&& nt.equalsIgnoreCase("medecin")) {
	        	return "medecin";
	        }else 
	      		if(user.getPassword().equals(userToLog.getPassword())&& nt.equalsIgnoreCase("admin")) {
	        	return "admin";
	        }else 
	      		if(user.getPassword().equals(userToLog.getPassword())&& nt.equalsIgnoreCase("psychiatre")) {
	        	return "psychiatre";
	        }else 
	      		if(user.getPassword().equals(userToLog.getPassword())&& nt.equalsIgnoreCase("visavis")) {
	        	return "visavis";
	        }else 
	      		if(user.getPassword().equals(userToLog.getPassword())&& nt.equalsIgnoreCase("infirmier")) {
	        	return "infirmier";
	        }else 
	      		if(user.getPassword().equals(userToLog.getPassword())&& nt.equalsIgnoreCase("staff")) {
	        	return "staffactivite";
	        }else {
	      		
	      return "login";}
	}
	
	
	

	 @GetMapping("/signup")
	    public String showSignUpForm(User user) {
	        return "add-user";
	    }

	    @PostMapping("/adduser")
	    public String addUser(@Valid User user, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-user";
	        }
	     
	        userService.save(user);			
	        model.addAttribute("users", userService.listAll());
	       
	        
	        return "redirect:/login";
	    }		//"index"


}