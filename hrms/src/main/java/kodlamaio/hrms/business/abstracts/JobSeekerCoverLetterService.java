package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCoverLetter;

public interface JobSeekerCoverLetterService {
	
	Result add(JobSeekerCoverLetter jobSeekerCoverLetter);
	
	Result update(JobSeekerCoverLetter jobSeekerCoverLetter);
	
	DataResult<List<JobSeekerCoverLetter>> getByJobSeekerId(int id);
	
	DataResult<JobSeekerCoverLetter> getById(int id);
}
