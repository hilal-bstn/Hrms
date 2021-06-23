package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobApplicationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobApplication;

@RestController
@RequestMapping("/api/jobapplications")
@CrossOrigin
public class JobApplicationsController {
private JobApplicationService jobApplicationService;
@Autowired
public JobApplicationsController(JobApplicationService jobApplicationService) {
	super();
	this.jobApplicationService = jobApplicationService;
}
@PostMapping("/add")
public Result add(@RequestBody JobApplication jobApplication) {
	return this.jobApplicationService.add(jobApplication);
}
}
