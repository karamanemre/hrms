package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.axis.types.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.concretes.Technology;

@CrossOrigin
@RestController
@RequestMapping("/api/technology")
public class TechnologyController {
	
	private TechnologyService technologyService;
	private ValidationException validationException;
	
	@Autowired
	public TechnologyController(TechnologyService technologyService,ValidationException validationException) {
		super();
		this.technologyService = technologyService;
		this.validationException=validationException;
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Technology technology) {
		return this.technologyService.add(technology);
	}

	@GetMapping("/getAll")
	public DataResult<List<Technology>> getAll() {
		return this.technologyService.getAll();
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	
	
}
