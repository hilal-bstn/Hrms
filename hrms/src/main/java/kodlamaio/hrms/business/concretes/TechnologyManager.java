package kodlamaio.hrms.business.concretes;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	private TechnologyDao technologyDao;
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		super();
		this.technologyDao = technologyDao;
	}
	@Override
	@Transactional
	public DataResult<Technology> add(Technology technology) {
		if(checkTechnologyName(technology.getName().toLowerCase()).isSuccess()) 
		{
			technology.setName(technology.getName().toLowerCase());
			this.technologyDao.save(technology);
		}
		return new SuccessDataResult<Technology>(this.getByName(technology.getName().toLowerCase()).getData(),"kayıt başarılı");
	}
	@Override
	public DataResult<Technology> getByName(String name) {
		return new SuccessDataResult<Technology>(this.technologyDao.getByName(name));
	}
	private Result checkTechnologyName(String name)
	{
		Technology technology=this.getByName(name).getData();
		if(technology==null)
		{
			return new SuccessResult();
		}
		return new ErrorResult("Listede mevcut");
	}
	
}
