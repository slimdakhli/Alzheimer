package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planning {

	@Id
	private long id ;
	
	@Column
	private String datedeb;
	
	@Column
	private String datefin;
	
	@Column
	private String mission ;
	@OneToOne(mappedBy = "planning")
	private StaffActivite staffActivite;
}
