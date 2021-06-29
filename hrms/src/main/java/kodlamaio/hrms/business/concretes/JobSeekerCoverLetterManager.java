package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
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
	@Override
	public DataResult<List<JobSeekerCoverLetter>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<JobSeekerCoverLetter>>(this.jobSeekerCoverLetterDao.getByJobSeekerId(id));
	}
	@Override
	public Result update(JobSeekerCoverLetter jobSeekerCoverLetter) {
		JobSeekerCoverLetter jobSeekerCoverLetterUpdate=this.getById(jobSeekerCoverLetter.getId()).getData();
		jobSeekerCoverLetterUpdate=jobSeekerCoverLetter;
		this.jobSeekerCoverLetterDao.save(jobSeekerCoverLetterUpdate);
		return new SuccessResult("Güncellendi.");
	}
	@Override
	public DataResult<JobSeekerCoverLetter> getById(int id) {
		return new SuccessDataResult<JobSeekerCoverLetter>(this.jobSeekerCoverLetterDao.getById(id));
	}
}
