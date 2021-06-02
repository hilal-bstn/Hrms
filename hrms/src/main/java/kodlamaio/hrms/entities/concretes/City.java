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
@Table(name="cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employerJobPostings"})
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id")
	private int id;

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="city")
	private List<EmployerJobPosting> employerJobPostings;
	
	public City() {}

	public City(int id, String name, List<EmployerJobPosting> employerJobPostings) {
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
