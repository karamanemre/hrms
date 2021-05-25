package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.concretes.DataResult;
import kodlamaio.hrms.core.concretes.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
    Result add(Candidate candidate);
}
