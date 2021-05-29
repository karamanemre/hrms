package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobPostings;

public interface JobPostingService {
	DataResult<List<JobPostings>> getAll();
	Result add(JobPostings jobPostings);

	DataResult<List<JobPostings>> findAllByActiveTrue();
	DataResult<List<JobPostings>> findAllByIsActiveTrueOrderByApplicaitonDeadline();
	
	/*
	Result setIsActiveValue(int id,boolean value);
	
	DataResult<List<JobPostings>> getByIsActiveTrueAndEmployer(int id);*/
	
}
