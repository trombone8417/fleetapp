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

import com.kindsonthegenius.fleetapp.models.VehicleMaintenance;
import com.kindsonthegenius.fleetapp.services.SupplierService;
import com.kindsonthegenius.fleetapp.services.VehicleMaintenanceService;
import com.kindsonthegenius.fleetapp.services.VehicleService;

@Controller
public class VehicleMaintenanceController {
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired 
	private VehicleService vehicleService;
	@Autowired 
	private SupplierService supplierService;
	
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/VehicleMaintenances")
	public String getVehicleMaintenances(Model model){
		model.addAttribute("vehicleMaintenances",vehicleMaintenanceService.getVehicleMaintenances());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("suppliers", supplierService.getSuppliers());
		return "VehicleMaintenance";
	}
	
	/**
	 * 新增
	 * @param vehicleMaintenance
	 * @return
	 */
	@PostMapping("/VehicleMaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/VehicleMaintenances";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("VehicleMaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintenance>findById(int id){
		return vehicleMaintenanceService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param vehicleMaintenance
	 * @return
	 */
	@RequestMapping(value="VehicleMaintenances/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/VehicleMaintenances";
	}
	
	@RequestMapping(value="VehicleMaintenances/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/VehicleMaintenances";
	}
}
