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

import com.kindsonthegenius.fleetapp.models.Contact;
import com.kindsonthegenius.fleetapp.services.ContactService;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	@Autowired 
	private StateService stateService;
	@Autowired 
	private CountryService countryService;	
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/Contacts")
	public String getContacts(Model model){
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("contacts", contactService.getContacts());
		return "Contact";
	}
	
	/**
	 * 新增
	 * @param contact
	 * @return
	 */
	@PostMapping("/Contacts/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/Contacts";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("Contacts/findById")
	@ResponseBody
	public Optional<Contact>findById(int id){
		return contactService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param contact
	 * @return
	 */
	@RequestMapping(value="Contacts/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/Contacts";
	}
	
	@RequestMapping(value="Contacts/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		contactService.delete(id);
		return "redirect:/Contacts";
	}
}
