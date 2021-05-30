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
	@Column(name="id")
	private int id;

	@OneToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="company_id")
	private int companyId;
	
	
	@OneToMany(mappedBy="employer")
	private List<EmployerJobPosting> employerJobPostings;
	
	public Employer() {}


	public Employer(int id, User user, int companyId) {
		super();
		this.id = id;
		this.user= user;
		this.companyId = companyId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
