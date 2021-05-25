package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.concretes.DataResult;
import kodlamaio.hrms.core.concretes.Result;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersService {
	
	DataResult<List<Employers>> getAll();
	Result add(Employers employers);
	
}
