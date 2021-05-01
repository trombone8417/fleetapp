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

import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/VehicleTypes")
	public String getVehicleTypes(Model model){
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
		model.addAttribute("vehicleTypes",vehicleTypeList);
		return "VehicleType";
	}
	
	/**
	 * 新增
	 * @param vehicleType
	 * @return
	 */
	@PostMapping("/VehicleTypes/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/VehicleTypes";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("VehicleTypes/findById")
	@ResponseBody
	public Optional<VehicleType>findById(int id){
		return vehicleTypeService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param vehicleType
	 * @return
	 */
	@RequestMapping(value="VehicleTypes/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/VehicleTypes";
	}
	
	@RequestMapping(value="VehicleTypes/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		vehicleTypeService.delete(id);
		return "redirect:/VehicleTypes";
	}
}
