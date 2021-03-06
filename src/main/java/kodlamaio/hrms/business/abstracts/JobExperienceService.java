package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperience>> getAllOrderByFinishYearDesc();
	
	DataResult<List<JobExperience>> findByCandidateNumber(int id);
	
	JobExperience getById(int id);
	
	Result uptadeJobExperience(int id ,JobExperience jobExperience);
}
