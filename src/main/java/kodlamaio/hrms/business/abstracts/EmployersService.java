package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersService {
	
	DataResult<List<Employers>> getAll();
	Result add(Employers employers);
	DataResult<List<Employers>> getByUserId(int id);
	Result uptadeEmployers(Employers uptade_information);
	Result uptadeConfirmation(int userId);
	DataResult<List<Employers>> getByUptadeConfirmationWait();
	
	
}
