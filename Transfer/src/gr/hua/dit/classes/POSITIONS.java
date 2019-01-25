package gr.hua.dit.classes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "POSITIONS")

public class POSITIONS {
	
	@Id
	@Column(name="informatics")
	private int informatics;
	

	@Column(name="health_science")
	private int health_science;
	
	
	@Column(name="home_economics")
	private int home_economics;
	
	
	@Column(name="geography")
	private int geography;
  

	public POSITIONS(int informatics, int health_science, int home_economics, int geography) {
		super();
		this.informatics = informatics;
		this.health_science = health_science;
		this.home_economics = home_economics;
		this.geography = geography;
	}


	public int getInformatics() {
		return informatics;
	}


	public void setInformatics(int informatics) {
		this.informatics = informatics;
	}


	public int getHealth_science() {
		return health_science;
	}


	public void setHealth_science(int health_science) {
		this.health_science = health_science;
	}


	public int getHome_economics() {
		return home_economics;
	}


	public void setHome_economics(int home_economics) {
		this.home_economics = home_economics;
	}


	public int getGeography() {
		return geography;
	}


	public void setGeography(int geography) {
		this.geography = geography;
	}

	
	
}