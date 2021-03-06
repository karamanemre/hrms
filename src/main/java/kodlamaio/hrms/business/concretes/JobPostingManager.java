package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;

import kodlamaio.hrms.dataAccess.abstracts.JobPostingsDao;
import kodlamaio.hrms.entities.concretes.Employers;

import kodlamaio.hrms.entities.concretes.JobPostings;
import kodlamaio.hrms.entities.concretes.Users;
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
	     return new SuccessResult("Ba??ar??l??!");
	     
	}

	@Override
	public DataResult<List<JobPostingsDto>> getAll() {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getAll(),"???? ??lanlar?? Listelendi");
	}
	
	@Override
	public DataResult<List<JobPostingsDto>> getByIdDto(int id) {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getByIdDto(id),"???? ??lanlar?? Listelendi");
	}
	
	
	@Override
	public DataResult<List<JobPostingsDto>> getAll(int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getAll(pageable));
	}
	

	@Override
	public DataResult<List<JobPostingsDto>> getAllByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getAllByIsActive(isActive));
	}


	@Override
	public DataResult<List<JobPostingsDto>> getAllByIsConfirmation() {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getAllByIsConfirmation());
	}
	
	
	@Override
	public JobPostings getById(int id) {
		return this.jobPostingDao.getById(id);
	}

	@Override
	public Result isConfirmation(int id) {
		JobPostings jobPostingsId = jobPostingDao.getById(id);
		if (!jobPostingsId.isConfirmation()) {
			jobPostingsId.setConfirmation(true);
		}else {
			jobPostingsId.setConfirmation(true);
		}
		jobPostingDao.save(jobPostingsId);
		return new SuccessResult("Ba??ar??yla Onayland??");	
	}
	
	@Override
	public Result uptade(JobPostings jobPostings) {
		JobPostings jobPostingsId = jobPostingDao.getById(jobPostings.getId());
		if (jobPostings.getDescription().equals("")) {
			jobPostings.setDescription(jobPostingsId.getDescription());
		}
		if (jobPostings.getNumberOfOpenPosition().equals("")) {
			jobPostings.setNumberOfOpenPosition(jobPostingsId.getNumberOfOpenPosition());
		}
		if (jobPostings.getApplicaitonDeadline().equals("")) {
			jobPostings.setApplicaitonDeadline(jobPostingsId.getApplicaitonDeadline());
		}
		
//		if (jobPostings.getMinSalary()<5) {
//		jobPostings.setMinSalary(jobPostingsId.getMinSalary());
//		}
//		if (jobPostings.getMaxSalary() == (Integer)null) {
//			jobPostings.setMaxSalary(jobPostingsId.getMaxSalary());
//		}
//		if (jobPostings.getWorkplace() == (Integer)null) {
//			jobPostings.setWorkplace(jobPostingsId.getWorkplace());
//			}
//		if (jobPostings.getTypeOfWork() == (Integer)null) {
//			jobPostings.setTypeOfWork(jobPostingsId.getTypeOfWork());
//			}
//		if (jobPostings.getEmployerId() == (Integer)null) {
//			jobPostings.setEmployerId(jobPostingsId.getEmployerId());
//		}
//		if (jobPostings.getCityId() == (Integer)null) {
//			jobPostings.setCityId(jobPostingsId.getCityId());
//		}
//		if (jobPostings.getJobPositionId() == (Integer)null) {
//			jobPostings.setJobPositionId(jobPostingsId.getJobPositionId());
//		}
			jobPostingsId=jobPostings;
			jobPostingDao.save(jobPostingsId);
			return new SuccessResult("G??ncellendi");
		}
	

	@Override
	public DataResult<List<JobPostingsDto>> getAllByIsConfirmationFalse() {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getAllByIsConfirmationFalse(),"Data Listelendi");
	}


	@Override
	public DataResult<List<JobPostingsDto>> getByIdList(int id) {
		return new SuccessDataResult<List<JobPostingsDto>>(this.jobPostingDao.getByIdList(id),"Data Listelendi");
	}


	@Override
	public DataResult<List<JobPostingsDto>> filterWorkplace(int id) {
		return new SuccessDataResult<List<JobPostingsDto>>(jobPostingDao.filterWorkplace(id),"Data Listelendi");
	}


	@Override
	public DataResult<List<JobPostingsDto>> filterTypeOfWork(int id) {
		return new SuccessDataResult<List<JobPostingsDto>>(jobPostingDao.filterTypeOfWork(id),"Data Listelendi");
	}
 

	@Override
	public DataResult<List<JobPostingsDto>> filterCityPositionTypeWorkWorkPlace(List<Integer> cities,List<Integer> positions,List<Integer> typeWork,List<Integer> workPlace) {
		return new SuccessDataResult<List<JobPostingsDto>>(jobPostingDao.filterCityPositionTypeWorkWorkPlace(cities,positions,typeWork,workPlace),"Data Listelendi");
	}





	

	

}
