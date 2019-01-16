package gr.hua.dit.transfer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name = "APPLICATION")

public class Application {
	
	@Column(name="date_of_submission")
	private Date date_of_submission;
	
	@Column(name="application_id")
	private String application_id;
	
	@Lob	
	@Column(name="family")
	private byte[] family;
	
	@Lob
	@Column(name="financially")
	private byte[] financially;
	
	@Lob
	@Column(name="locality")
	private byte[] locality;


	public Application(Date date_of_submission, String application_id, byte[] family, byte[] financially, byte[] locality) {
		super();
		this.date_of_submission = date_of_submission;
		this.application_id = application_id;
		this.family = family;
		this.financially = financially;
		this.locality = locality;
	}

	public Date getDate_of_submission() {
		return date_of_submission;
	}

	public void setDate_of_submission(Date date_of_submission) {
		this.date_of_submission = date_of_submission;
	}

	public String getApplication_id() {
		return application_id;
	}

	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}

	public byte[] getFamily() {
		return family;
	}

	public void setFamily(byte[] family) {
		this.family = family;
	}

	public byte[] getFinancially() {
		return financially;
	}

	public void setFinancially(byte[] financially) {
		this.financially = financially;
	}

	public byte[] getLocality() {
		return locality;
	}

	public void setLocality(byte[] locality) {
		this.locality = locality;
	}

	@Override
	public String toString() {
		return "Application [date_of_submission=" + date_of_submission + ", application_id=" + application_id
				+ ", family=" + family + ", financially=" + financially + ", locality=" + locality + "]";
	}

	

	
}
