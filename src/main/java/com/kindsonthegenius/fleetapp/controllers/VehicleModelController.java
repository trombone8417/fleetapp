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

import com.kindsonthegenius.fleetapp.models.VehicleModel;
import com.kindsonthegenius.fleetapp.services.VehicleModelService;

@Controller
public class VehicleModelController {
	@Autowired
	private VehicleModelService vehicleModelService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/VehicleModels")
	public String getVehicleModels(Model model){
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels",vehicleModelList);
		return "VehicleModel";
	}
	
	/**
	 * 新增
	 * @param vehicleModel
	 * @return
	 */
	@PostMapping("/VehicleModels/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/VehicleModels";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("VehicleModels/findById")
	@ResponseBody
	public Optional<VehicleModel>findById(int id){
		return vehicleModelService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param vehicleModel
	 * @return
	 */
	@RequestMapping(value="VehicleModels/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/VehicleModels";
	}
	
	@RequestMapping(value="VehicleModels/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		vehicleModelService.delete(id);
		return "redirect:/VehicleModels";
	}
}
