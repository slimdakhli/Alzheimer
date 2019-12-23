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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor 
public class Activite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long ref_Act;
	@Column
	private String nature_Act;
	
	@Column
	private String nom;
	
	@ManyToOne
private SalleActivite salleActivite;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Activite_Groupe",
	joinColumns = @JoinColumn(name = "ref_Act"),
	inverseJoinColumns = @JoinColumn(name = "code_G"))
	List<Groupe> groupe;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Activite_StaffActivite",
	joinColumns = @JoinColumn(name = "ref_Act"),
	inverseJoinColumns = @JoinColumn(name = "code_Staff"))
	List<StaffActivite> staffActivite ;
	
	}













//@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//nom de la table jdida
//@JoinTable(name="activite_Groupe",joinColumns = {@JoinColumn(name="act_Ref")},inverseJoinColumns = {@JoinColumn(name="g_Code")})
//private List<Groupe> groupes_act= new ArrayList<>();

//@ManyToMany//(mappedBy = "user_Act")
//private List<Activite> activite_User= new ArrayList<>();
