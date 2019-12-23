package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long code_P;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String sexe;
	@Column
	private String date;
	@Column
	private String etat_Civil;
	@Column
	private String nb_Enfant;
	@Column
	private String profession;
	
	//@ManyToOne
	//Groupe groupe;
	
	
//	@ManyToOne
	//Groupe groupe2 ;
	
	//@OneToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(unique = true)
	//private DossierMedical dossierMedical;
	
//	@ManyToOne(fetch = FetchType.LAZY,optional = false)
//	@JoinColumn(name = "code_G")
	//private Groupe groupe_P;
	
	//@OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "patient")
//	private DossierMedical dossierMedical;
	@ManyToOne
	private VisAVis visAvis;
}
