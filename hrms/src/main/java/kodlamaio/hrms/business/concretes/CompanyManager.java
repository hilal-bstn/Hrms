package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;

@Service
public class CompanyManager implements CompanyService {
	
	private CompanyDao companyDao;
	@Autowired
	public CompanyManager(CompanyDao companyDao) {
		super();
		this.companyDao = companyDao;
	}

	@Override
	public DataResult<List<Company>> getAll() {
		
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(),"Şirketler listelendi");
	}

	@Override
	public Result add(Company company) {
		this.companyDao.save(company);
		return new SuccessResult("Şirket kaydedildi.");
	}

	@Override
	public Result update(Company company) {
		Company companyUpdate=this.getById(company.getId()).getData();
		companyUpdate=company;
		this.companyDao.save(companyUpdate);
		return new SuccessResult();
	}

	@Override
	public DataResult<Company> getById(int id) {
		return new SuccessDataResult<Company>(this.companyDao.getById(id));
	}

}
