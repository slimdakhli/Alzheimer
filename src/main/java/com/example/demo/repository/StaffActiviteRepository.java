package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StaffActivite;

@Repository
public interface StaffActiviteRepository extends JpaRepository<StaffActivite, Long>{
	Optional<StaffActivite> findByNom(String nom);
	
	

}
