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

import com.kindsonthegenius.fleetapp.models.InvoiceStatus;
import com.kindsonthegenius.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/invoiceStatuses")
	public String getinvoiceStatuses(Model model){
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
		model.addAttribute("invoiceStatuss",invoiceStatusList);
		return "InvoiceStatus";
	}
	
	/**
	 * 新增
	 * @param invoiceStatus
	 * @return
	 */
	@PostMapping("/invoiceStatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("invoiceStatuses/findById")
	@ResponseBody
	public Optional<InvoiceStatus>findById(int id){
		return invoiceStatusService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param invoiceStatus
	 * @return
	 */
	@RequestMapping(value="invoiceStatuses/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	@RequestMapping(value="invoiceStatuses/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}
}
