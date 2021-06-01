package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerJobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerJobPostingDao;
import kodlamaio.hrms.entities.concretes.EmployerJobPosting;


@Service
public class EmployerJobPostingManager implements EmployerJobPostingService  {
	private EmployerJobPostingDao employerJobPostingDao;
	@Autowired
	public EmployerJobPostingManager(EmployerJobPostingDao employerJobPostingDao) {
		super();
		this.employerJobPostingDao = employerJobPostingDao;
	}
	
	@Override
	public DataResult<List<EmployerJobPosting>> getByIsActive() //aktif iş ilanlarını listeleme
	{
		return new SuccessDataResult<List<EmployerJobPosting>>(this.employerJobPostingDao.getByIsActive(true),"güncel iş ilanları listelendi.");
	}
	
	@Override
	public Result add(EmployerJobPosting employerJobPosting) 
	{ 
		employerJobPosting.setReleaseDate(Date.valueOf(LocalDate.now()));
		employerJobPosting.setIsActive(true);
		this.employerJobPostingDao.save(employerJobPosting);
		return new SuccessResult("İş ilanı başarıyla oluşturulmuştur.");
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

}
