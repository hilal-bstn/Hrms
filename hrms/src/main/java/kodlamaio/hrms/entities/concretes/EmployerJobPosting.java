package kodlamaio.hrms.entities.concretes;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="employer_job_postings")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostingConfirmation","jobApplications","favoriteJobPostingsOfJobSeeker"})

public class EmployerJobPosting {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employer_job_posting_id")
	private int id;

	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="open_position_count")
	private int openPositionCount;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name="type_of_work_id")
	private TypeOfWork typeOfWork;

	@ManyToOne()
	@JoinColumn(name="time_of_work_id")
	private TimeOfWork timeOfWork;
	
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="employerJobPosting")
	private JobPostingConfirmation jobPostingConfirmation;
	
	@OneToMany(mappedBy="employerJobPosting")
	private List<JobApplication> jobApplications;
	
	@OneToMany(mappedBy="employerJobPosting")
	private List<FavoriteJobPostingOfJobSeeker> favoriteJobPostingsOfJobSeeker;
	
	public EmployerJobPosting() {}

	public EmployerJobPosting(int id, Employer employer, JobPosition jobPosition, City city, String jobDescription,
			double minSalary, double maxSalary, int openPositionCount, Date releaseDate, Date applicationDeadline,
			Boolean isActive, TypeOfWork typeOfWork, TimeOfWork timeOfWork,
			JobPostingConfirmation jobPostingConfirmation,List<JobApplication> jobApplications,List<FavoriteJobPostingOfJobSeeker> favoriteJobPostingsOfJobSeeker) {
		super();
		this.id = id;
		this.employer = employer;
		this.jobPosition = jobPosition;
		this.city = city;
		this.jobDescription = jobDescription;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.openPositionCount = openPositionCount;
		this.releaseDate = releaseDate;
		this.applicationDeadline = applicationDeadline;
		this.isActive = isActive;
		this.typeOfWork = typeOfWork;
		this.timeOfWork = timeOfWork;
		this.jobPostingConfirmation = jobPostingConfirmation;
		this.jobApplications=jobApplications;
		this.favoriteJobPostingsOfJobSeeker=favoriteJobPostingsOfJobSeeker;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public JobPosition getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public TypeOfWork getTypeOfWork() {
		return typeOfWork;
	}

	public void setTypeOfWork(TypeOfWork typeOfWork) {
		this.typeOfWork = typeOfWork;
	}

	public TimeOfWork getTimeOfWork() {
		return timeOfWork;
	}

	public void setTimeOfWork(TimeOfWork timeOfWork) {
		this.timeOfWork = timeOfWork;
	}

	public JobPostingConfirmation getJobPostingConfirmation() {
		return jobPostingConfirmation;
	}

	public void setJobPostingConfirmation(JobPostingConfirmation jobPostingConfirmation) {
		this.jobPostingConfirmation = jobPostingConfirmation;
	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	public List<FavoriteJobPostingOfJobSeeker> getFavoriteJobPostingsOfJobSeeker() {
		return favoriteJobPostingsOfJobSeeker;
	}

	public void setFavoriteJobPostingsOfJobSeeker(List<FavoriteJobPostingOfJobSeeker> favoriteJobPostingsOfJobSeeker) {
		this.favoriteJobPostingsOfJobSeeker = favoriteJobPostingsOfJobSeeker;
	}

	

	


	

	
}