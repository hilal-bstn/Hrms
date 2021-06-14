package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.HrmsEmployeeService;
import kodlamaio.hrms.dataAccess.abstracts.HrmsEmployeeDao;
@Service
public class HrmsEmployeeManager implements HrmsEmployeeService {
	private HrmsEmployeeDao hrmsEmployeeDao;
	@Autowired
	public HrmsEmployeeManager(HrmsEmployeeDao hrmsEmployeeDao) {
		super();
		this.hrmsEmployeeDao = hrmsEmployeeDao;
	}
}
