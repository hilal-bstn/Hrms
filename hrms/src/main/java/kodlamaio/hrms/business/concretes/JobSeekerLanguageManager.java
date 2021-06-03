package kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService{
	private JobSeekerLanguageDao jobSeekerLanguageDao;
	private LanguageService languageService;
	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao,LanguageService languageService) {
		super();
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
		this.languageService=languageService;
	}
	@Override
	@Transactional
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
		Language language=this.languageService.add(jobSeekerLanguage.getLanguage()).getData();
		jobSeekerLanguage.setLanguage(language);
		this.jobSeekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult();
	}
	@Override
	public DataResult<List<JobSeekerLanguage>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<JobSeekerLanguage>>(this.jobSeekerLanguageDao.getByJobSeekerId(id));
	}
}
