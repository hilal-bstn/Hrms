package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeeker","employer","hrmsEmployee"})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;

	@Column(name="email")
	@Email
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	private String password;
	
	@OneToOne(mappedBy="user")
	private JobSeeker jobSeeker;
	
	@OneToOne(mappedBy="user")
	private Employer employer;
	
	@OneToOne(mappedBy="user")
	private HrmsEmployee hrmsEmployee;
	
	public User() {}

	public User(int id, @Email @NotBlank @NotNull String email, @NotBlank @NotNull String password, JobSeeker jobSeeker,
			Employer employer,HrmsEmployee hrmsEmployee) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.jobSeeker = jobSeeker;
		this.employer = employer;
		this.hrmsEmployee=hrmsEmployee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public HrmsEmployee getHrmsEmployee() {
		return hrmsEmployee;
	}

	public void setHrmsEmployee(HrmsEmployee hrmsEmployee) {
		this.hrmsEmployee = hrmsEmployee;
	}
	
	

}
