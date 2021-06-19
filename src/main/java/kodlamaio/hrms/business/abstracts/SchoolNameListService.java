package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.SchoolNameList;

public interface SchoolNameListService {
	
	Result add(SchoolNameList schoolNameList);
	DataResult<List<SchoolNameList>> getAll();
	
    DataResult<List<SchoolNameList>> findById(int id);	
}
