package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerTechnologyService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerTechnologyDao;
import kodlamaio.hrms.entities.concretes.JobSeekerTechnology;

@Service
public class JobSeekerTechnologyManager implements JobSeekerTechnologyService{
	private JobSeekerTechnologyDao jobSeekerTechnologyDao;
	@Autowired
	public JobSeekerTechnologyManager(JobSeekerTechnologyDao jobSeekerTechnologyDao) {
		super();
		this.jobSeekerTechnologyDao = jobSeekerTechnologyDao;
	}
	@Override
	public Result add(JobSeekerTechnology jobSeekerTechnology) {
		this.jobSeekerTechnologyDao.save(jobSeekerTechnology);
		return new SuccessResult();
	}
}
