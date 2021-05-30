package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.EmployerJobPosting;

public interface EmployerJobPostingDao extends JpaRepository<EmployerJobPosting,Integer>{
	  
	  List<EmployerJobPosting>  getByEmployerIdAndIsActive(int id,boolean active);

	  List<EmployerJobPosting> getByIsActive(boolean active);
	  
	  EmployerJobPosting getById(int id);
	  
	  
	  @Query("From EmployerJobPosting where isActive=true Order By releaseDate Desc")
	  List<EmployerJobPosting> getByReleaseDateDesc();
	  
}
