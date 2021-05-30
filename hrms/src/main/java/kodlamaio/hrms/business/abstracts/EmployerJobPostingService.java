package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerJobPosting;

public interface EmployerJobPostingService {
	DataResult<List<EmployerJobPosting>> getByIsActive();
	
	Result add(EmployerJobPosting employerJobPosting);
	
	Result delete(int id);//pasif hale getirme
	
	DataResult<List<EmployerJobPosting>> getByEmployerIdAndIsActive(int Id);
	
	DataResult<EmployerJobPosting> getById(int id);
	
	DataResult<List<EmployerJobPosting>> getByReleaseDateAndIsActiveSorted();
}