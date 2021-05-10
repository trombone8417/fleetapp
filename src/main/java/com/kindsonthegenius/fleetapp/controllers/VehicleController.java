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
import com.kindsonthegenius.fleetapp.services.EmployeeService;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.VehicleMakeService;
import com.kindsonthegenius.fleetapp.services.VehicleModelService;
import com.kindsonthegenius.fleetapp.services.VehicleService;
import com.kindsonthegenius.fleetapp.services.VehicleStatusService;
import com.kindsonthegenius.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	@Autowired 
	private VehicleTypeService vehicleTypeService;
	@Autowired 
	private VehicleMakeService vehicleMakeService;
	@Autowired 
	private VehicleModelService vehicleModelService;
	@Autowired 
	private LocationService locationService;
	@Autowired 
	private EmployeeService employeeService ;
	@Autowired 
	private VehicleStatusService vehicleStatusService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/Vehicles")
	public String getVehicles(Model model){
		model.addAttribute("vehicles",vehicleService.getVehicles());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getvehicleStatuses());
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
