package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DossierMedical {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long num_D;
	@Column
	private int stade_D;
	
	
//	@OneToOne(mappedBy = "dossierMedical")
//	private Patient patient ;
//	@OneToOne(fetch =FetchType.LAZY,optional = false)
	//@JoinColumn(name="code_P")
	//private Patient patient;
	
}
