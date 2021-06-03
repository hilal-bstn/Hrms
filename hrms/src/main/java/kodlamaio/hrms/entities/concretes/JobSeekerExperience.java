package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_experiences")
public class JobSeekerExperience {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_seeker_experience_id")
	private int id;

	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@Column(name="companyName")
	private String companyName;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@Column(name="employment_start_year")
	private int employmentStartYear;
	
	@Column(name="termination_year")
	private int terminationYear;

	public JobSeekerExperience() {}

	public JobSeekerExperience(int id, JobSeeker jobSeeker, String companyName, JobPosition jobPosition,
			int employmentStartYear, int terminationYear) {
		super();
		this.id = id;
		this.jobSeeker = jobSeeker;
		this.companyName = companyName;
		this.jobPosition = jobPosition;
		this.employmentStartYear = employmentStartYear;
		this.terminationYear = terminationYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public JobPosition getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}

	public int getEmploymentStartYear() {
		return employmentStartYear;
	}

	public void setEmploymentStartYear(int employmentStartYear) {
		this.employmentStartYear = employmentStartYear;
	}

	public int getTerminationYear() {
		return terminationYear;
	}

	public void setTerminationYear(int terminationYear) {
		this.terminationYear = terminationYear;
	}

	
	
	
	
}