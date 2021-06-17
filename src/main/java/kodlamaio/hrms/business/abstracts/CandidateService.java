package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Photo;
import kodlamaio.hrms.entities.concretes.Users;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
    Result add(Candidate candidate);
    
    
    DataResult<List<CandidateCvDto>> getAllCv();
    
}
