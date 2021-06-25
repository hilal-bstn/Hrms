package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;


public interface JobSeekerPhotoDao extends JpaRepository<JobSeekerPhoto,Integer>{
	  @Query("From JobSeekerPhoto where jobSeeker.id=:jobSeekerId")
	JobSeekerPhoto getByJobSeekerId(int jobSeekerId);
}
