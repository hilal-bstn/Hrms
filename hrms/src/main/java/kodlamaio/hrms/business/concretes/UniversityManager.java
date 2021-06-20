package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UniversityDao;
import kodlamaio.hrms.entities.concretes.University;

@Service
public class UniversityManager implements UniversityService {
	private UniversityDao universityDao;
	@Autowired
	public UniversityManager(UniversityDao universityDao) {
		super();
		this.universityDao = universityDao;
	}
	@Override
	public Result add(University university) {
		if(checkUniversityName(university.getName().toLowerCase()).isSuccess())
		{
			university.setName(university.getName().toLowerCase());
			this.universityDao.save(university);
			return new SuccessResult("üniversite kaydedildi.");
		}
		return new ErrorResult();
	}
	@Override
	public DataResult<University> getByName(String name) {
		return new SuccessDataResult<University>(this.universityDao.getByName(name));
	}
	private Result checkUniversityName(String name)
	{
		University university=this.getByName(name).getData();
		if(university==null)
		{
			return new SuccessResult();
		}
		return new ErrorResult("üniversite listede mevcut");
	}
	@Override
	public DataResult<List<University>> getAll() {
		return new SuccessDataResult<List<University>>(this.universityDao.findAll());
	}


}
