package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguages;


@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	private ProgrammingLanguageDao programmingLanguageDao;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		this.programmingLanguageDao=programmingLanguageDao;
	}

	@Override
	public Result add(ProgrammingLanguages programmingLanguages) {
		this.programmingLanguageDao.save(programmingLanguages);
		return new SuccessResult("Başarıyla eklendi");
	}

	@Override
	public DataResult<List<ProgrammingLanguages>> getAll() {
		return new SuccessDataResult<List<ProgrammingLanguages>>(this.programmingLanguageDao.findAll(),"Data Listelendi");
	}

}
