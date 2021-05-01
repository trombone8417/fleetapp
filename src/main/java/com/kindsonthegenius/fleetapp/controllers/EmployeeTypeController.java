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

import com.kindsonthegenius.fleetapp.models.EmployeeType;
import com.kindsonthegenius.fleetapp.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/EmployeeTypes")
	public String getEmployeeTypes(Model model){
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
		model.addAttribute("employeeTypes",employeeTypeList);
		return "EmployeeType";
	}
	
	/**
	 * 新增
	 * @param employeeType
	 * @return
	 */
	@PostMapping("/EmployeeTypes/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/EmployeeTypes";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("EmployeeTypes/findById")
	@ResponseBody
	public Optional<EmployeeType>findById(int id){
		return employeeTypeService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param employeeType
	 * @return
	 */
	@RequestMapping(value="EmployeeTypes/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/EmployeeTypes";
	}
	
	@RequestMapping(value="EmployeeTypes/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		employeeTypeService.delete(id);
		return "redirect:/EmployeeTypes";
	}
}
