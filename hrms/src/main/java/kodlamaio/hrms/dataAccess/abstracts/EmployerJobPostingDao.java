package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerJobPosting;

public interface EmployerJobPostingDao extends JpaRepository<EmployerJobPosting,Integer>{
	  
	  List<EmployerJobPosting>  getByEmployerIdAndIsActive(int id,boolean active);

	  List<EmployerJobPosting> getByIsActive(boolean active);
	  
	  EmployerJobPosting getById(int id);
	  
}
