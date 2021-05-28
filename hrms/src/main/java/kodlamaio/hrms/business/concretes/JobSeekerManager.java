package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adepters.UserVerificationService;
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
	private UserVerificationService userVerificationService;
	private UserService userService;
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,UserVerificationService userVerificationService,UserService userService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userVerificationService=userVerificationService;
		this.userService=userService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"iş arayanlar listelendi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		boolean identityVerification=this.userVerificationService.identityVerification(jobSeeker.getIdentityNumber(), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getYearOfBirth());

		if(identityVerification)
		{
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("İş arayan eklendi.");
		}
		return new ErrorResult("kullanıcı kaydı tamamlanamıyor.");
	}
	
	private void getByIdentityNumber(String identityNumber)//publicte olabilir.
	{
		//daha önce tc kimlik numarası kullanılmış mı
	}

}
