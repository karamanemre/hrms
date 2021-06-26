package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.dtos.LanguageDto;


public interface Languageservice {
	
	Result add(Languages languages);
	DataResult<List<Languages>> getAll();
	Languages getById(int id);
	DataResult<List<LanguageDto>> findByCandidateNumberDto(int candidateNumber);
	Result uptadeLanguage(int id ,Languages languages);
	LanguageDto getByIdDto(int id);
	
}
