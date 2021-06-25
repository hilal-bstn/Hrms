package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;

public interface JobSeekerPhotoService {
	Result add(JobSeekerPhoto jobSeekerPhoto,MultipartFile file);
	DataResult<JobSeekerPhoto> getByJobSeekerId(int jobSeekerId);
}
