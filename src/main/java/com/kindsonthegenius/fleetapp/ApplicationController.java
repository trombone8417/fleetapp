package com.kindsonthegenius.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	@GetMapping("/")
	public String goHome(){
		return "index";
	}
	@GetMapping("/login")
	public String Login(){
		return "login";
	}
	@GetMapping("/logout")
	public String Logout(){
		return "logout";
	}
}
