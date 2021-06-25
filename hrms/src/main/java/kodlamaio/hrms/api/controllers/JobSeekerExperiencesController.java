package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

@RestController
@RequestMapping("/api/jobseekerexperiences")
@CrossOrigin
public class JobSeekerExperiencesController {
	private JobSeekerExperienceService jobSeekerExperienceService;
	@Autowired
	public JobSeekerExperiencesController(JobSeekerExperienceService jobSeekerExperienceService) {
		super();
		this.jobSeekerExperienceService = jobSeekerExperienceService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerExperience jobSeekerExperience)
	{
		return this.jobSeekerExperienceService.add(jobSeekerExperience);
	}
	@GetMapping("/getbyjobseekerid")
	public DataResult<List<JobSeekerExperience>> getByJobSeekerId(@RequestParam int id)
	{
		return this.jobSeekerExperienceService.getByJobSeekerId(id);
	}
	@GetMapping("/getterminationyearasc")
	public DataResult<List<JobSeekerExperience>> getTerminationYearAsc(@RequestParam int id)
	{
		return this.jobSeekerExperienceService.getTerminationYearAsc(id);
	}
	@PostMapping("/update")
	public Result update(@RequestBody JobSeekerExperience jobSeekerExperience)
	{
		return this.jobSeekerExperienceService.update(jobSeekerExperience);
	}
}
