package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingsDao;
import kodlamaio.hrms.entities.concretes.JobPostings;
import kodlamaio.hrms.entities.dtos.JobPostingsDto;

@Service
public class JobPostingManager implements JobPostingService{
	
	JobPostingsDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingsDao jobPostingsDao) {
		this.jobPostingDao=jobPostingsDao;
	}


	@Override
	public Result add(JobPostings jobPostings) {
		
		this.jobPostingDao.save(jobPostings);
		return new SuccessResult("Data Eklendi");
	}


	@Override
	public DataResult<List<JobPostingsDto>> findAllByIsActiveTrueOrderByApplicaitonDeadlineDesc(boolean bool) {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.findAllByIsActiveTrueOrderByApplicaitonDeadlineDesc(bool),"Data Listelendi");
	}
	
	@Override
	public DataResult<List<JobPostingsDto>> findAllByIsActiveTrueOrderByApplicaitonDeadlineAsc(boolean bool) {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.findAllByIsActiveTrueOrderByApplicaitonDeadlineAsc(bool),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostingsDto>> getByIsActiveAndEmployer(String companyName,boolean bool) {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getByIsActiveAndEmployer(companyName,bool),"Data Listelendi");
	}

	@Override
	public Result toggleActiveStatus(int id) {
		 JobPostings jobPostingToChange = this.jobPostingDao.findById(id).get();
	     jobPostingToChange.setActive(!jobPostingToChange.isActive());
	     this.jobPostingDao.save(jobPostingToChange);
	     return new SuccessResult("Başarılı!");
	     
	}

	@Override
	public DataResult<List<JobPostingsDto>> getAll() {
		
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getAll(),"İş İlanları Listelendi");
	}

	@Override
	public DataResult<List<JobPostingsDto>> getAllByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getAllByIsActive(isActive));
	}

	






	

	

}
