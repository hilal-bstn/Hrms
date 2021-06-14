package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPostingConfirmation;

@RestController
@RequestMapping("/api/jobpostingconfirmations")
@CrossOrigin
public class JobPostingConfirmationsController {
	private JobPostingConfirmationService jobPostingConfirmationService;

	public JobPostingConfirmationsController(JobPostingConfirmationService jobPostingConfirmationService) {
		super();
		this.jobPostingConfirmationService = jobPostingConfirmationService;
	}
	@GetMapping("/getByHrmsEmployeeConfirmation")
	public DataResult<List<JobPostingConfirmation>> getByHrmsEmployeeConfirmation()
	{
		return this.jobPostingConfirmationService.getByHrmsEmployeeConfirmation();
	}
	@PostMapping("/hrmsConfirmation")//onay
	public Result add(@RequestParam int id)
	{
		return this.jobPostingConfirmationService.hrmsConfirmation(id);
	}
}
