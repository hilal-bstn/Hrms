package kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerTechnologyService;
import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerTechnologyDao;
import kodlamaio.hrms.entities.concretes.JobSeekerTechnology;
import kodlamaio.hrms.entities.concretes.Technology;

@Service
public class JobSeekerTechnologyManager implements JobSeekerTechnologyService{
	private JobSeekerTechnologyDao jobSeekerTechnologyDao;
	private TechnologyService technologyService;
	@Autowired
	public JobSeekerTechnologyManager(JobSeekerTechnologyDao jobSeekerTechnologyDao,TechnologyService technologyService) {
		super();
		this.jobSeekerTechnologyDao = jobSeekerTechnologyDao;
		this.technologyService=technologyService;
	}
	@Override
	@Transactional
	public Result add(JobSeekerTechnology jobSeekerTechnology) {
		Technology technology=this.technologyService.add(jobSeekerTechnology.getTechnology()).getData();
		jobSeekerTechnology.setTechnology(technology);
		this.jobSeekerTechnologyDao.save(jobSeekerTechnology);
		return new SuccessResult("Eklendi.");
	}
	@Override
	public DataResult<List<JobSeekerTechnology>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<JobSeekerTechnology>>(this.jobSeekerTechnologyDao.getByJobSeekerId(id));
	}
	
}
