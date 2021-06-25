package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.HrmsEmployee;

public interface HrmsEmployeeService {
	Result add(HrmsEmployee hrmsEmployee);
	
	Result update(HrmsEmployee hrmsEmployee);
	
	DataResult<HrmsEmployee> getById(int id);
}
