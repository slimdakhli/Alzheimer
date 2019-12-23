package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {

	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String sexe;
	//@Column
//	private String nature ;
}
