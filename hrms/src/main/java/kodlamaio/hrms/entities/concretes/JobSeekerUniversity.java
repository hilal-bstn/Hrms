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
	@Column(name="id")
	private int id;

	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne()
	@JoinColumn(name="university_department_id")
	private UniversityDepartment universityDepartment;
	
	@Column(name="entrance_date")
	private String entranceDate;
	
	@Column(name="graduation_date")
	private String graduationDate;

	public JobSeekerUniversity() {}

	public JobSeekerUniversity(int id, int jobSeekerId, University university,
			UniversityDepartment universityDepartment, String entranceDate, String graduationDate) {
		super();
		this.id = id;
		this.jobSeekerId = jobSeekerId;
		this.university = university;
		this.universityDepartment = universityDepartment;
		this.entranceDate = entranceDate;
		this.graduationDate = graduationDate;
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

	public String getEntranceDate() {
		return entranceDate;
	}

	public void setEntranceDate(String entranceDate) {
		this.entranceDate = entranceDate;
	}

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	
	
}
