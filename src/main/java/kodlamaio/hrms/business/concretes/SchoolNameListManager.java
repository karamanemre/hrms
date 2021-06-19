package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolNameListService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolNameListDao;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.SchoolNameList;

@Service
public class SchoolNameListManager implements SchoolNameListService {
	
	private SchoolNameListDao schoolNameListDao;
	
	@Autowired
	public SchoolNameListManager(SchoolNameListDao schoolNameListDao) {
		super();
		this.schoolNameListDao = schoolNameListDao;
	}

	@Override
	public Result add(SchoolNameList school) {
		if (this.schoolNameListDao.existsBySchoolName(school.getSchoolName())) {
			return new ErrorResult("Daha Önce Eklendi");
		}
		this.schoolNameListDao.save(school);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<SchoolNameList>> getAll() {
		return new SuccessDataResult<List<SchoolNameList>>(this.schoolNameListDao.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<List<SchoolNameList>> findById(int id) {
		return new SuccessDataResult<List<SchoolNameList>>(this.schoolNameListDao.findById(id),"Data Listelendi");
	}

}
