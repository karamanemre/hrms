package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface CandidateCvService {
	
	Result add(CandidateCv candidateCv);
	DataResult<List<CandidateCv>> getAll();
	DataResult<List<CandidateCv>> getAllSchoolName();
	DataResult<List<CandidateCv>> getAllJobExperience();
	DataResult<List<CandidateCvDto>> getAllllll();
}
