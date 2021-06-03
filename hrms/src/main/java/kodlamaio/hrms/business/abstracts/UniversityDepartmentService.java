package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;


public interface UniversityDepartmentService {
	
	DataResult<UniversityDepartment> add(UniversityDepartment universityDepartment);
	
	DataResult<UniversityDepartment> getByName(String name);

}
