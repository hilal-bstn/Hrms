package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_cover_letter")
public class JobSeekerCoverLetter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	@Column(name="cover_letter")
	private String coverLetter;

	public JobSeekerCoverLetter() {}
	
	public JobSeekerCoverLetter(int id, int jobSeekerId, String coverLetter) {
		super();
		this.id = id;
		this.jobSeekerId = jobSeekerId;
		this.coverLetter = coverLetter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

}
