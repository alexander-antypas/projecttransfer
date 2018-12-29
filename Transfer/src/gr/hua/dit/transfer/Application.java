package gr.hua.dit.transfer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mysql.cj.jdbc.Blob;

@Entity
@Table(name = "APPLICATION")

public class Application {
	
	@Column(name="date_of_submission")
	private Date date_of_submission;
	
	@Column(name="application_id")
	private String application_id;
	
	@Column(name="family")
	private Blob family;
	
	@Column(name="financially")
	private Blob financially;
	
	@Column(name="locality")
	private Blob locality;

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public Application(Date date_of_submission, String application_id, Blob family, Blob financially, Blob locality) {
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

	public Blob getFamily() {
		return family;
	}

	public void setFamily(Blob family) {
		this.family = family;
	}

	public Blob getFinancially() {
		return financially;
	}

	public void setFinancially(Blob financially) {
		this.financially = financially;
	}

	public Blob getLocality() {
		return locality;
	}

	public void setLocality(Blob locality) {
		this.locality = locality;
	}

	@Override
	public String toString() {
		return "Application [date_of_submission=" + date_of_submission + ", application_id=" + application_id
				+ ", family=" + family + ", financially=" + financially + ", locality=" + locality + "]";
	}

	

	
}
