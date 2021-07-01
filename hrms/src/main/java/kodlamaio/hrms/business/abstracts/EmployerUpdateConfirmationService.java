package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployerUpdateConfirmation;

public interface EmployerUpdateConfirmationService{
	Result add(EmployerUpdateConfirmation employerUpdateConfirmation);
	
	Result confirmation(int id);
	
	DataResult<List<EmployerUpdateConfirmation>> getAll();
	
	DataResult<EmployerUpdateConfirmation> getById(int id);
	
	Result updateFailed(int id);
	
	DataResult<List<EmployerUpdateConfirmation>> getByIsActive();

}
