package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerPhotoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;

@RestController
@RequestMapping("/api/jobseekerphotos")
@CrossOrigin
public class JobSeekerPhotosController {
	private JobSeekerPhotoService jobSeekerPhotoService;
	@Autowired
	public JobSeekerPhotosController(JobSeekerPhotoService jobSeekerPhotoService) {
		super();
		this.jobSeekerPhotoService = jobSeekerPhotoService;
	}
	@PostMapping("/add")
	public Result add(@RequestParam int id,@RequestParam MultipartFile file)
	{
		JobSeekerPhoto jobSeekerPhoto = new JobSeekerPhoto();
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setId(id);
		jobSeekerPhoto.setJobSeeker(jobSeeker);
		return this.jobSeekerPhotoService.add(jobSeekerPhoto,file);
	}
	@GetMapping("/getbyjobseekerid")
	public DataResult<JobSeekerPhoto> getByJobSeekerId(@RequestParam int jobSeekerId)
	{
		return this.jobSeekerPhotoService.getByJobSeekerId(jobSeekerId);
	}
}
