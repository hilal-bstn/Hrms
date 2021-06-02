package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerUniversityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
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
	@GetMapping("/getbyjobseekerid")
	public DataResult<List<JobSeekerUniversity>> getByJobSeekerId(int id)
	{
		return this.jobSeekerUniversityService.getByJobSeekerId(id);
	}
}
