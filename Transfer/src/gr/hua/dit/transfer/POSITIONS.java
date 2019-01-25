package gr.hua.dit.transfer;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "POSITIONS")

public class POSITIONS {
	
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="positions")
	private int positions;

	public POSITIONS() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "POSITIONS [name=" + name + ", positions=" + positions + ", getName()=" + getName() + ", getPositions()="
				+ getPositions() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	public POSITIONS(String name, int positions) {
		super();
		this.name = name;
		this.positions = positions;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPositions() {
		return positions;
	}


	public void setPositions(int positions) {
		this.positions = positions;
	}



}
	

