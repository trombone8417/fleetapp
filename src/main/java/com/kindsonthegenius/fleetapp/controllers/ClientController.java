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

import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.services.ClientService;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/Clients")
	public String getClients(Model model){
		List<Client> clientList = clientService.getClients();
		model.addAttribute("countries",clientList);
		return "Client";
	}
	
	/**
	 * 新增
	 * @param client
	 * @return
	 */
	@PostMapping("/Clients/addNew")
	public String addNew(Client client) {
		clientService.save(client);
		return "redirect:/Clients";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("Clients/findById")
	@ResponseBody
	public Optional<Client>findById(int id){
		return clientService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param client
	 * @return
	 */
	@RequestMapping(value="Clients/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/Clients";
	}
	
	@RequestMapping(value="Clients/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		clientService.delete(id);
		return "redirect:/Clients";
	}
}
