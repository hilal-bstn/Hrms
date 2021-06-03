package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

@RestController
@RequestMapping("/api/jobseekerexperiences")
public class JobSeekerExperiencesController {
	private JobSeekerExperienceService jobSeekerExperienceService;
	@Autowired
	public JobSeekerExperiencesController(JobSeekerExperienceService jobSeekerExperienceService) {
		super();
		this.jobSeekerExperienceService = jobSeekerExperienceService;
	}
	@PostMapping("/add")
	public Result add(JobSeekerExperience jobSeekerExperience)
	{
		return this.jobSeekerExperienceService.add(jobSeekerExperience);
	}
	@GetMapping("/getbyjobseekerid")
	public DataResult<List<JobSeekerExperience>> getByJobSeekerId(int id)
	{
		return this.jobSeekerExperienceService.getByJobSeekerId(id);
	}
	@GetMapping("/getterminationyearasc")
	public DataResult<List<JobSeekerExperience>> getTerminationYearAsc(int id)
	{
		return this.jobSeekerExperienceService.getTerminationYearAsc(id);
	}
}
