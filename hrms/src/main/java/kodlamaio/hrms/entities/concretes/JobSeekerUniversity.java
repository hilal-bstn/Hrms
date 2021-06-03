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
@Table(name="job_seeker_universities")
public class JobSeekerUniversity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_seeker_university_id")
	private int id;

	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne()
	@JoinColumn(name="university_department_id")
	private UniversityDepartment universityDepartment;
	
	@Column(name="entrance_date")
	private int entranceYear;
	
	@Column(name="graduation_date")
	private int graduationYear;

	public JobSeekerUniversity() {}

	public JobSeekerUniversity(int id, JobSeeker jobSeeker, University university,
			UniversityDepartment universityDepartment, int entranceYear, int graduationYear) {
		super();
		this.id = id;
		this.jobSeeker = jobSeeker;
		this.university = university;
		this.universityDepartment = universityDepartment;
		this.entranceYear = entranceYear;
		this.graduationYear = graduationYear;
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public UniversityDepartment getUniversityDepartment() {
		return universityDepartment;
	}

	public void setUniversityDepartment(UniversityDepartment universityDepartment) {
		this.universityDepartment = universityDepartment;
	}

	public int getEntranceYear() {
		return entranceYear;
	}

	public void setEntranceYear(int entranceYear) {
		this.entranceYear = entranceYear;
	}

	public int getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	

	
	
	
}
