package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerCoverLetter;

public interface JobSeekerCoverLetterDao extends JpaRepository<JobSeekerCoverLetter,Integer>{
	List<JobSeekerCoverLetter> getByJobSeekerId(int id);
}
