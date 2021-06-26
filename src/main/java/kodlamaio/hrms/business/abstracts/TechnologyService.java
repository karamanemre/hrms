package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

public interface TechnologyService {
	
	Result add(Technology technology);
	DataResult<List<Technology>> getAll();
	
	DataResult<List<TechnologyDto>> findByDto(int id);
	
	Technology getById(int id);
	TechnologyDto getByIdDto(int id);
	Result uptadeTechnology(int id,Technology technology);
	
}
