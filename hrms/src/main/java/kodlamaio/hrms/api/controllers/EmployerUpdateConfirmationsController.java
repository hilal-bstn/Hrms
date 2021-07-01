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

import kodlamaio.hrms.business.abstracts.EmployerUpdateConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerUpdateConfirmation;

@RestController
@RequestMapping("/api/employerupdateconfirmations")
@CrossOrigin
public class EmployerUpdateConfirmationsController {
	private EmployerUpdateConfirmationService employerUpdateConfirmationService;
	@Autowired
	public EmployerUpdateConfirmationsController(
			EmployerUpdateConfirmationService employerUpdateConfirmationService) {
		super();
		this.employerUpdateConfirmationService = employerUpdateConfirmationService;
	}
	@GetMapping("/getAll")
	public DataResult<List<EmployerUpdateConfirmation>> getAll(){
		return this.employerUpdateConfirmationService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody EmployerUpdateConfirmation employerUpdateConfirmation) {
		return this.employerUpdateConfirmationService.add(employerUpdateConfirmation);
	}
	@PostMapping("/confirmation")
	public Result confirmation(@RequestParam int id) {
		return this.employerUpdateConfirmationService.confirmation(id);
	}
	@PostMapping("/updateFailed")
	public Result updateFailed(@RequestParam int id) {
		return this.employerUpdateConfirmationService.updateFailed(id);
	}
	@GetMapping("/getbyisactive")
	public DataResult<List<EmployerUpdateConfirmation>> getByIsActive(){
		return this.employerUpdateConfirmationService.getByIsActive();
	}
	@GetMapping("/getbyid")
	public DataResult<EmployerUpdateConfirmation> getById(int id){
		return this.employerUpdateConfirmationService.getById(id);
	}
}
