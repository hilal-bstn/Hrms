package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerUniversity;

public interface JobSeekerUniversityDao extends JpaRepository<JobSeekerUniversity,Integer> {
	List<JobSeekerUniversity> getByJobSeekerId(int id);

}
