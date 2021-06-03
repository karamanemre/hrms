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

import kodlamaio.hrms.business.abstracts.SchoolNameListService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.SchoolNameList;


@RestController
@RequestMapping("/api/schoolNameList")
public class SchoolNameListController {
	
	private SchoolNameListService schoolNameListService;
	private ValidationException validationException;
	
	@Autowired
	public SchoolNameListController(SchoolNameListService schoolNameListService,ValidationException validationException) {
		super();
		this.schoolNameListService = schoolNameListService;
		this.validationException=validationException;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody SchoolNameList schoolNameList) {
		return this.schoolNameListService.add(schoolNameList);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SchoolNameList>> getAll() {
		return this.schoolNameListService.getAll();
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	
	
	
}
