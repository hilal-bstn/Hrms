package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
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
	public Result add(JobSeekerLanguage jobSeekerLanguage)
	{
		return this.jobSeekerLanguageService.add(jobSeekerLanguage);
	}
}
