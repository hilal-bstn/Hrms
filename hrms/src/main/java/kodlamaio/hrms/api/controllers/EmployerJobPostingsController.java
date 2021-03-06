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

import kodlamaio.hrms.business.abstracts.EmployerJobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerJobPosting;

@RestController
@RequestMapping("/api/employerjobpostings")
@CrossOrigin
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
	
	@GetMapping("/getByReleaseDateAndIsActiveSorted")
	public DataResult<List<EmployerJobPosting>> getByReleaseDateAndIsActiveSorted()
	{
		return this.employerJobPostingService.getByReleaseDateAndIsActiveSorted();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerJobPosting employerJobPosting)
	{
		return this.employerJobPostingService.add(employerJobPosting);
	}
	 
	@PostMapping("/delete")
	public Result delete(@RequestParam int id)
	{
		return this.employerJobPostingService.delete(id);
	}
	@GetMapping("/getById")
	public DataResult<EmployerJobPosting> getById(int id)
	{
		return this.employerJobPostingService.getById(id);
	}

	
	@PostMapping("/release")
	public Result release(@RequestParam int id)
	{
		return this.employerJobPostingService.release(id);
	}
	@GetMapping("/getByEmployerIdAndIsActive")
	public DataResult<List<EmployerJobPosting>> getByEmployerIdAndIsActive(int employerId)
	{
		return this.employerJobPostingService.getByEmployerIdAndIsActive(employerId);
	}
	@GetMapping("/getbyfiter")
	public DataResult<List<EmployerJobPosting>> getByFilter(@RequestParam(required=false) Integer cityId,@RequestParam(required=false) Integer jobPositionId,
			@RequestParam(required=false) Integer typeOfWorkId,@RequestParam(required=false) Integer timeOfWorkId)
	{
		return this.employerJobPostingService.getByFilter( cityId, jobPositionId, typeOfWorkId, timeOfWorkId);
	}
}
