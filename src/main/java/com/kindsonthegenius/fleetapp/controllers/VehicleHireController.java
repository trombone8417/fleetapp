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

import com.kindsonthegenius.fleetapp.models.VehicleHire;
import com.kindsonthegenius.fleetapp.services.VehicleHireService;

@Controller
public class VehicleHireController {
	@Autowired
	private VehicleHireService vehicleHireService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/VehicleHires")
	public String getVehicleHires(Model model){
		List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
		model.addAttribute("vehicleHires",vehicleHireList);
		return "VehicleHire";
	}
	
	/**
	 * 新增
	 * @param vehicleHire
	 * @return
	 */
	@PostMapping("/VehicleHires/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/VehicleHires";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("VehicleHires/findById")
	@ResponseBody
	public Optional<VehicleHire>findById(int id){
		return vehicleHireService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param vehicleHire
	 * @return
	 */
	@RequestMapping(value="VehicleHires/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/VehicleHires";
	}
	
	@RequestMapping(value="VehicleHires/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/VehicleHires";
	}
}
