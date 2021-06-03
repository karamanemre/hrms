package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolSectionService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.SchoolSection;

@RestController
@RequestMapping("api/schoolsection")
public class SchoolSectionController {
	
	private SchoolSectionService schoolSectionService;
	private ValidationException validationException;
	
	@Autowired
	public SchoolSectionController(SchoolSectionService schoolSectionService,ValidationException validationException) {
		super();
		this.schoolSectionService = schoolSectionService;
		this.validationException = validationException;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody SchoolSection schoolSection) {
		return this.schoolSectionService.add(schoolSection);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SchoolSection>> getAll() {
		return this.schoolSectionService.getAll();
	}
	
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}

	
}
