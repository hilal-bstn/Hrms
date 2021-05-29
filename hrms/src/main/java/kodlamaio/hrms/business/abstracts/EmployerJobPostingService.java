package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerJobPosting;

public interface EmployerJobPostingService {
	DataResult<List<EmployerJobPosting>> getAll();
	
	Result add(EmployerJobPosting employerJobPosting);
	
	Result delete(int id);
	
	DataResult<EmployerJobPosting> getById(int Id);
	
}
