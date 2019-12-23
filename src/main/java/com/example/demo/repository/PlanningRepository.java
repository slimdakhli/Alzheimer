package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Planning;

public interface PlanningRepository extends JpaRepository<Planning, Long> {
	
	Optional<Planning> findById(Long id);

}
