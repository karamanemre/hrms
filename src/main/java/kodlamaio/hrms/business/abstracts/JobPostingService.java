package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobPostings;

public interface JobPostingService {
	DataResult<List<JobPostings>> getAll();
	Result add(JobPostings jobPostings);
	DataResult<List<JobPostings>> getAllSortedDesc();
	DataResult<List<JobPostings>> getAllSortedAsc();
	DataResult<List<JobPostings>> findAllByActive(boolean jobPosting);
	DataResult<List<JobPostings>> findAllByIsActiveTrueOrderByApplicaitonDeadline();
	DataResult<List<JobPostings>> getByIsActiveAndEmployer(boolean bool,int id);
	
	
	
}
