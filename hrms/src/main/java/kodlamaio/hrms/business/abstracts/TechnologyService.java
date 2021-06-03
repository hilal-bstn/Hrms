package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Technology;


public interface TechnologyService {
	
	DataResult<Technology> add(Technology technology);

	DataResult<Technology> getByName(String name);
}
