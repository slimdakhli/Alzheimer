package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Activite;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {

		Optional<Activite>  findByNom(String nom);
		Optional<Activite> deleteByNom(String nom);
	
	
	
	
	
	
	
}
