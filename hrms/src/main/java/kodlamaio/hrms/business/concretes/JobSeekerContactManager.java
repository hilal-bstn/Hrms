package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerContactService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
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
	@Override
	public DataResult<JobSeekerContact> getByJobSeekerId(int id) {
		return new SuccessDataResult<JobSeekerContact>(this.jobSeekerContactDao.getByJobSeekerId(id));
	}
	@Override
	public Result update(JobSeekerContact jobSeekerContact) {
	    JobSeekerContact jobSeekerContactUpdate=this.getById(jobSeekerContact.getId()).getData();
	    jobSeekerContactUpdate=jobSeekerContact;
	    this.jobSeekerContactDao.save(jobSeekerContactUpdate);
		return null;
	}
	@Override
	public DataResult<JobSeekerContact> getById(int id) {
		return new SuccessDataResult<JobSeekerContact>(this.jobSeekerContactDao.getById(id));
	}
}
