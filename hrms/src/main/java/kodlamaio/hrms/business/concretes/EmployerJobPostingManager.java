package kodlamaio.hrms.business.concretes;


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
	public DataResult<List<EmployerJobPosting>> getAll() {
		return new SuccessDataResult<List<EmployerJobPosting>>(this.employerJobPostingDao.findAll());
	}
	@Override
	public Result add(EmployerJobPosting employerJobPosting) 
	{ 
	
		employerJobPosting.setIsActive(true);
		this.employerJobPostingDao.save(employerJobPosting);
		return new SuccessResult("İş ilanı başarıyla oluşturulmuştur.");
	}
	@Override
	public Result delete(int id) {
		EmployerJobPosting jobPosting=this.getById(id).getData();
		jobPosting.setIsActive(false);
		return new SuccessResult();
	}
	@Override
	public DataResult<EmployerJobPosting> getById(int Id) {
		return new SuccessDataResult<EmployerJobPosting>(this.employerJobPostingDao.getById(Id));
	}
}
