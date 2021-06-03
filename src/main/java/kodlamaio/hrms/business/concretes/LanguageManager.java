package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import kodlamaio.hrms.business.abstracts.Languageservice;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.dataAccess.abstracts.LanguagesDao;
import kodlamaio.hrms.entities.concretes.Languages;



@Service
public class LanguageManager implements Languageservice{
	
	private LanguagesDao languagesDao;
	
	
	
	@Autowired
	public LanguageManager(LanguagesDao languagesDao,ValidationException validationException) {
		this.languagesDao=languagesDao;
		
	}

	@Override
	public Result add(Languages languages) {
		if (languagesDao.existsByLanguageName(languages.getLanguageName()) && languagesDao.existsByCvId(languages.getCvId())) {
			return new ErrorResult("Daha önce "+languages.getLanguageName()+" eklendi lütfen farklı bir dil deneyin");
		}
		this.languagesDao.save(languages);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<Languages>> getAll() {
		return new SuccessDataResult<List<Languages>>(this.languagesDao.findAll(),"Data Listelendi");
	}

	
	

	
}
