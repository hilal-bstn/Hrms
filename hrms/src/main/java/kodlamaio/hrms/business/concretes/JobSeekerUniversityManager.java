package kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerUniversityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerUniversityDao;
import kodlamaio.hrms.entities.concretes.JobSeekerUniversity;

@Service
public class JobSeekerUniversityManager implements JobSeekerUniversityService {
	private JobSeekerUniversityDao jobSeekerUniversityDao;
	@Autowired
	public JobSeekerUniversityManager(JobSeekerUniversityDao jobSeekerUniversityDao) {
		super();
		this.jobSeekerUniversityDao = jobSeekerUniversityDao;
	}
	@Override
	@Transactional
	public Result add(JobSeekerUniversity jobSeekerUniversity) {
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
	@Override
	public Result update(JobSeekerUniversity jobSeekerUniversity) {
		JobSeekerUniversity jobSeekerUniversityUpdate=this.getById(jobSeekerUniversity.getId()).getData();
		jobSeekerUniversityUpdate=jobSeekerUniversity;
		this.jobSeekerUniversityDao.save(jobSeekerUniversityUpdate);
		return new SuccessResult("Güncellendi.");
	}
	@Override
	public DataResult<JobSeekerUniversity> getById(int id) {
		return new SuccessDataResult<JobSeekerUniversity>(this.jobSeekerUniversityDao.getById(id));
	}
}
