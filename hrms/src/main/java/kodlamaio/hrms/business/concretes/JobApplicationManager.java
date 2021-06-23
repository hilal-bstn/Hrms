package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobApplicationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobApplicationDao;
import kodlamaio.hrms.entities.concretes.JobApplication;
@Service
public class JobApplicationManager implements JobApplicationService {
 private JobApplicationDao jobApplicationDao;
@Autowired
public JobApplicationManager(JobApplicationDao jobApplicationDao) {
	super();
	this.jobApplicationDao = jobApplicationDao;
}
@Override
public Result add(JobApplication jobApplication) {
	this.jobApplicationDao.save(jobApplication);
	return new SuccessResult();
}
}
