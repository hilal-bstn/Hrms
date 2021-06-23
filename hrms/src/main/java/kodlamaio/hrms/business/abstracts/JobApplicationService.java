package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobApplication;

public interface JobApplicationService {
  Result add(JobApplication jobApplication);
}
