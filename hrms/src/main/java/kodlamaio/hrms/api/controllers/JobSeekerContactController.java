package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerContactService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerContact;

@RestController
@RequestMapping("/api/jobseekercontact")
@CrossOrigin
public class JobSeekerContactController {
	private JobSeekerContactService jobSeekerContactService;
	@Autowired
	public JobSeekerContactController(JobSeekerContactService jobSeekerContactService) {
		super();
		this.jobSeekerContactService = jobSeekerContactService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerContact jobSeekerContact)
	{
		return this.jobSeekerContactService.add(jobSeekerContact);
	}
	
	@GetMapping("/getbyjobseekerid")
	public DataResult<JobSeekerContact> getByJobSeekerId(@RequestParam int id)
	{
		return this.jobSeekerContactService.getByJobSeekerId(id);
	}
}
