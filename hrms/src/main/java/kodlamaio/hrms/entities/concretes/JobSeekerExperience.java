package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_experiences")
public class JobSeekerExperience {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	@Column(name="cover_letter")
	private int companyId;
	
	@Column(name="job_position_id")
	private int jobPositionId;
	
	@Column(name="employment_start_date")
	private Date employmentStartDate;
	
	@Column(name="termination_date")
	private Date terminationDate;

	public JobSeekerExperience() {}
	
	public JobSeekerExperience(int id, int jobSeekerId, int companyId, int jobPositionId, Date employmentStartDate,
			Date terminationDate) {
		super();
		this.id = id;
		this.jobSeekerId = jobSeekerId;
		this.companyId = companyId;
		this.jobPositionId = jobPositionId;
		this.employmentStartDate = employmentStartDate;
		this.terminationDate = terminationDate;
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

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getJobPositionId() {
		return jobPositionId;
	}

	public void setJobPositionId(int jobPositionId) {
		this.jobPositionId = jobPositionId;
	}

	public Date getEmploymentStartDate() {
		return employmentStartDate;
	}

	public void setEmploymentStartDate(Date employmentStartDate) {
		this.employmentStartDate = employmentStartDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
}
