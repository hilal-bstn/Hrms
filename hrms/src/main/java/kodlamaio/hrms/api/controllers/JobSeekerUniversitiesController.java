package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerUniversityService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerUniversity;

@RestController
@RequestMapping("/api/jobseekeruniversities")
public class JobSeekerUniversitiesController {
	private JobSeekerUniversityService jobSeekerUniversityService;
	@Autowired
	public JobSeekerUniversitiesController(JobSeekerUniversityService jobSeekerUniversityService) {
		super();
		this.jobSeekerUniversityService = jobSeekerUniversityService;
	}
	@PostMapping("/add")
	public Result add(JobSeekerUniversity jobSeekerUniversity)
	{
		return this.jobSeekerUniversityService.add(jobSeekerUniversity);
	}
}