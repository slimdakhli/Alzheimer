package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Activite;
import com.example.demo.entity.Planning;
import com.example.demo.repository.ActiviteRepository;
import com.example.demo.repository.StaffActiviteRepository;

@Service
public class StaffActiviteService {

	

	@Autowired
	ActiviteRepository activiteRepository;
	
	public List<Activite> listAllAc(){
		return activiteRepository.findAll();
	}
	
	
}
