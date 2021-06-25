package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.HrmsEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.HrmsEmployeeDao;
import kodlamaio.hrms.entities.concretes.HrmsEmployee;
@Service
public class HrmsEmployeeManager implements HrmsEmployeeService {
	private HrmsEmployeeDao hrmsEmployeeDao;
	@Autowired
	public HrmsEmployeeManager(HrmsEmployeeDao hrmsEmployeeDao) {
		super();
		this.hrmsEmployeeDao = hrmsEmployeeDao;
	}
	@Override
	public Result add(HrmsEmployee hrmsEmployee) {
		this.hrmsEmployeeDao.save(hrmsEmployee);
		return new SuccessResult("Sisteme yeni bir personel eklendi.");
	}
	@Override
	public Result update(HrmsEmployee hrmsEmployee) {
		HrmsEmployee hrmsEmployeeUpdate=this.getById(hrmsEmployee.getId()).getData();
		hrmsEmployeeUpdate=hrmsEmployee;
		this.hrmsEmployeeDao.save(hrmsEmployeeUpdate);
		return new SuccessResult("Bilgiler güncellenmiştir.");
	}
	@Override
	public DataResult<HrmsEmployee> getById(int id) {
		return new SuccessDataResult<HrmsEmployee>(this.hrmsEmployeeDao.getById(id));
	}
}
