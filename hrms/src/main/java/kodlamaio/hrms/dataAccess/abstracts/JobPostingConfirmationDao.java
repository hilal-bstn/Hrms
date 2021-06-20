package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPostingConfirmation;

public interface JobPostingConfirmationDao extends JpaRepository<JobPostingConfirmation,Integer> {
	
	JobPostingConfirmation getById(int id);
	
	  @Query("From JobPostingConfirmation where hrmsEmployeeConfirmation=false")
	List<JobPostingConfirmation> getByHrmsEmployeeConfirmation();
}
