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
@Table(name="job_application")
public class JobApplication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_application_id")
	private int id;

	@ManyToOne()
	@JoinColumn(name="employer_job_posting_user_id")
	private EmployerJobPosting employerJobPosting;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_cover_letter")
	private JobSeekerCoverLetter jobSeekerCoverLetter;

	public JobApplication() {}

	public JobApplication(int id, EmployerJobPosting employerJobPosting, JobSeeker jobSeeker,
			JobSeekerCoverLetter jobSeekerCoverLetter) {
		super();
		this.id = id;
		this.employerJobPosting = employerJobPosting;
		this.jobSeeker = jobSeeker;
		this.jobSeekerCoverLetter = jobSeekerCoverLetter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployerJobPosting getEmployerJobPosting() {
		return employerJobPosting;
	}

	public void setEmployerJobPosting(EmployerJobPosting employerJobPosting) {
		this.employerJobPosting = employerJobPosting;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public JobSeekerCoverLetter getJobSeekerCoverLetter() {
		return jobSeekerCoverLetter;
	}

	public void setJobSeekerCoverLetter(JobSeekerCoverLetter jobSeekerCoverLetter) {
		this.jobSeekerCoverLetter = jobSeekerCoverLetter;
	}
}
