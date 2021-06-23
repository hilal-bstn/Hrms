package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="job_seekers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerContact","jobSeekerCoverLetters","jobSeekerExperiences","jobSeekerLanguages","jobSeekerTechnologies","jobSeekerUniversities","jobSeekerPhoto","jobApplications"})
public class JobSeeker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_seeker_id")
	private int id;

	@OneToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="year_of_birth")
	private String yearOfBirth;
	
	@OneToOne(mappedBy="jobSeeker")
	private JobSeekerContact jobSeekerContact;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<JobSeekerCoverLetter> jobSeekerCoverLetters;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<JobSeekerExperience> jobSeekerExperiences;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<JobSeekerLanguage> jobSeekerLanguages;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<JobSeekerTechnology> jobSeekerTechnologies;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<JobSeekerUniversity> jobSeekerUniversities;
	
	@OneToOne(mappedBy="jobSeeker")
	private JobSeekerPhoto jobSeekerPhoto;
    
	@OneToMany(mappedBy="jobSeeker")
	private List<JobApplication> jobApplications;
	
	public JobSeeker() {}

	public JobSeeker(int id, User user, String firstName, String lastName, String identityNumber, String yearOfBirth,
			JobSeekerContact jobSeekerContact, List<JobSeekerCoverLetter> jobSeekerCoverLetters,
			List<JobSeekerExperience> jobSeekerExperiences, List<JobSeekerLanguage> jobSeekerLanguages,
			List<JobSeekerTechnology> jobSeekerTechnologies, List<JobSeekerUniversity> jobSeekerUniversities,
			JobSeekerPhoto jobSeekerPhoto,List<JobApplication> jobApplications) {
		super();
		this.id = id;
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.yearOfBirth = yearOfBirth;
		this.jobSeekerContact = jobSeekerContact;
		this.jobSeekerCoverLetters = jobSeekerCoverLetters;
		this.jobSeekerExperiences = jobSeekerExperiences;
		this.jobSeekerLanguages = jobSeekerLanguages;
		this.jobSeekerTechnologies = jobSeekerTechnologies;
		this.jobSeekerUniversities = jobSeekerUniversities;
		this.jobSeekerPhoto = jobSeekerPhoto;
		this.jobApplications=jobApplications;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public JobSeekerContact getJobSeekerContact() {
		return jobSeekerContact;
	}

	public void setJobSeekerContact(JobSeekerContact jobSeekerContact) {
		this.jobSeekerContact = jobSeekerContact;
	}

	public List<JobSeekerCoverLetter> getJobSeekerCoverLetters() {
		return jobSeekerCoverLetters;
	}

	public void setJobSeekerCoverLetters(List<JobSeekerCoverLetter> jobSeekerCoverLetters) {
		this.jobSeekerCoverLetters = jobSeekerCoverLetters;
	}

	public List<JobSeekerExperience> getJobSeekerExperiences() {
		return jobSeekerExperiences;
	}

	public void setJobSeekerExperiences(List<JobSeekerExperience> jobSeekerExperiences) {
		this.jobSeekerExperiences = jobSeekerExperiences;
	}

	public List<JobSeekerLanguage> getJobSeekerLanguages() {
		return jobSeekerLanguages;
	}

	public void setJobSeekerLanguages(List<JobSeekerLanguage> jobSeekerLanguages) {
		this.jobSeekerLanguages = jobSeekerLanguages;
	}

	public List<JobSeekerTechnology> getJobSeekerTechnologies() {
		return jobSeekerTechnologies;
	}

	public void setJobSeekerTechnologies(List<JobSeekerTechnology> jobSeekerTechnologies) {
		this.jobSeekerTechnologies = jobSeekerTechnologies;
	}

	public List<JobSeekerUniversity> getJobSeekerUniversities() {
		return jobSeekerUniversities;
	}

	public void setJobSeekerUniversities(List<JobSeekerUniversity> jobSeekerUniversities) {
		this.jobSeekerUniversities = jobSeekerUniversities;
	}

	public JobSeekerPhoto getJobSeekerPhoto() {
		return jobSeekerPhoto;
	}

	public void setJobSeekerPhoto(JobSeekerPhoto jobSeekerPhoto) {
		this.jobSeekerPhoto = jobSeekerPhoto;
	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	
	
	
}
