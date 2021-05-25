package kodlamaio.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionsService;
import kodlamaio.hrms.core.concretes.DataResult;
import kodlamaio.hrms.core.concretes.ErrorResult;
import kodlamaio.hrms.core.concretes.Result;
import kodlamaio.hrms.core.concretes.SuccessDataResult;
import kodlamaio.hrms.core.concretes.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionsDao;
import kodlamaio.hrms.entities.concretes.JobPositions;


@Service
public class JobPositionsManager implements JobPositionsService{
	
	private JobPositionsDao jobPositionsDao;
	
	@Autowired
	public JobPositionsManager(JobPositionsDao userDao) {
		this.jobPositionsDao = userDao;
	}

	@Override
	public DataResult<List<JobPositions>> getAll() {
		return new SuccessDataResult<List<JobPositions>>(this.jobPositionsDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobPositions jobPositions) {
		
		if (jobPositionsDao.existsByPositionName(jobPositions.getPositionName())) {
			return new ErrorResult("Bu iş pozisyonu zaten mevcut");
		}
		
		this.jobPositionsDao.save(jobPositions);
		return new SuccessResult("Başarıyla Eklendi");
		
	}

	@Override
	public Result delete(JobPositions jobPositions) {
		for(JobPositions iterator:jobPositionsDao.findAll()) {
			if (iterator.getPositionName().equals(jobPositions.getPositionName())) {
				this.jobPositionsDao.deleteById(iterator.getId());
				return new SuccessResult(jobPositions.getPositionName()+" Adlı Pozisyon Bilgisi silindi");
			}
		}
		return new ErrorResult(jobPositions.getPositionName()+" Adlı pozisyon bilgisi zaten yok");
		
	}

	
}
