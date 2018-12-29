package gr.hua.dit.transfer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Exteral_Department")

public class External_Department {

	@Column(name="name")
	private String name;
	
	@Column(name="is_Selected")
	private String is_Selecter;
	
}
