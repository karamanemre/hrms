package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguageNameList;

public interface ProgrammingLanguageNameListService {
	
	Result add(ProgrammingLanguageNameList programmingLanguageNameList);
	DataResult<List<ProgrammingLanguageNameList>> getAll();
	
}
