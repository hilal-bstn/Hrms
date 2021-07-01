package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.EmployerJobPosting;

public interface EmployerJobPostingDao extends JpaRepository<EmployerJobPosting,Integer>{
	  
	  List<EmployerJobPosting>  getByEmployerIdAndIsActive(int employerId,boolean active);

	  List<EmployerJobPosting> getByIsActive(boolean active);
	  
	  EmployerJobPosting getById(int id);
	  
	  @Query("From EmployerJobPosting where isActive=true Order By releaseDate Desc")
	  List<EmployerJobPosting> getByReleaseDateDesc();
	  
	  
	  //https://www.baeldung.com/spring-data-jpa-null-parameters   "sorgu yazımı"
	  
	  //Error: "Optional int parameter 'typeOfWorkId' is present but cannot be translated into a 
	  //null value due to being declared as a primitive type" hatasından dolayı int değil integer tipi.
	  
	  //https://stackoverflow.com/questions/55861726/optional-int-parameter-is-present-but-cannot-be-translated-into-a-null-value
	  
	  @Query("Select j from kodlamaio.hrms.entities.concretes.EmployerJobPosting j where "
	  		+ "((:cityId is null or j.city.id=:cityId)) and "
	  		+ "((:jobPositionId is null or j.jobPosition.id=:jobPositionId)) and"
	  		+ "((:typeOfWorkId is null or j.typeOfWork.id=:typeOfWorkId)) and"
	  		+ "((:timeOfWorkId is null or j.timeOfWork.id=:timeOfWorkId)) and isActive=true")
	  List<EmployerJobPosting> getByFilter(  @Param("cityId") Integer cityId,@Param("jobPositionId") Integer jobPositionId,@Param("typeOfWorkId") Integer typeOfWorkId,@Param("timeOfWorkId") Integer timeOfWorkId);
	  
} 
