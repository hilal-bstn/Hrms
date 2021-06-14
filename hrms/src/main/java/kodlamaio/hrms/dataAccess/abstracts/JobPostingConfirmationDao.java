package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPostingConfirmation;

public interface JobPostingConfirmationDao extends JpaRepository<JobPostingConfirmation,Integer> {
	
	JobPostingConfirmation getById(int id);
	
	List<JobPostingConfirmation> getByHrmsEmployeeConfirmation(boolean confirmation);
}
