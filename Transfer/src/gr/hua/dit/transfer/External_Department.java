package gr.hua.dit.transfer;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exteral_Department")

public class External_Department {
	
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="is_Selected")
	private String is_Selecter;
	
	public External_Department(String name, String is_Selecter) {
		super();
		this.name = name;
		this.is_Selecter = is_Selecter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIs_Selecter() {
		return is_Selecter;
	}

	public void setIs_Selecter(String is_Selecter) {
		this.is_Selecter = is_Selecter;
	}

	@Override
	public String toString() {
		return "External_Department [name=" + name + ", is_Selecter=" + is_Selecter + "]";
	}
	
	
	
	
}
