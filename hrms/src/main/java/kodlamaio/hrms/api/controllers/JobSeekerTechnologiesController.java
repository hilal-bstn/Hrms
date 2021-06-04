package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerTechnology;


@RestController
@RequestMapping("/api/jobseekertechnologies")
public class JobSeekerTechnologiesController {
	private JobSeekerTechnologyService jobSeekerTechnologyService;
	@Autowired
	public JobSeekerTechnologiesController(JobSeekerTechnologyService jobSeekerTechnologyService) {
		super();
		this.jobSeekerTechnologyService = jobSeekerTechnologyService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerTechnology jobSeekerTechnology)
	{
		return this.jobSeekerTechnologyService.add(jobSeekerTechnology);
	}
	@GetMapping("/getbyjobseekerid")
	public DataResult<List<JobSeekerTechnology>> getByJobSeekerId(@RequestParam int id)
	{
		return this.jobSeekerTechnologyService.getByJobSeekerId(id);
	}
}
