package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobApplication;

public interface JobApplicationDao extends JpaRepository<JobApplication,Integer> {

}
