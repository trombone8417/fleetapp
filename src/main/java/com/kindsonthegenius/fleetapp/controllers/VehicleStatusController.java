package com.kindsonthegenius.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleStatusController {
	@GetMapping("/VehicleStatus")
	public String getVehicleMovement(){
		return "VehicleStatus";
	}
}
