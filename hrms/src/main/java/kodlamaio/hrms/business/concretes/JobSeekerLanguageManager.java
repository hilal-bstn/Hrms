package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService{
	private JobSeekerLanguageDao jobSeekerLanguageDao;
	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
		super();
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
	}
	@Override
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
		this.jobSeekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult("Eklendi.");
	}
	@Override
	public DataResult<List<JobSeekerLanguage>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<JobSeekerLanguage>>(this.jobSeekerLanguageDao.getByJobSeekerId(id));
	}
	@Override
	public Result update(JobSeekerLanguage jobSeekerLanguage) {
		JobSeekerLanguage jobSeekerLanguageUpdate=this.getById(jobSeekerLanguage.getId()).getData();
		jobSeekerLanguageUpdate=jobSeekerLanguage;
		this.jobSeekerLanguageDao.save(jobSeekerLanguageUpdate);
		return new SuccessResult("Güncellendi.");
	}
	@Override
	public DataResult<JobSeekerLanguage> getById(int id) {
		return new SuccessDataResult<JobSeekerLanguage>(this.jobSeekerLanguageDao.getById(id));
	}
}
