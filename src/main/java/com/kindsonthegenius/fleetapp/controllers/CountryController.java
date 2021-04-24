package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.services.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/Countries")
	public String getCountries(Model model){
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries",countryList);
		return "Country";
	}
	
	/**
	 * 新增
	 * @param country
	 * @return
	 */
	@PostMapping("/Countries/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/Countries";
	}
}
