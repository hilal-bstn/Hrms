package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.HrmsEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.HrmsEmployee;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;


@RestController
@RequestMapping("/api/hrmsemployee")
@CrossOrigin
public class HrmsEmployeeController {
	private HrmsEmployeeService hrmsEmployeeService;
	@Autowired
	public HrmsEmployeeController(HrmsEmployeeService hrmsEmployeeService) {
		super();
		this.hrmsEmployeeService = hrmsEmployeeService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody HrmsEmployee hrmsEmployee) {
		return this.hrmsEmployeeService.add(hrmsEmployee);
	}
	@GetMapping("/getbyid")
	public DataResult<HrmsEmployee> getById(@RequestParam int id)
	{
		return this.hrmsEmployeeService.getById(id);
	}
	@PostMapping("/update")
	public Result update(@RequestBody HrmsEmployee hrmsEmploye)
	{
		return this.hrmsEmployeeService.update(hrmsEmploye);
	}
}
