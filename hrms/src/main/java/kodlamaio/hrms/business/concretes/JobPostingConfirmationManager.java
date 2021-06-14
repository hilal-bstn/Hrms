package kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingConfirmationDao;
import kodlamaio.hrms.entities.concretes.EmployerJobPosting;
import kodlamaio.hrms.entities.concretes.JobPostingConfirmation;
@Service
public class JobPostingConfirmationManager implements JobPostingConfirmationService {
	private JobPostingConfirmationDao jobPostingConfirmationDao;
	@Autowired
	public JobPostingConfirmationManager(JobPostingConfirmationDao jobPostingConfirmationDao) {
		super();
		this.jobPostingConfirmationDao = jobPostingConfirmationDao;
	}

	@Override
	public Result add(EmployerJobPosting employerJobPosting) {
		JobPostingConfirmation jobPostingConfirmation=new JobPostingConfirmation();
		jobPostingConfirmation.setEmployerJobPosting(employerJobPosting);
		jobPostingConfirmation.setHrmsEmployeeConfirmation(false);
		this.jobPostingConfirmationDao.save(jobPostingConfirmation);
		return new SuccessResult();
	}

	//hrms personelinin iş ilanına onay vermesi.
	@Override
	@Transactional
	public Result hrmsConfirmation(int id) {
		JobPostingConfirmation jobPostingConfirmation=this.getById(id).getData();
		jobPostingConfirmation.setHrmsEmployeeConfirmation(true);//onay verildi ama yayına alınmadı.(frontend)
		return new SuccessResult("Onay verildi.");
	}
	
	@Override 
	public DataResult<JobPostingConfirmation> getById(int id) {
		return new SuccessDataResult<JobPostingConfirmation>(this.jobPostingConfirmationDao.getById(id));
	}

	@Override
	public DataResult<List<JobPostingConfirmation>> getAll() {
		return new SuccessDataResult<List<JobPostingConfirmation>>(this.jobPostingConfirmationDao.findAll());
	}

	//hrms personelinin onay bekleyen iş ilanlarını görebilmesi
	@Override
	public DataResult<List<JobPostingConfirmation>> getByHrmsEmployeeConfirmation() {
		return new SuccessDataResult<List<JobPostingConfirmation>>(this.jobPostingConfirmationDao.getByHrmsEmployeeConfirmation(false));
	}
}
