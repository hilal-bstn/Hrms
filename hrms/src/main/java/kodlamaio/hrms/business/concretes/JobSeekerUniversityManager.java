package kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerUniversityService;
import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerUniversityDao;
import kodlamaio.hrms.entities.concretes.JobSeekerUniversity;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;

@Service
public class JobSeekerUniversityManager implements JobSeekerUniversityService {
	private JobSeekerUniversityDao jobSeekerUniversityDao;
	private UniversityDepartmentService universityDepartmentService;
	@Autowired
	public JobSeekerUniversityManager(JobSeekerUniversityDao jobSeekerUniversityDao,UniversityDepartmentService universityDepartmentService) {
		super();
		this.jobSeekerUniversityDao = jobSeekerUniversityDao;
		this.universityDepartmentService=universityDepartmentService;
	}
	@Override
	@Transactional
	public Result add(JobSeekerUniversity jobSeekerUniversity) {
		UniversityDepartment universityDepartment=this.universityDepartmentService.add(jobSeekerUniversity.getUniversityDepartment()).getData();
		jobSeekerUniversity.setUniversityDepartment(universityDepartment);
		this.jobSeekerUniversityDao.save(jobSeekerUniversity);
		return new SuccessResult();
	}
	@Override
	public DataResult<List<JobSeekerUniversity>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<JobSeekerUniversity>>(this.jobSeekerUniversityDao.getByJobSeekerId(id));
	}
	@Override
	public DataResult<List<JobSeekerUniversity>> getGraduationYearDesc(int id) {
		return new SuccessDataResult<List<JobSeekerUniversity>>(this.jobSeekerUniversityDao.getGraduationYearAsc(id));
	}
}
