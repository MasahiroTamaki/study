package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Date;
import com.example.service.DateService;

@Controller
@RequestMapping("/dates")
public class DateController {
	
	@Autowired
	private DateService dateService;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("dates",dateService.search());
		return "dates/index";
	}
	
	@GetMapping("new")
	public String newDate(Model model) {
		return "dates/new";
	}
	
	@GetMapping("edit/{dateId}")
	public String edit(@PathVariable String dateId, Model model) {
		model.addAttribute("date",dateService.search(dateId));
		return "dates/edit";
	}

	@PostMapping
	public String create(@ModelAttribute Date date) {
		dateService.save(date);
		return "redirect:/dates";
	}
	
	@PutMapping("{dateId}")
	public String update(@PathVariable String dateId,@ModelAttribute Date date) {
		date.setDateId(dateId);
		dateService.update(date);
		return "redirect:/dates"; 
	}
	
	@DeleteMapping("{dateId}")
	public String destroy(@PathVariable String dateId) {
		dateService.delete(dateId);
		return "redirect:/dates"; 
	}
	
	@PostMapping("culculate")
	public String culculate(@ModelAttribute("baseDate") String baseDate,Model model) {
		model.addAttribute("resultDate",dateService.calculation(baseDate));
		model.addAttribute("baseDate",baseDate);
        return "dates/index";
	}
	
}

