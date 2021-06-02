package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;


public interface CandidateCvService {
	
	DataResult<List<CandidateCv>> findAll();
	Result add(CandidateCv candidateCv);
	
	DataResult<List<CandidateCvDto>> getAllDto(int id);
	
	DataResult<List<CandidateCv>> getByCandidateId(int id);

}
