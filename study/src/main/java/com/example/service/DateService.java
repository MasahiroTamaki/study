package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Date;
import com.example.mapper.DateMapper;

@Service
public class DateService {
	
	@Autowired
	private DateMapper dateMapper;
	
	@Transactional
	public List<Date> search(){
		return dateMapper.select();
	}

	@Transactional
	public Date search(String dateId) {
		return dateMapper.selectPK(dateId);
	}
	
	@Transactional
	public void save(Date date) {
		dateMapper.save(date);
	}	
	
	@Transactional
	public void update(Date date) {
		dateMapper.update(date);
	}	
	
	@Transactional
	public void delete(String dateId) {
		dateMapper.deletePK(dateId);
	}

	public List<Date> calculation(String baseDate){
		List<Date> dateFormulae = dateMapper.select();
		List<Date> dates = new ArrayList<>();
		dateFormulae.stream().forEach(d -> dates.add(d.DateConversion(baseDate)));
		return dates;
	}	
}
