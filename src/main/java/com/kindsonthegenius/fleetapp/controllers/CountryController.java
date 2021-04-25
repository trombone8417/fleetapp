package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("Countries/findById")
	@ResponseBody
	public Optional<Country>findById(int id){
		return countryService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param country
	 * @return
	 */
	@RequestMapping(value="Countries/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/Countries";
	}
}
