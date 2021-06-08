package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.LanguageNameList;

public interface LanguageNameListService {
	DataResult<List<LanguageNameList>> getAll();
	Result add(LanguageNameList languageNameList);

}
