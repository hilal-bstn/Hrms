package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerJobPostingService;
import kodlamaio.hrms.business.abstracts.JobPostingConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerJobPostingDao;
import kodlamaio.hrms.entities.concretes.EmployerJobPosting;


@Service
public class EmployerJobPostingManager implements EmployerJobPostingService  {
	private EmployerJobPostingDao employerJobPostingDao;
	private JobPostingConfirmationService jobPostingConfirmationService;
	@Autowired
	public EmployerJobPostingManager(EmployerJobPostingDao employerJobPostingDao,JobPostingConfirmationService jobPostingConfirmationService) {
		super();
		this.employerJobPostingDao = employerJobPostingDao;
		this.jobPostingConfirmationService=jobPostingConfirmationService;
	}
	
	@Override
	public DataResult<List<EmployerJobPosting>> getByIsActive() //aktif iş ilanlarını listeleme
	{
		return new SuccessDataResult<List<EmployerJobPosting>>(this.employerJobPostingDao.getByIsActive(true),"güncel iş ilanları listelendi.");
	}
	//işverenin iş ilanı ekleyebilmesi
	@Override
	@Transactional
	public Result add(EmployerJobPosting employerJobPosting) 
	{ 
		employerJobPosting.setReleaseDate(Date.valueOf(LocalDate.now()));
		employerJobPosting.setIsActive(false);//yayından kaldırılabilmesi için
		EmployerJobPosting employerJobPostingSave=this.employerJobPostingDao.save(employerJobPosting);
		this.jobPostingConfirmationService.add(employerJobPostingSave);
		return new SuccessResult("İş ilanı onay bekliyor.");
	}
	
	@Override
	public Result delete(int id) //iş ilanını pasif hale getirme
	{
		EmployerJobPosting jobPosting=getById(id).getData();
		jobPosting.setIsActive(false);
		this.employerJobPostingDao.save(jobPosting);
		return new SuccessResult("İlan yayından kaldırılmıştır.");
	}
	@Override
	public DataResult<List<EmployerJobPosting>> getByEmployerIdAndIsActive(int Id)//işveren id ye göre tüm aktif iş ilanları 
	{
		return new SuccessDataResult<List<EmployerJobPosting>>(this.employerJobPostingDao.getByEmployerIdAndIsActive(Id, true));
	}

	@Override
	public DataResult<EmployerJobPosting> getById(int id) {
		return new SuccessDataResult<EmployerJobPosting>(this.employerJobPostingDao.getById(id));
	}

	@Override
	public DataResult<List<EmployerJobPosting>> getByReleaseDateAndIsActiveSorted() {
		
		return new SuccessDataResult<List<EmployerJobPosting>>(this.employerJobPostingDao.getByReleaseDateDesc());
	}

	@Override
	public Result IsActive(int id) {
		EmployerJobPosting employerJobPosting=this.getById(id).getData();
		employerJobPosting.setIsActive(true);//yayına alındı(onay verildikten sonra)(frontend)
		this.employerJobPostingDao.save(employerJobPosting);
		return new SuccessResult();
	}

	

}
