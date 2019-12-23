package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Groupe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code_G;
	@Column
	private String nom_G;
	@Column
	private int stade_G;
	

//	@OneToMany(mappedBy = "groupe")
//	List<Patient> patient;
	
	// @OneToMany(mappedBy = "groupe2")
	// List<Patient> patient1;
	 
	 @ManyToMany(mappedBy = "groupe")
	 List<Activite> activite;
}
