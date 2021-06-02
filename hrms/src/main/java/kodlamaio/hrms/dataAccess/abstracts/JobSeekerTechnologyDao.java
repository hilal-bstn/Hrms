package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerTechnology;

public interface JobSeekerTechnologyDao extends JpaRepository<JobSeekerTechnology,Integer> {
	List<JobSeekerTechnology> getByJobSeekerId(int id);

}
