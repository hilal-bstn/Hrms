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

import kodlamaio.hrms.business.abstracts.FavoriteJobPostingOfJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobPostingOfJobSeeker;

@RestController
@RequestMapping("/api/favoritejobpostingsofjobseeker")
@CrossOrigin
public class FavoriteJobPostingsOfJobSeekerController {
	private FavoriteJobPostingOfJobSeekerService favoriteJobPostingsOfJobSeekerService;
	@Autowired
	public FavoriteJobPostingsOfJobSeekerController(
			FavoriteJobPostingOfJobSeekerService favoriteJobPostingsOfJobSeekerService) {
		super();
		this.favoriteJobPostingsOfJobSeekerService = favoriteJobPostingsOfJobSeekerService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody FavoriteJobPostingOfJobSeeker favoriteJobPostingOfJobSeeker) {
		return this.favoriteJobPostingsOfJobSeekerService.add(favoriteJobPostingOfJobSeeker);
	}
	@PostMapping("/delete")
	public Result add(@RequestParam int id ) {
		return this.favoriteJobPostingsOfJobSeekerService.delete(id);
	}
	@GetMapping("/getByJobSeekerId")
	public DataResult<List<FavoriteJobPostingOfJobSeeker>> getByJobSeekerId(int jobSeekerId)
	{
		return this.favoriteJobPostingsOfJobSeekerService.getByJobSeekerId(jobSeekerId);
	}
}
