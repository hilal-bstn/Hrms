package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerContact;

public interface JobSeekerContactService {
	Result add(JobSeekerContact jobSeekerContact);
}
