package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Technology;


public interface TechnologyService {
	
	Result add(Technology technology);

	DataResult<Technology> getByName(String name);
}
