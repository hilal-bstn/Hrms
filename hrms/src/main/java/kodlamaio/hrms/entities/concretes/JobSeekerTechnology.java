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
@Table(name="job_seeker_technologies")
public class JobSeekerTechnology {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	@ManyToOne()
	@JoinColumn(name="technology_id")
	private Technology technology;
	
	public JobSeekerTechnology() {}

	public JobSeekerTechnology(int id, int jobSeekerId, Technology technology) {
		super();
		this.id = id;
		this.jobSeekerId = jobSeekerId;
		this.technology = technology;
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

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	
	
	
	
}
