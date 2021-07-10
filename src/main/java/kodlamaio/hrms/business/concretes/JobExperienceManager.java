package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {
	
	private JobExperienceDao jobExperienceDao;
	
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	

	@Override
	public Result add(JobExperience jobExperience) {
		if (jobExperience.getFinishYear().equals("")) {
			jobExperience.setFinishYear("Devam ediyor");
		}
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"Data Listelendi");
	}



	@Override
	public DataResult<List<JobExperience>> getAllOrderByFinishYearDesc() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getOrderByFinishYearDesc(),"Data Listelendi");
		
	}



	@Override
	public DataResult<List<JobExperience>> findByCandidateNumber(int id) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findByCandidateNumber(id),"Data Listelendi");
	}



	@Override
	public JobExperience getById(int id) {
		return this.jobExperienceDao.getById(id);
	}



	@Override
	public Result uptadeJobExperience(int id, JobExperience jobExperience) {
		JobExperience jobExperienceId = jobExperienceDao.getById(id);
		if (jobExperience.getCompanyName().equals("")) {
			jobExperience.setCompanyName(jobExperienceId.getCompanyName());
		}
		if (jobExperience.getPositionName().equals("")) {
			jobExperience.setPositionName(jobExperienceId.getPositionName());
		}
		if (jobExperience.getStartingYear()==null) {
			jobExperience.setStartingYear(jobExperienceId.getStartingYear());
		}
		if (jobExperience.getFinishYear().equals("")) {
			jobExperience.setFinishYear(jobExperienceId.getFinishYear());
		}
		jobExperienceId=jobExperience;
		jobExperienceId.setId(id);
		this.jobExperienceDao.save(jobExperienceId);
		return new SuccessResult("Güncellendi");
	}

}
