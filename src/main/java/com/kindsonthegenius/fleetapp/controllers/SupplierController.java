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

import com.kindsonthegenius.fleetapp.models.Supplier;
import com.kindsonthegenius.fleetapp.services.SupplierService;

@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/Suppliers")
	public String getSuppliers(Model model){
		List<Supplier> supplierList = supplierService.getSuppliers();
		model.addAttribute("suppliers",supplierList);
		return "Supplier";
	}
	
	/**
	 * 新增
	 * @param supplier
	 * @return
	 */
	@PostMapping("/Suppliers/addNew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/Suppliers";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("Suppliers/findById")
	@ResponseBody
	public Optional<Supplier>findById(int id){
		return supplierService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param supplier
	 * @return
	 */
	@RequestMapping(value="Suppliers/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/Suppliers";
	}
	
	@RequestMapping(value="Suppliers/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		supplierService.delete(id);
		return "redirect:/Suppliers";
	}
}
