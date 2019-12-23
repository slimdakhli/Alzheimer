package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffActivite extends Personne{

	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code_Staff;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String sexe;
	@Column
	private String specialite;
	
	@ManyToMany(mappedBy = "staffActivite")
	List<Activite> activite ;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planning_id")
    private Planning planning;
	
	@ManyToOne
	SalleActivite salleActivite;
	
	@OneToMany(mappedBy="staffActivite" ,cascade=CascadeType.ALL)
	List<Reclamation> reclamation = new ArrayList<>();
}
