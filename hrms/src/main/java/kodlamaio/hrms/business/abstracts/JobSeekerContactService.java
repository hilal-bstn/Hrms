package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerContact;

public interface JobSeekerContactService {
	Result add(JobSeekerContact jobSeekerContact);
	
	Result update(JobSeekerContact jobSeekerContact);
	
	DataResult<JobSeekerContact> getByJobSeekerId(int id);
	
	DataResult<JobSeekerContact> getById(int id);
}
