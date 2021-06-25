package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FavoriteJobPostingOfJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteJobPostingOfJobSeekerDao;
import kodlamaio.hrms.entities.concretes.FavoriteJobPostingOfJobSeeker;

@Service
public class FavoriteJobPostingOfJobSeekerManager implements FavoriteJobPostingOfJobSeekerService{
	private FavoriteJobPostingOfJobSeekerDao favoriteJobPostingOfJobSeekerDao;
	@Autowired
	public FavoriteJobPostingOfJobSeekerManager(FavoriteJobPostingOfJobSeekerDao favoriteJobPostingOfJobSeekerDao) {
		super();
		this.favoriteJobPostingOfJobSeekerDao = favoriteJobPostingOfJobSeekerDao;
	}
	@Override
	public Result add(FavoriteJobPostingOfJobSeeker favoriteJobPostingOfJobSeeker) {//favorilere ekleme
		this.favoriteJobPostingOfJobSeekerDao.save(favoriteJobPostingOfJobSeeker);
		return null;
	}
	@Override
	public Result delete(int id) {//favorilerden silme
		FavoriteJobPostingOfJobSeeker favoriteJobPostingOfJobSeeker=this.getById(id).getData();
		this.favoriteJobPostingOfJobSeekerDao.delete(favoriteJobPostingOfJobSeeker);
		return new SuccessResult("İlan favorilerden silindi.");
	}
	@Override
	public DataResult<List<FavoriteJobPostingOfJobSeeker>> getByJobSeekerId(int jobSeekerId) {//iş arayanın favorilerini görebilmesi.
		return new SuccessDataResult<List<FavoriteJobPostingOfJobSeeker>>(this.favoriteJobPostingOfJobSeekerDao.getByJobSeekerId(jobSeekerId));
	}
	@Override
	public DataResult<FavoriteJobPostingOfJobSeeker> getById(int id) {
		return new SuccessDataResult<FavoriteJobPostingOfJobSeeker>(this.favoriteJobPostingOfJobSeekerDao.getById(id));
	}
}
