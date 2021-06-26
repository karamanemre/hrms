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

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;

@CrossOrigin
@RestController
@RequestMapping("api/programminglanguage")
public class ProgrammingLanguageControllers {
	
	private ProgrammingLanguageService programmingLanguageService;
	private ValidationException validationException;
	
	@Autowired
	public ProgrammingLanguageControllers(ProgrammingLanguageService programmingLanguageService, ValidationException validationException) {
		super();
		this.programmingLanguageService = programmingLanguageService;
		this.validationException=validationException;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody ProgrammingLanguage programmingLanguage) {
		return this.programmingLanguageService.add(programmingLanguage);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ProgrammingLanguage>> getAll() {
		return this.programmingLanguageService.getAll();
	}
	
	@GetMapping("/getById")
	public ProgrammingLanguage getById(int id) {
		return this.programmingLanguageService.getById(id);
	}
	
	@GetMapping("/getByIdDto")
	public ProgrammingLanguageDto getByIdDto(int id) {
		return this.programmingLanguageService.getByIdDto(id);
	}
	
	@PutMapping("uptadeprogramminglanguage")
	public Result uptadeProgrammingLanguage(@RequestParam int id , @RequestBody ProgrammingLanguage programmingLanguage) {
		return this.programmingLanguageService.uptadeProgrammingLanguage(id,programmingLanguage);
	}
	
	@GetMapping("/findByDto")
	public DataResult<List<ProgrammingLanguageDto>> findByDto(int candidateId) {
		return this.programmingLanguageService.findByDto(candidateId);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	
}
