package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerPhoto;


public interface JobSeekerPhotoDao extends JpaRepository<JobSeekerPhoto,Integer>{

}
