package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageNameListService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingLanguageNameListDao;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguageNameList;

@Service
public class ProgrammingLanguageNameListManager implements ProgrammingLanguageNameListService {

	private ProgrammingLanguageNameListDao programmingLanguageNameListDao;
	@Autowired
	
	public ProgrammingLanguageNameListManager(ProgrammingLanguageNameListDao programmingLanguageNameListDao) {
		super();
		this.programmingLanguageNameListDao = programmingLanguageNameListDao;
	}

	@Override
	public Result add(ProgrammingLanguageNameList programmingLanguageNameList) {
		this.programmingLanguageNameListDao.save(programmingLanguageNameList);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<ProgrammingLanguageNameList>> getAll() {
		return new SuccessDataResult<List<ProgrammingLanguageNameList>>(this.programmingLanguageNameListDao.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<List<ProgrammingLanguageNameList>> findById(int id) {
		return new SuccessDataResult<List<ProgrammingLanguageNameList>>(this.programmingLanguageNameListDao.findById(id),"Data Listelendi");
	}

}
