package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.University;

public interface UniversityService {
	
	Result add(University university);
	
	DataResult<University> getByName(String name);
	DataResult<List<University>> getAll();

}
