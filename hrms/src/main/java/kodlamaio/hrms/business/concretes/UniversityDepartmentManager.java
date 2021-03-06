package kodlamaio.hrms.business.concretes;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UniversityDepartmentDao;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;


@Service
public class UniversityDepartmentManager implements UniversityDepartmentService {
	private UniversityDepartmentDao universityDepartmentDao;
	@Autowired
	public UniversityDepartmentManager(UniversityDepartmentDao universityDepartmentDao) {
		super();
		this.universityDepartmentDao = universityDepartmentDao;
	}
	@Override
	@Transactional
	public DataResult<UniversityDepartment> add(UniversityDepartment universityDepartment) {
		if(checkUniversityDepartmentName(universityDepartment.getName().toLowerCase()).isSuccess())
		{
			universityDepartment.setName(universityDepartment.getName().toLowerCase());
			this.universityDepartmentDao.save(universityDepartment);
		}
		return new SuccessDataResult<UniversityDepartment>(this.getByName(universityDepartment.getName().toLowerCase()).getData(),"kayıt başarılı");
		
	}
	@Override
	public DataResult<UniversityDepartment> getByName(String name) {
		return new SuccessDataResult<UniversityDepartment>(this.universityDepartmentDao.getByName(name));
	}
	private Result checkUniversityDepartmentName(String name)
	{
		UniversityDepartment universityDepartment=this.getByName(name).getData();
		if(universityDepartment==null)
		{
			return new SuccessResult();
		}
		return new ErrorResult("Bu bölüm listede mevcut");
	}
	@Override
	public DataResult<List<UniversityDepartment>> getAll() {
		return new SuccessDataResult<List<UniversityDepartment>>(this.universityDepartmentDao.findAll());
	}
	
	
}
