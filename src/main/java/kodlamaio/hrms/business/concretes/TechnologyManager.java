package kodlamaio.hrms.business.concretes;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	
	private TechnologyDao technologyDao;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		this.technologyDao=technologyDao;
	}

	@Override
	public Result add(Technology technology) {
		if (technologyDao.existsByTechnologyIdAndCvId(technology.getTechnologyId(), technology.getCvId())) {
			return new ErrorResult("Aynı Teknolojiyi Tekrar Ekleyemezsiniz");
			
		}
		this.technologyDao.save(technology);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll());
	}
	
	

	
}
