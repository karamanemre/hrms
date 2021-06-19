package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;

public interface ProgrammingLanguageService {
	
	Result add(ProgrammingLanguage programmingLanguage);
	DataResult<List<ProgrammingLanguage>> getAll();
	
	DataResult<List<ProgrammingLanguageDto>> findByDto(int id);
	
}
