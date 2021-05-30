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
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers"})
public class Employer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_id")
	private int companyId;
	
	
	@OneToMany(mappedBy="employer")
	private List<EmployerJobPosting> employerJobPosting;
	
	
	
	public Employer() {}
	
	public Employer(int id, int userId, int companyId) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyId = companyId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}
