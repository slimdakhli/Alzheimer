package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Activite;
import com.example.demo.repository.ActiviteRepository;

@Service
public class ActiviteService {

	@Autowired
	ActiviteRepository activiteRepository;
	
	public List<Activite> listAll(){
		return activiteRepository.findAll();
	}
	
	public void save(Activite activite) {
		activiteRepository.saveAndFlush(activite);
	}
	public Optional<Activite> deleteByNom(String nom){
	return activiteRepository.deleteByNom(nom);
	}
	public Optional<Activite> getByNom(String nom){
		return activiteRepository.findByNom(nom);
	}
}
