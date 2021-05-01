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

import com.kindsonthegenius.fleetapp.models.VehicleStatus;
import com.kindsonthegenius.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/vehicleStatuses")
	public String getvehicleStatuses(Model model){
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getvehicleStatuses();
		model.addAttribute("vehicleStatuss",vehicleStatusList);
		return "VehicleStatus";
	}
	
	/**
	 * 新增
	 * @param vehicleStatus
	 * @return
	 */
	@PostMapping("/vehicleStatuses/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("vehicleStatuses/findById")
	@ResponseBody
	public Optional<VehicleStatus>findById(int id){
		return vehicleStatusService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param vehicleStatus
	 * @return
	 */
	@RequestMapping(value="vehicleStatuses/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}
	
	@RequestMapping(value="vehicleStatuses/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatuses";
	}
}
