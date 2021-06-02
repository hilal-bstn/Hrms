package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;

@RestController
@RequestMapping("/api/universitydepartments")
public class UniversityDepartmentsController {
	private UniversityDepartmentService universityDepartmentService;
	@Autowired
	public UniversityDepartmentsController(UniversityDepartmentService universityDepartmentService) {
		super();
		this.universityDepartmentService = universityDepartmentService;
	}
	@PostMapping("/add")
	public Result add(UniversityDepartment universityDepartment)
	{
		return this.universityDepartmentService.add(universityDepartment);
	}
}
