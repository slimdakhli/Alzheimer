package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medecin extends Personne {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code_M;
	@Column
	private String nom_M;
	@Column
	private String prenom_M;
	@Column
	private String sexe_M;
	@Column
	private String specialite_M;

}