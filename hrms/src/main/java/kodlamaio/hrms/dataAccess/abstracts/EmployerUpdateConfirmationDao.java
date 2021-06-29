package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerUpdateConfirmation;

public interface EmployerUpdateConfirmationDao extends JpaRepository<EmployerUpdateConfirmation,Integer> {
	EmployerUpdateConfirmation getById(int id);
}
