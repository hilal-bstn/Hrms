package kodlamaio.hrms.business.concretes;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerPhotoService;
import kodlamaio.hrms.core.adepters.fileHelper.FileService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerPhotoDao;
import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;

@Service
public class JobSeekerPhotoManager implements JobSeekerPhotoService {
	private JobSeekerPhotoDao jobSeekerPhotoDao;
	private FileService fileService;
	@Autowired
	public JobSeekerPhotoManager(JobSeekerPhotoDao jobSeekerPhotoDao,FileService fileService) {
		super();
		this.jobSeekerPhotoDao = jobSeekerPhotoDao;
		this.fileService=fileService;
	}
	@Override
	public Result add(JobSeekerPhoto jobSeekerPhoto, MultipartFile file) {
		Map<String,String> photo=(Map<String,String>) this.fileService.imageUpload(file).getData();
		String url=photo.get("url");
		System.out.println(url);
		jobSeekerPhoto.setImageUrl(url);
		this.jobSeekerPhotoDao.save(jobSeekerPhoto);
		return new SuccessResult();
	}
	
}
