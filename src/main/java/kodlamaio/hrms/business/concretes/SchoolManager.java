package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.Technology;

@Service
public class SchoolManager implements SchoolService{
	
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao=schoolDao;
	}

	@Override
	public Result add(School school) {
		if (school.getFinishYear().equals("")) {
			school.setFinishYear("Devam ediyor");
		}
		this.schoolDao.save(school);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<List<School>> getAllOrderByFinishYear() {
		return new SuccessDataResult<List<School>>(this.schoolDao.getOrderByFinishYear(),"Data Listelendi");
	}

}
