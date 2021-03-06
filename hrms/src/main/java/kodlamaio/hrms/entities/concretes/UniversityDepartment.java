package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="university_departments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerUniversities"})
public class UniversityDepartment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="university_department_id")
	private int id;

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="universityDepartment")
	private List<JobSeekerUniversity> jobSeekerUniversities;

	public UniversityDepartment() {}
	
	public UniversityDepartment(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
