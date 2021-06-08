package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageNameListService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguagesNameListDao;
import kodlamaio.hrms.entities.concretes.LanguageNameList;

@Service
public class LanguageNameListManager implements LanguageNameListService{
	
	private LanguagesNameListDao languagesNameListDao;
	
	@Autowired
	public LanguageNameListManager(LanguagesNameListDao languagesNameListDao) {
		super();
		this.languagesNameListDao = languagesNameListDao;
	}

	@Override
	public DataResult<List<LanguageNameList>> getAll() {
		
		return new SuccessDataResult<List<LanguageNameList>>(this.languagesNameListDao.findAll());
	}

	@Override
	public Result add(LanguageNameList languageNameList) {
		this.languagesNameListDao.save(languageNameList);
		return new SuccessResult("Eklendi");
	}

}
