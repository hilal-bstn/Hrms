package kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.EmployerUpdateConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUpdateConfirmationDao;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.EmployerUpdateConfirmation;

@Service
public class EmployerUpdateConfirmationManager implements EmployerUpdateConfirmationService {
	private EmployerUpdateConfirmationDao employerUpdateConfirmationDao;
	private CompanyService companyService;
	@Autowired
	public EmployerUpdateConfirmationManager(EmployerUpdateConfirmationDao employerUpdateConfirmationDao,CompanyService companyService) {
		super();
		this.employerUpdateConfirmationDao = employerUpdateConfirmationDao;
		this.companyService=companyService;
	}
	//güncelleme onay bekliyorsa isActive=true,
	//güncelleme onaylandıysa companyId ye ait kayıt yok(null).
	//güncelleme onaylanmadıysa isActive=false olur.
	@Override
	public Result add(EmployerUpdateConfirmation employerUpdateConfirmation) {//güncelleme onay bekliyor.(!=null)
		employerUpdateConfirmation.setIsActive(true);
		this.employerUpdateConfirmationDao.save(employerUpdateConfirmation);
		return new SuccessResult();
	}
	//Güncelleme Onaylandı(Tablodan silindi.)
	@Override
	@Transactional
	public Result confirmation(int id) {
		EmployerUpdateConfirmation employerUpdateConfirmation=this.getById(id).getData();
		Company company=this.companyService.getById(employerUpdateConfirmation.getCompany().getId()).getData();
		company.setCompanyName(employerUpdateConfirmation.getCompanyName());
		company.setPhone(employerUpdateConfirmation.getPhone());
		company.setWebsite(employerUpdateConfirmation.getWebsite());
		this.companyService.update(company);//Güncellendi
		this.employerUpdateConfirmationDao.delete(employerUpdateConfirmation);//Silindi.
		return new SuccessResult();
	}
	@Override
	public DataResult<List<EmployerUpdateConfirmation>> getAll() {
		return new SuccessDataResult<List<EmployerUpdateConfirmation>>(this.employerUpdateConfirmationDao.findAll());
	}
	@Override
	public DataResult<EmployerUpdateConfirmation> getById(int id) {
		return new SuccessDataResult<EmployerUpdateConfirmation>(this.employerUpdateConfirmationDao.getById(id));
	}
	@Override
	public Result updateFailed(int id) {
		EmployerUpdateConfirmation employerUpdateConfirmation=this.getById(id).getData();
		employerUpdateConfirmation.setIsActive(false);
		this.employerUpdateConfirmationDao.save(employerUpdateConfirmation);
		return new SuccessResult("Güncelleme izni verilmedi.");
	}
	@Override
	public DataResult<List<EmployerUpdateConfirmation>> getByIsActive() {
		return new SuccessDataResult<List<EmployerUpdateConfirmation>>(this.employerUpdateConfirmationDao.getByIsActive(true));
	}

}
