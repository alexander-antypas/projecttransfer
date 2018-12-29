package gr.hua.dit.transfer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXTERNAL_USER")

public class External_User {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="pw")
	private String password;
	
	@Column(name="year_of_birth")
	private int year_of_birth;
	
	@Column(name="age")
	private int age;
	
	@Column (name="email")
	private String email;
	
	@Column(name="external_department")
	private String external_department;
	
	@Column(name="year_of_enrollment")
	private int year_of_enrollment;
	
	@Column(name="current_semester")
	private String current_semester;

	public External_User() {
		// TODO Auto-generated constructor stub
	}

	public External_User(String id, String first_name, String last_name, String password, int year_of_birth, int age,
			String email, String external_department, int year_of_enrollment, String current_semester) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.year_of_birth = year_of_birth;
		this.age = age;
		this.email = email;
		this.external_department = external_department;
		this.year_of_enrollment = year_of_enrollment;
		this.current_semester = current_semester;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getYear_of_birth() {
		return year_of_birth;
	}

	public void setYear_of_birth(int year_of_birth) {
		this.year_of_birth = year_of_birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExternal_department() {
		return external_department;
	}

	public void setExternal_department(String external_department) {
		this.external_department = external_department;
	}

	public int getYear_of_enrollment() {
		return year_of_enrollment;
	}

	public void setYear_of_enrollment(int year_of_enrollment) {
		this.year_of_enrollment = year_of_enrollment;
	}

	public String getCurrent_semester() {
		return current_semester;
	}

	public void setCurrent_semester(String current_semester) {
		this.current_semester = current_semester;
	}

	@Override
	public String toString() {
		return "External_User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", password="
				+ password + ", year_of_birth=" + year_of_birth + ", age=" + age + ", email=" + email
				+ ", external_department=" + external_department + ", year_of_enrollment=" + year_of_enrollment
				+ ", current_semester=" + current_semester + "]";
	}
	
		
}
