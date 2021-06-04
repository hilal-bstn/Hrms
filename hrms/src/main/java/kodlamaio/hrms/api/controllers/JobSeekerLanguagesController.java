package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("/api/jobseekerlanguages")
public class JobSeekerLanguagesController {
	private JobSeekerLanguageService jobSeekerLanguageService;
	@Autowired
	public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
		super();
		this.jobSeekerLanguageService = jobSeekerLanguageService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerLanguage jobSeekerLanguage)
	{
		return this.jobSeekerLanguageService.add(jobSeekerLanguage);
	}
	
	@GetMapping("/getbyjobseekerid")
	public DataResult<List<JobSeekerLanguage>> getByJobSeekerId(@RequestParam int id)
	{
		return this.jobSeekerLanguageService.getByJobSeekerId(id);
	}
}
