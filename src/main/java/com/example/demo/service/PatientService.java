package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	public List<Patient> listAll(){
		return patientRepository.findAll();
	}
	
	public void save(Patient patient) {
		patientRepository.save(patient);
	}
	
	
	public Optional<Patient> deleteByNom(String nom) {
		return patientRepository.deleteByNom(nom);
}	
	public Optional<Patient> getByNom(String nom){
		return patientRepository.findByNom(nom);
	}
	

}
