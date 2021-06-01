package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerUniversity;

public interface JobSeekerUniversityDao extends JpaRepository<JobSeekerUniversity,Integer> {

}
