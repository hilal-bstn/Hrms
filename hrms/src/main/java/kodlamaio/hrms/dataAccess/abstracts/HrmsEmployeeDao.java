package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.HrmsEmployee;

public interface HrmsEmployeeDao extends JpaRepository<HrmsEmployee,Integer> {

}
