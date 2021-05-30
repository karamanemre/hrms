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

@Service
public class JobPostingManager implements JobPostingService{
	
	JobPostingsDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingsDao jobPostingsDao) {
		this.jobPostingDao=jobPostingsDao;
	}

	@Override
	public DataResult<List<JobPostings>> getAll() {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingDao.findAll());
	}
	
	@Override
	public DataResult<List<JobPostings>> getAllSortedDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC,"applicaitonDeadline");//tarihe göre azalan
		return new SuccessDataResult<List<JobPostings>>
		(this.jobPostingDao.findAll(sort));
	}
	
	@Override
	public DataResult<List<JobPostings>> getAllSortedAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC,"applicaitonDeadline");//tarihe göre artan
		return new SuccessDataResult<List<JobPostings>>
		(this.jobPostingDao.findAll(sort));
	}
		


	@Override
	public Result add(JobPostings jobPostings) {
		
		this.jobPostingDao.save(jobPostings);
		return new SuccessResult("Data Eklendi");
	}

	@Override
	public DataResult<List<JobPostings>> findAllByActive(boolean jobPosting) {
		 return new SuccessDataResult<List<JobPostings>>(this.jobPostingDao.findAllByIsActive(jobPosting),"Aktif ilanlar listelendi");
	}


	@Override
	public DataResult<List<JobPostings>> findAllByIsActiveTrueOrderByApplicaitonDeadline() {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingDao.findAllByIsActiveTrueOrderByApplicaitonDeadline(),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostings>> getByIsActiveAndEmployer(boolean bool, int id) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingDao.getByIsActiveAndEmployer(bool, id),"Data Listelendi");
	}






	

	

}
