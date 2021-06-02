package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCoverLetterDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCoverLetter;

@Service
public class JobSeekerCoverLetterManager implements JobSeekerCoverLetterService{
	private JobSeekerCoverLetterDao jobSeekerCoverLetterDao;
	@Autowired
	public JobSeekerCoverLetterManager(JobSeekerCoverLetterDao jobSeekerCoverLetterDao) {
		super();
		this.jobSeekerCoverLetterDao = jobSeekerCoverLetterDao;
	}
	@Override
	public Result add(JobSeekerCoverLetter jobSeekerCoverLetter) {
		this.jobSeekerCoverLetterDao.save(jobSeekerCoverLetter);
		return new SuccessResult();
	}
}