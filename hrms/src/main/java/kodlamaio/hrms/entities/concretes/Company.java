package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="companies")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer","employerUpdateConfirmations"})
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_id")
	private int id;

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone")
	private String phone;
	
	@OneToOne(mappedBy="company")
	private Employer employer;
	
	@OneToMany(mappedBy="company")
	private List<EmployerUpdateConfirmation> employerUpdateConfirmations;
	
	public Company() {}

	public Company(int id, String companyName, String website, String phone, Employer employer,
			List<EmployerUpdateConfirmation> employerUpdateConfirmations) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.website = website;
		this.phone = phone;
		this.employer = employer;
		this.employerUpdateConfirmations = employerUpdateConfirmations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public List<EmployerUpdateConfirmation> getEmployerUpdateConfirmations() {
		return employerUpdateConfirmations;
	}

	public void setEmployerUpdateConfirmations(List<EmployerUpdateConfirmation> employerUpdateConfirmations) {
		this.employerUpdateConfirmations = employerUpdateConfirmations;
	}

	

	
}
