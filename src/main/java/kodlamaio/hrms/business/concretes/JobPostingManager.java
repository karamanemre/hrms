package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.DataResult;
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
	public Result add(JobPostings jobPostings) {
		this.jobPostingDao.save(jobPostings);
		return new SuccessResult("Data Eklendi");
	}

	@Override
	public DataResult<List<JobPostings>> findAllByActiveTrue() {
		 return new SuccessDataResult<List<JobPostings>>(this.jobPostingDao.findAllByIsActiveTrue(),"Aktif ilanlar listelendi");
	}


	@Override
	public DataResult<List<JobPostings>> findAllByIsActiveTrueOrderByApplicaitonDeadline() {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingDao.findAllByIsActiveTrueOrderByApplicaitonDeadline(),"Data Listelendi");
	}

	/*@Override
	public Result setIsActiveValue(int id, boolean value) {
		JobPostings jobPostings = this.jobPostingDao.findByEmployerAndIsActiveTrue(id);
		jobPostings.setActive(value);
		this.jobPostingDao.save(jobPostings);
		return new SuccessResult("Aktiflik "+value+" olarak değiştirildi");
	}

	@Override
	public DataResult<List<JobPostings>> getByIsActiveTrueAndEmployer(int id) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingDao.getByIsActiveTrueAndEmployer(id));*/
	}



	


	

}
