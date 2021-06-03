package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerUniversity;

public interface JobSeekerUniversityService {
	Result add(JobSeekerUniversity jobSeekerUniversity);
	
	DataResult<List<JobSeekerUniversity>> getByJobSeekerId(int id);
	
	DataResult<List<JobSeekerUniversity>> getGraduationYearDesc(int id);

}
