package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.University;

@RestController
@RequestMapping("/api/universities")
@CrossOrigin
public class UniversitiesController {
	private UniversityService universityService;
	@Autowired
	public UniversitiesController(UniversityService universityService) {
		super();
		this.universityService = universityService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody University university)
	{
		return this.universityService.add(university);
	}
	@GetMapping("/getall")
	public DataResult<List<University>> getAll()
	{
		return this.universityService.getAll();
	}
}
