package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience,Integer> {
	List<JobSeekerExperience> getByJobSeekerId(int id);
	
	@Query("From JobSeekerExperience where jobSeeker.id=:id Order By terminationYear Asc")
	  List<JobSeekerExperience> getTerminationYearAsc(int id);
 
}
