package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_posting_confirmation")
public class JobPostingConfirmation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_posting_confirmation_id")
	private int id;

	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="employer_job_posting_id")
	private EmployerJobPosting employerJobPosting;
	
	@Column(name="hrms_employee_confirmation")
	private Boolean hrmsEmployeeConfirmation;

	public JobPostingConfirmation() {
		super();
	}

	public JobPostingConfirmation(int id, EmployerJobPosting employerJobPosting, Boolean hrmsEmployeeConfirmation) {
		super();
		this.id = id;
		this.employerJobPosting = employerJobPosting;
		this.hrmsEmployeeConfirmation = hrmsEmployeeConfirmation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployerJobPosting getEmployerJobPosting() {
		return employerJobPosting;
	}

	public void setEmployerJobPosting(EmployerJobPosting employerJobPosting) {
		this.employerJobPosting = employerJobPosting;
	}

	public Boolean getHrmsEmployeeConfirmation() {
		return hrmsEmployeeConfirmation;
	}

	public void setHrmsEmployeeConfirmation(Boolean hrmsEmployeeConfirmation) {
		this.hrmsEmployeeConfirmation = hrmsEmployeeConfirmation;
	}

	
}
