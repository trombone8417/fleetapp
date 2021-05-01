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

import com.kindsonthegenius.fleetapp.models.VehicleMovement;
import com.kindsonthegenius.fleetapp.services.VehicleMovementService;

@Controller
public class VehicleMovementController {
	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/VehicleMovements")
	public String getVehicleMovements(Model model){
		List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
		model.addAttribute("vehicleMovements",vehicleMovementList);
		return "VehicleMovement";
	}
	
	/**
	 * 新增
	 * @param vehicleMovement
	 * @return
	 */
	@PostMapping("/VehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/VehicleMovements";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("VehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement>findById(int id){
		return vehicleMovementService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param vehicleMovement
	 * @return
	 */
	@RequestMapping(value="VehicleMovements/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/VehicleMovements";
	}
	
	@RequestMapping(value="VehicleMovements/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/VehicleMovements";
	}
}
