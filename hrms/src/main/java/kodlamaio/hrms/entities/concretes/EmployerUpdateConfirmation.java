package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employer_update_confirmations")
public class EmployerUpdateConfirmation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int id;
    //onay verildikten sonra silinir.Güncelleme onay beklerken yeni güncelleme yapılamaz.
	@OneToOne()
	@JoinColumn(name="company_id")
	private Company company;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	public EmployerUpdateConfirmation() {}

	public EmployerUpdateConfirmation(int id, Company company, String companyName, String website, String phone,
			Boolean isActive) {
		super();
		this.id = id;
		this.company = company;
		this.companyName = companyName;
		this.website = website;
		this.phone = phone;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
}