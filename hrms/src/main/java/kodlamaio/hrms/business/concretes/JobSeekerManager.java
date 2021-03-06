package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;


	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao)
	{
		super();
		this.jobSeekerDao = jobSeekerDao;
		
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"iş arayanlar listelendi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		if(this.getByIdentityNumber(jobSeeker.getIdentityNumber()).getData()==null)
		{
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("İş arayan eklendi.");
		}
		return new ErrorResult("kullanıcı kaydı tamamlanamıyor.");
	}
	
	@Override
	public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByIdentityNumber(identityNumber));
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id));
	}

	

}
