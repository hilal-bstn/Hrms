package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageService {
	Result add(JobSeekerLanguage jobSeekerLanguage);

	Result update(JobSeekerLanguage jobSeekerLanguage);
	
	DataResult<JobSeekerLanguage> getById(int id);

	DataResult<List<JobSeekerLanguage>> getByJobSeekerId(int id);

}
