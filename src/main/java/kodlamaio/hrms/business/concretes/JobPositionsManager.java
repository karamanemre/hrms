package kodlamaio.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionsService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionsDao;
import kodlamaio.hrms.entities.concretes.JobPositions;


@Service
public class JobPositionsManager implements JobPositionsService{
	
	private JobPositionsDao jobPositionsDao;
	
	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		this.jobPositionsDao = jobPositionsDao;
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

	@Override
	public DataResult<JobPositions> findByPositionName(String name) {
		 return new SuccessDataResult<>(this.jobPositionsDao.findByPositionName(name));
	}


	
}
