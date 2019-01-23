package gr.hua.dit.transfer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Check_Application")

public class Check_Application {
	
	@Column(name="date_of_check")
	private Date date_of_check;
	
	@Column(name="is_Appoved")
	private int is_Approved;
	
	@Column(name="points")
	private int points;

	@Id
	@Column(name="check_id")
	private String check_id;
	
	public Check_Application() {
		// TODO Auto-generated constructor stub
	}
	
	public Check_Application(Date date_of_check, int is_Approved, int points, String check_id) {
		super();
		this.date_of_check = date_of_check;
		this.is_Approved = is_Approved;
		this.points = points;
		this.check_id = check_id;
	}

	public Date getDate_of_submission() {
		return date_of_check;
	}

	public void setDate_of_check(Date date_of_check) {
		this.date_of_check = date_of_check;
	}

	public int getIs_Approved() {
		return is_Approved;
	}

	public void setIs_Approved(int is_Approved) {
		this.is_Approved = is_Approved;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getCheck_id() {
		return check_id;
	}

	public void setCheck_id(String check_id) {
		this.check_id = check_id;
	}

	@Override
	public String toString() {
		return "Check_Application [date_of_check=" + date_of_check + ", is_Approved=" + is_Approved
				+ ", points=" + points + ", check_id=" + check_id + "]";
	}
	
	

}