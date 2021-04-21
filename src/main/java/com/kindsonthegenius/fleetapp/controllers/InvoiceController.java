package com.kindsonthegenius.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {
	@GetMapping("/Invoices")
	public String getInvoice(){
		return "Invoice";
	}
}
