package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCoverLetter;

@RestController
@RequestMapping("/api/jobseekercoverletters")
public class JobSeekerCoverLettersController {
	private JobSeekerCoverLetterService jobSeekerCoverLetterService;
	@Autowired
	public JobSeekerCoverLettersController(JobSeekerCoverLetterService jobSeekerCoverLetterService) {
		super();
		this.jobSeekerCoverLetterService = jobSeekerCoverLetterService;
	}
	@PostMapping("/add")
	public Result add(JobSeekerCoverLetter jobSeekerCoverLetter)
	{
		return this.jobSeekerCoverLetterService.add(jobSeekerCoverLetter);
	}
}
