package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employerJobPostings","jobSeekerExperiences"})
public class JobPosition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_position_id")
	private int id;

	@Column(name="title")
	private String title;
	
	@OneToMany(mappedBy="jobPosition")
	private List<EmployerJobPosting> employerJobPostings;
	
	@OneToMany(mappedBy="jobPosition")
	private List<JobSeekerExperience> jobSeekerExperiences;
	
	public JobPosition() {}

	public JobPosition(int id, String title, List<EmployerJobPosting> employerJobPostings,
			List<JobSeekerExperience> jobSeekerExperiences) {
		super();
		this.id = id;
		this.title = title;
		this.employerJobPostings = employerJobPostings;
		this.jobSeekerExperiences = jobSeekerExperiences;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<EmployerJobPosting> getEmployerJobPostings() {
		return employerJobPostings;
	}

	public void setEmployerJobPostings(List<EmployerJobPosting> employerJobPostings) {
		this.employerJobPostings = employerJobPostings;
	}

	public List<JobSeekerExperience> getJobSeekerExperiences() {
		return jobSeekerExperiences;
	}

	public void setJobSeekerExperiences(List<JobSeekerExperience> jobSeekerExperiences) {
		this.jobSeekerExperiences = jobSeekerExperiences;
	}

	
	
}
