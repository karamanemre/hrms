package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguages;

public interface ProgrammingLanguageService {
	
	
	Result add(ProgrammingLanguages programmingLanguages);
	DataResult<List<ProgrammingLanguages>> getAll();
}
