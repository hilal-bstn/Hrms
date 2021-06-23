package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="job_seeker_cover_letter")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobApplications"})

public class JobSeekerCoverLetter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_seeker_cover_letter_id")
	private int id;

	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@Column(name="cover_letter")
	private String coverLetter;

	@OneToMany(mappedBy="jobSeeker")
	private List<JobApplication> jobApplications;
	
	public JobSeekerCoverLetter() {}

	public JobSeekerCoverLetter(int id, JobSeeker jobSeeker, String coverLetter,List<JobApplication> jobApplications) {
		super();
		this.id = id;
		this.jobSeeker = jobSeeker;
		this.coverLetter = coverLetter;
		this.jobApplications=jobApplications;
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

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}
	
	
}
