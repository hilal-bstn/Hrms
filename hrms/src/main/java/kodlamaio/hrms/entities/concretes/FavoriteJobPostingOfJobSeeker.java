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
@Table(name="favorite_job_posting_of_job_seeker")
public class FavoriteJobPostingOfJobSeeker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="favorite_job_posting_of_job_seeker_id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name="employer_job_posting_id")
	private EmployerJobPosting employerJobPosting;

	public FavoriteJobPostingOfJobSeeker() {
		super();
	}

	public FavoriteJobPostingOfJobSeeker(int id, JobSeeker jobSeeker, EmployerJobPosting employerJobPosting) {
		super();
		this.id = id;
		this.jobSeeker = jobSeeker;
		this.employerJobPosting = employerJobPosting;
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

	public EmployerJobPosting getEmployerJobPosting() {
		return employerJobPosting;
	}

	public void setEmployerJobPosting(EmployerJobPosting employerJobPosting) {
		this.employerJobPosting = employerJobPosting;
	}

}