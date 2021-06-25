package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.FavoriteJobPostingOfJobSeeker;

public interface FavoriteJobPostingOfJobSeekerDao extends JpaRepository<FavoriteJobPostingOfJobSeeker,Integer>{
  List<FavoriteJobPostingOfJobSeeker> getByJobSeekerId(int id);
  FavoriteJobPostingOfJobSeeker getById(int id);
}
