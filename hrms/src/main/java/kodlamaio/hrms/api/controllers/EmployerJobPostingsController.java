package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerJobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerJobPosting;

@RestController
@RequestMapping("/api/employerjobpostings")
public class EmployerJobPostingsController {
	private EmployerJobPostingService employerJobPostingService;
	@Autowired
	public EmployerJobPostingsController(EmployerJobPostingService employerJobPostingService) {
		super();
		this.employerJobPostingService = employerJobPostingService;
	}
	@GetMapping("/getbyisactive")
	public DataResult<List<EmployerJobPosting>> getByIsActive()
	{
		return this.employerJobPostingService.getByIsActive();
	}
	
	@PostMapping("/add")
	public Result add(EmployerJobPosting employerJobPosting)
	{
		return this.employerJobPostingService.add(employerJobPosting);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id)
	{
		return this.employerJobPostingService.delete(id);
	}
}
