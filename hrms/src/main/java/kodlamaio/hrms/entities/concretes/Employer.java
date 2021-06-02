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
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employerJobPostings"})
public class Employer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int id;

	@OneToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne()
	@JoinColumn(name="company_id")
	private Company company;
	
	@OneToMany(mappedBy="employer")
	private List<EmployerJobPosting> employerJobPostings;
	
	
	public Employer() {}


	public Employer(int id, User user, Company company, List<EmployerJobPosting> employerJobPostings) {
		super();
		this.id = id;
		this.user = user;
		this.company = company;
		this.employerJobPostings = employerJobPostings;
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


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public List<EmployerJobPosting> getEmployerJobPostings() {
		return employerJobPostings;
	}


	public void setEmployerJobPostings(List<EmployerJobPosting> employerJobPostings) {
		this.employerJobPostings = employerJobPostings;
	}
	
	
	
}
