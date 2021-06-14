package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TimeOfWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.TimeOfWorkDao;
import kodlamaio.hrms.entities.concretes.TimeOfWork;

@Service
public class TimeOfWorkManager implements TimeOfWorkService {
	private TimeOfWorkDao timeOfWorkDao;
	@Autowired
	public TimeOfWorkManager(TimeOfWorkDao timeOfWorkDao) {
		super();
		this.timeOfWorkDao = timeOfWorkDao;
	}
	@Override
	public DataResult<List<TimeOfWork>> getAll() {
		return new SuccessDataResult<List<TimeOfWork>>(this.timeOfWorkDao.findAll());
	}

}
