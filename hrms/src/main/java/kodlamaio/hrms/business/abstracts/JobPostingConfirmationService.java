package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerJobPosting;
import kodlamaio.hrms.entities.concretes.JobPostingConfirmation;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;


public interface JobPostingConfirmationService {
	Result add(EmployerJobPosting employerJobPosting);
	
	Result hrmsConfirmation(int id);
	
	DataResult<JobPostingConfirmation> getById(int id);
	
	DataResult<List<JobPostingConfirmation>> getAll();
	
	DataResult<List<JobPostingConfirmation>> getByHrmsEmployeeConfirmation();
	
}
