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

import com.kindsonthegenius.fleetapp.models.Employee;
import com.kindsonthegenius.fleetapp.services.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/Employees")
	public String getEmployees(Model model){
		List<Employee> employeeList = employeeService.getEmployees();
		model.addAttribute("contacts",employeeList);
		return "Employee";
	}
	
	/**
	 * 新增
	 * @param employee
	 * @return
	 */
	@PostMapping("/Employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/Employees";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("Employees/findById")
	@ResponseBody
	public Optional<Employee>findById(int id){
		return employeeService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="Employees/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/Employees";
	}
	
	@RequestMapping(value="Employees/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		employeeService.delete(id);
		return "redirect:/Employees";
	}
}
