package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisAVis extends Personne{

	
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code_v;
	@Column
	private String nom_v;
	@Column
	private String prenom_v;
	@Column
	private String relation_v;
	@Column
	private String proffesion_v;
	@Column
	private int age_v;
	@Column
	private String etat_civil_v;
	
	@OneToMany(mappedBy = "visAvis")
	List<Patient> patients = new ArrayList<Patient>();
	
	@OneToMany(mappedBy ="visAvis")
	List<Reservation> reservation = new ArrayList<Reservation>();
}
