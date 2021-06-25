package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.JobSeekerContact;

public interface JobSeekerContactDao extends JpaRepository<JobSeekerContact,Integer>{
	JobSeekerContact getByJobSeekerId(int id);
	JobSeekerContact getById(int id);
}
