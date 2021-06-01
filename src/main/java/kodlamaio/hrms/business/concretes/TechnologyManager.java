package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.DataResult;
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
		this.technologyDao.save(technology);
		return new SuccessResult("Başarıyla eklendi");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(),"Data Listelendi");
	}
}
