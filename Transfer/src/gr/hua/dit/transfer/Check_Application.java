package gr.hua.dit.transfer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHECK_APPLICATION")

public class Check_Application {
	
	@Column(name="date_of_check")
	private Date date_of_submission;
	
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="is_Approved")
	private int is_Approved;
	
	@Id
	@Column(name="check_id")
	private String check_id;
	
	@Column(name="points")
	private String points;

	public Check_Application() {
		// TODO Auto-generated constructor stub
	}

	public Check_Application(Date date_of_submission, String comments, int is_Approved, String check_id,
			String points) {
		super();
		this.date_of_submission = date_of_submission;
		this.comments = comments;
		this.is_Approved = is_Approved;
		this.check_id = check_id;
		this.points = points;
	}

	public Date getDate_of_submission() {
		return date_of_submission;
	}

	public void setDate_of_submission(Date date_of_submission) {
		this.date_of_submission = date_of_submission;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getIs_Approved() {
		return is_Approved;
	}

	public void setIs_Approved(int is_Approved) {
		this.is_Approved = is_Approved;
	}

	public String getCheck_id() {
		return check_id;
	}

	public void setCheck_id(String check_id) {
		this.check_id = check_id;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Check_Application [date_of_submission=" + date_of_submission + ", comments=" + comments
				+ ", is_Approved=" + is_Approved + ", check_id=" + check_id + ", points=" + points + "]";
	}
	
}
