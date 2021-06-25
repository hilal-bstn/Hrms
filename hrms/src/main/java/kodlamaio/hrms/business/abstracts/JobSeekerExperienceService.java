package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceService {
	Result add(JobSeekerExperience jobSeekerExperience);
	
	Result update(JobSeekerExperience jobSeekerExperience);
	
	DataResult<List<JobSeekerExperience>> getByJobSeekerId(int id);
	
	DataResult<JobSeekerExperience> getById(int id);
	
	DataResult<List<JobSeekerExperience>> getTerminationYearAsc(int id);
}
