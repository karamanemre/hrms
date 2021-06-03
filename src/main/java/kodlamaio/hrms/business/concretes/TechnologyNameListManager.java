package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TechnologyNameListService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyNameListDao;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.concretes.TechnologyNameList;


@Service
public class TechnologyNameListManager implements TechnologyNameListService {
	
	private TechnologyNameListDao technologyNameListDao;
	
	@Autowired
	public TechnologyNameListManager(TechnologyNameListDao technologyNameListDao) {
		super();
		this.technologyNameListDao = technologyNameListDao;
	}

	@Override
	public DataResult<List<TechnologyNameList>> getAll() {
		return new SuccessDataResult<List<TechnologyNameList>>(this.technologyNameListDao.findAll(),"Data Listelendi");
	}
	
	
	
}
