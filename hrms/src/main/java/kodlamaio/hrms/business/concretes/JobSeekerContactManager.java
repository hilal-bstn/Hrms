package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerContactService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerContactDao;
import kodlamaio.hrms.entities.concretes.JobSeekerContact;

@Service
public class JobSeekerContactManager implements JobSeekerContactService{
	private JobSeekerContactDao jobSeekerContactDao;
	@Autowired
	public JobSeekerContactManager(JobSeekerContactDao jobSeekerContactDao) {
		super();
		this.jobSeekerContactDao = jobSeekerContactDao;
	}
	@Override
	public Result add(JobSeekerContact jobSeekerContact) {
		this.jobSeekerContactDao.save(jobSeekerContact);
		return new SuccessResult();
	}
}
