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
@AllArgsConstructor
@NoArgsConstructor
public class Infirmier extends Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code_I;
	@Column
	private String nom_I;
	@Column
	private String prenom_I;
	@Column
	private String sexe_I;
}
