package kodlamaio.hrms.entities.concretes;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employer_job_postings")
public class EmployerJobPosting {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="job_position_id")
	private int jobPositionId;
	
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="open_position_count")
	private int openPositionCount;
	
	@Column(name="release_date")
	private LocalDateTime releaseDate;
	
	@Column(name="application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	

	public EmployerJobPosting() {}

	public EmployerJobPosting(int id, int employerId, int jobPositionId, int cityId, String jobDescription,
			double minSalary, double maxSalary, int openPositionCount, LocalDateTime applicationDeadline) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.jobPositionId = jobPositionId;
		this.cityId = cityId;
		this.jobDescription = jobDescription;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.openPositionCount = openPositionCount;
		this.applicationDeadline = applicationDeadline;
	}
	public EmployerJobPosting(int id, int employerId, int jobPositionId, int cityId, String jobDescription,
			int openPositionCount,LocalDateTime applicationDeadLine ) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.jobPositionId = jobPositionId;
		this.cityId = cityId;
		this.jobDescription = jobDescription;
		this.openPositionCount = openPositionCount;
		this.applicationDeadline = applicationDeadLine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public int getJobPositionId() {
		return jobPositionId;
	}

	public void setJobPositionId(int jobPositionId) {
		this.jobPositionId = jobPositionId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getOpenPositionCount() {
		return openPositionCount;
	}

	public void setOpenPositionCount(int openPositionCount) {
		this.openPositionCount = openPositionCount;
	}


	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}

	public LocalDateTime getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(LocalDateTime applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}


	
}