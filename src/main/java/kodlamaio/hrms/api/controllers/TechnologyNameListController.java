package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TechnologyNameListService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.TechnologyNameList;

@RestController
@RequestMapping("api/technologyNameList")
public class TechnologyNameListController {
	
	private TechnologyNameListService technologyNameListService;
	private ValidationException validationException;
	
	@Autowired
	public TechnologyNameListController(TechnologyNameListService technologyNameListService, ValidationException validationException) {
		super();
		this.technologyNameListService = technologyNameListService;
		this.validationException=validationException;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<TechnologyNameList>> getAll() {
		return this.technologyNameListService.getAll();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	
}
