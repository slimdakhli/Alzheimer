package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Personne{
	@Id
	@Column(unique = true)
	private String login;
	@Column
	private String password;
	@Column
	private String nature;
	
	
	public User(String login , String password , String nature,String nom, String prenom , String sexe) {
		super(nom,prenom,sexe);
		this.login=login;
		this.password=password;
		this.nature=nature;
	}

	
//	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	//nom de la table jdida
//@JoinTable(name="user_Activite",joinColumns = {@JoinColumn(name="login_User")},inverseJoinColumns = {@JoinColumn(name="act_Ref")})
//private List<Activite> user_Act= new ArrayList<>();

//	private Personne personne ;
}
