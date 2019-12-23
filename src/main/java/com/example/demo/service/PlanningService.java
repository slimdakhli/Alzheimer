package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Planning;
import com.example.demo.repository.PlanningRepository;

@Service
public class PlanningService {

	@Autowired
	PlanningRepository planningRepository;
	
	public List<Planning> findAll(){
		return planningRepository.findAll();
	}
}
