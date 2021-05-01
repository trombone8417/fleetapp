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

import com.kindsonthegenius.fleetapp.models.Vehicle;
import com.kindsonthegenius.fleetapp.services.VehicleService;

@Controller
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/Vehicles")
	public String getVehicles(Model model){
		List<Vehicle> vehicleList = vehicleService.getVehicles();
		model.addAttribute("vehicles",vehicleList);
		return "Vehicle";
	}
	
	/**
	 * 新增
	 * @param vehicle
	 * @return
	 */
	@PostMapping("/Vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/Vehicles";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("Vehicles/findById")
	@ResponseBody
	public Optional<Vehicle>findById(int id){
		return vehicleService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param vehicle
	 * @return
	 */
	@RequestMapping(value="Vehicles/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/Vehicles";
	}
	
	@RequestMapping(value="Vehicles/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		vehicleService.delete(id);
		return "redirect:/Vehicles";
	}
}
