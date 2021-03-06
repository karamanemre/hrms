package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.Languageservice;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.dtos.LanguageDto;

@CrossOrigin
@RestController
@RequestMapping("/api/language")
public class LanguageController {
	
	private Languageservice languageservice;
	private ValidationException validationException;
	
	@Autowired
	public LanguageController(Languageservice languageservice,ValidationException validationException) {
		super();
		this.languageservice = languageservice;
		this.validationException=validationException;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Languages languages) {
		return this.languageservice.add(languages);
	}

	@GetMapping("/getAll")
	public DataResult<List<Languages>> getAll() {
		return this.languageservice.getAll();
	}
	
	@GetMapping("/findByCandidateNumberDto")
	public DataResult<List<LanguageDto>> findByCandidateNumberDto(int candidateNumber) {
		return this.languageservice.findByCandidateNumberDto(candidateNumber);
	}
	
	@GetMapping("/getByIdDto")
	public LanguageDto getById(int id) {
		return this.languageservice.getByIdDto(id);
	}
	
	@PutMapping("uptadelanguage")
	public Result jobExperience(@RequestParam int id , @RequestBody Languages languages) {
		return this.languageservice.uptadeLanguage(id,languages);
	}

	
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
}
