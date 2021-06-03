package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.entities.concretes.TechnologyNameList;


public interface TechnologyNameListService {
	
	DataResult<List<TechnologyNameList>> getAll();
	
}
