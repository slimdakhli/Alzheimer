package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@AllArgsConstructor
@NoArgsConstructor
public class SalleActivite {

	@Id
	
	private String numSalle;
	@Column
	private int capaciteSalle;
	@Column
	private int diponibilite;
	
	@OneToMany(mappedBy = "salleActivite"  ,cascade=CascadeType.ALL)
	List<Activite> activite = new ArrayList<Activite>();
	
	@OneToMany(mappedBy = "salleActivite")
	List<StaffActivite> staffActivite = new ArrayList<>();
	
	
}
