package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Date;
import com.example.mapper.DateMapper;

@Controller
public class IndexController {
	
	@Autowired
	DateMapper datemapper;
	
	@RequestMapping("/study")
	public String index (Model model) {
		List<Date> list = datemapper.selectAll();
		model.addAttribute("datemaster",list);
		return "date/index";
	}

}
