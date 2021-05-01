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

import com.kindsonthegenius.fleetapp.models.JobTitle;
import com.kindsonthegenius.fleetapp.services.JobTitleService;

@Controller
public class JobTitleController {
	@Autowired
	private JobTitleService jobTitleService;
	
	/**
	 * 主頁
	 * @param model
	 * @return
	 */
	@GetMapping("/JobTitles")
	public String getJobTitles(Model model){
		List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
		model.addAttribute("jobTitles",jobTitleList);
		return "JobTitle";
	}
	
	/**
	 * 新增
	 * @param jobTitle
	 * @return
	 */
	@PostMapping("/JobTitles/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/JobTitles";
	}
	/**
	 * 帶出編輯資料
	 * @param id
	 * @return
	 */
	@RequestMapping("JobTitles/findById")
	@ResponseBody
	public Optional<JobTitle>findById(int id){
		return jobTitleService.findById(id);
	}
	/**
	 * 更新並返回新資料
	 * @param jobTitle
	 * @return
	 */
	@RequestMapping(value="JobTitles/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/JobTitles";
	}
	
	@RequestMapping(value="JobTitles/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String delete(Integer id) {
		jobTitleService.delete(id);
		return "redirect:/JobTitles";
	}
}
