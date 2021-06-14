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
@Table(name="type_of_work")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employerJobPostings"})
public class TypeOfWork {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="technology_id")
	private int id;

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="typeOfWork")//categoriler tablosuyla
	private List<EmployerJobPosting> employerJobPostings;

	public TypeOfWork() {

	}

	public TypeOfWork(int id, String name, List<EmployerJobPosting> employerJobPostings) {
		super();
		this.id = id;
		this.name = name;
		this.employerJobPostings = employerJobPostings;
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

	public List<EmployerJobPosting> getEmployerJobPostings() {
		return employerJobPostings;
	}

	public void setEmployerJobPostings(List<EmployerJobPosting> employerJobPostings) {
		this.employerJobPostings = employerJobPostings;
	}
	
}
