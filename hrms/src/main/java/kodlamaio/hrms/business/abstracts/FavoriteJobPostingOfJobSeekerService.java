package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobPostingOfJobSeeker;

public interface FavoriteJobPostingOfJobSeekerService {
 Result add(FavoriteJobPostingOfJobSeeker favoriteJobPostingOfJobSeeker);
 Result delete(int id);
 DataResult<List<FavoriteJobPostingOfJobSeeker>> getByJobSeekerId(int jobSeekerId);
 DataResult<FavoriteJobPostingOfJobSeeker> getById(int id);
}
