package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.example.domain.Date;
import com.example.mapper.DateMapper;

public abstract class IndexController {
	
	@Autowired
	DateMapper datemapper;
	
	@RequestMapping
	public String index (Model model) {
		List<Date> list = datemapper.selectAll();
		model.addAttribute("datemaster",list);
		return "index";
	}

}
