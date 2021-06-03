package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobSeekerUniversity;

public interface JobSeekerUniversityDao extends JpaRepository<JobSeekerUniversity,Integer> {
	List<JobSeekerUniversity> getByJobSeekerId(int id);
	
	 @Query("From JobSeekerUniversity where jobSeeker.id=:id Order By graduationYear Asc")
	  List<JobSeekerUniversity> getGraduationYearAsc(int id);

}
