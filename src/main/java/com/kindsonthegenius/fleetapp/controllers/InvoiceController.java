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

import com.kindsonthegenius.fleetapp.models.Invoice;
import com.kindsonthegenius.fleetapp.services.InvoiceService;

@Controller
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/Invoices")
	public String getInvoices(Model model){
		List<Invoice> invoiceList = invoiceService.getInvoices();
		model.addAttribute("invoices",invoiceList);
		return "Invoice";
	}
	
	/**
	 * 新增
	 * @param invoice
	 * @return
	 */
	@PostMapping("/Invoices/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/Invoices";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("Invoices/findById")
	@ResponseBody
	public Optional<Invoice>findById(int id){
		return invoiceService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param invoice
	 * @return
	 */
	@RequestMapping(value="Invoices/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/Invoices";
	}
	
	@RequestMapping(value="Invoices/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		invoiceService.delete(id);
		return "redirect:/Invoices";
	}
}
