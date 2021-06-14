package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.TimeOfWork;

public interface TimeOfWorkDao extends JpaRepository<TimeOfWork,Integer> {

}
