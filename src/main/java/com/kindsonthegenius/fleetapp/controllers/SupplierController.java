package com.kindsonthegenius.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
	@GetMapping("/Suppliers")
	public String getSupplier(){
		return "Supplier";
	}
}
