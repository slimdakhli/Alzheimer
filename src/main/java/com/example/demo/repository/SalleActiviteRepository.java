package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SalleActivite;

@Repository
public interface SalleActiviteRepository extends JpaRepository<SalleActivite, Long>{

	Optional<SalleActivite> findBynumSalle(String numSalle);
	Optional<SalleActivite> deleteBynumSalle(Long numSalle);
}
