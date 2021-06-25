package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage,Integer>{
	List<JobSeekerLanguage> getByJobSeekerId(int id);

	JobSeekerLanguage getById(int id);
}
