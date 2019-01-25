package gr.hua.dit.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INTERNAL_USER")

public class INTERNAL_USER {
	
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
	
	@Column(name="employee_type")
	private String employee_type;
	
	@Column(name="year_of_recruiment")
	private int year_of_recruitment;
	
	@Column(name="department")
	private String department;

	public INTERNAL_USER() {
		// TODO Auto-generated constructor stub
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

	public String getEmployee_type() {
		return employee_type;
	}

	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}

	public int getYear_of_recruitment() {
		return year_of_recruitment;
	}

	public void setYear_of_recruitment(int year_of_recruitment) {
		this.year_of_recruitment = year_of_recruitment;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public INTERNAL_USER(String id, String first_name, String last_name, String password, int year_of_birth, int age,
			String email, String employee_type, int year_of_recruitment, String department) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.year_of_birth = year_of_birth;
		this.age = age;
		this.email = email;
		this.employee_type = employee_type;
		this.year_of_recruitment = year_of_recruitment;
		this.department = department;
	}

	@Override
	public String toString() {
		return "INTERNAL_USER [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", password="
				+ password + ", year_of_birth=" + year_of_birth + ", age=" + age + ", email=" + email
				+ ", employee_type=" + employee_type + ", year_of_recruitment=" + year_of_recruitment + ", department="
				+ department + "]";
	}

	

}
