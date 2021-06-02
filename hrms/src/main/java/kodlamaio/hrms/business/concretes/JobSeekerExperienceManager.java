package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerExperienceDao;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService {
	private JobSeekerExperienceDao jobSeekerExperienceDao;
	@Autowired
	public JobSeekerExperienceManager(JobSeekerExperienceDao jobSeekerExperienceDao) {
		super();
		this.jobSeekerExperienceDao = jobSeekerExperienceDao;
	}
	@Override
	public Result add(JobSeekerExperience jobSeekerExperience) {
		this.jobSeekerExperienceDao.save(jobSeekerExperience);
		return new SuccessResult();
	}
	@Override
	public DataResult<List<JobSeekerExperience>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<JobSeekerExperience>>(this.jobSeekerExperienceDao.getByJobSeekerId(id));
	}
}
