package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience,Integer> {

}
