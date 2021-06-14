package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TimeOfWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.TimeOfWork;

@RestController
@RequestMapping("/api/timesofwork")
@CrossOrigin
public class TimesOfWorkController {
	private TimeOfWorkService timeofWorkService;
	@Autowired
	public TimesOfWorkController(TimeOfWorkService timeofWorkService) {
		super();
		this.timeofWorkService = timeofWorkService;
	}
	@GetMapping("/getall")
	public DataResult<List<TimeOfWork>> getAll()
	{
		return this.timeofWorkService.getAll();
	}
}
