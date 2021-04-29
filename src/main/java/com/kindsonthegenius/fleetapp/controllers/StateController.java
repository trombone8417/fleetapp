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
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class StateController {
	@Autowired
	private StateService stateService;
	@Autowired 
	private CountryService countryService;
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/States")
	public String getStates(Model model){
//		撈出states的資料
		List<State> stateList = stateService.getStates();
		model.addAttribute("states",stateList);
//		撈出新增DropDownList countries的資料
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries",countryList);
		return "State";
	}
	
	/**
	 * 新增
	 * @param state
	 * @return
	 */
	@PostMapping("/States/addNew")
	public String addNew(State state) {
		stateService.save(state);
		return "redirect:/States";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("States/findById")
	@ResponseBody
	public Optional<State>findById(int id){
		return stateService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param state
	 * @return
	 */
	@RequestMapping(value="States/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(State state) {
		stateService.save(state);
		return "redirect:/States";
	}
	
	@RequestMapping(value="States/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		stateService.delete(id);
		return "redirect:/States";
	}
}
