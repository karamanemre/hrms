package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobPostings;
import kodlamaio.hrms.entities.dtos.JobPostingsDto;

public interface JobPostingService {
	Result add(JobPostings jobPostings);
	JobPostings getById(int id);
	DataResult<List<JobPostingsDto>> getByIdList(int id);
	DataResult<List<JobPostingsDto>> findAllByIsActiveTrueOrderByApplicaitonDeadlineDesc(boolean bool);
	DataResult<List<JobPostingsDto>> findAllByIsActiveTrueOrderByApplicaitonDeadlineAsc(boolean bool);
	DataResult<List<JobPostingsDto>> getByIsActiveAndEmployer(String companyName,boolean bool);
	Result toggleActiveStatus(int id);
	DataResult<List<JobPostingsDto>> getAll();
	DataResult<List<JobPostingsDto>> getAll(int pageNo,int pageSize);
	
	DataResult<List<JobPostingsDto>> getByIdDto(int id);
	
	DataResult<List<JobPostingsDto>> getAllByIsActive(boolean isActive );
	
	DataResult<List<JobPostingsDto>> getAllByIsConfirmation();
	
	Result isConfirmation(int employerId); 
	
	DataResult<List<JobPostingsDto>> getAllByIsConfirmationFalse();
	
	Result uptade(JobPostings jobPostings);
	
	DataResult<List<JobPostingsDto>> filterWorkplace(int id);
	DataResult<List<JobPostingsDto>> filterTypeOfWork(int id);
	
	DataResult<List<JobPostingsDto>> filterCity(int cities);
	
//	DataResult<List<JobPostingsDto>> findByCitiesName(String cities);	
	
	
	
	
}
