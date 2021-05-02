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
import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class LocationController {
	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private LocationService locationService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/Locations")
	public String getLocations(Model model){
		List<State> stateList = stateService.getStates();
		List<Country> countryList = countryService.getCountries();
		List<Location> locationList = locationService.getLocations();
		model.addAttribute("states",stateList);
		model.addAttribute("countries",countryList);
		model.addAttribute("locations",locationList);
		return "Location";
	}
	
	/**
	 * 新增
	 * @param location
	 * @return
	 */
	@PostMapping("/Locations/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/Locations";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("Locations/findById")
	@ResponseBody
	public Optional<Location>findById(int id){
		return locationService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param location
	 * @return
	 */
	@RequestMapping(value="Locations/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/Locations";
	}
	
	@RequestMapping(value="Locations/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		locationService.delete(id);
		return "redirect:/Locations";
	}
}