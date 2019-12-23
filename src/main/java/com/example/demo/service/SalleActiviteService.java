package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SalleActivite;
import com.example.demo.repository.SalleActiviteRepository;

@Service
public class SalleActiviteService {

	@Autowired
	SalleActiviteRepository salleActiviteRepository;
	
	public List<SalleActivite> listAll() {
		return salleActiviteRepository.findAll();
	}
	public void save(SalleActivite salleActivite) {
		salleActiviteRepository.save(salleActivite);
	}
	public Optional<SalleActivite> getByNumSalle(String numSalle){
		return salleActiviteRepository.findBynumSalle(numSalle);
	}
	public Optional<SalleActivite> deleteByNumSalle(long numSalle){
		return salleActiviteRepository.deleteBynumSalle(numSalle);
	}
}
