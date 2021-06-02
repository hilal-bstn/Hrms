package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCoverLetter;

public interface JobSeekerCoverLetterService {
	Result add(JobSeekerCoverLetter jobSeekerCoverLetter);
}
