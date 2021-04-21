package com.kindsonthegenius.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMovementController {
	@GetMapping("/VehicleMovements")
	public String getVehicleMovement(){
		return "VehicleMovement";
	}
}
