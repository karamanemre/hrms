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

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.Technology;

@CrossOrigin
@RestController
@RequestMapping("/api/school")
public class SchoolController {
	
	
	private SchoolService schoolService;
	private ValidationException validationException;
	
	@Autowired
	public SchoolController(SchoolService schoolService,ValidationException validationException) {
		super();
		this.schoolService = schoolService;
		this.validationException=validationException;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}

	@GetMapping("/getAll")
	public DataResult<List<School>> getAll() {
		return this.schoolService.getAll();
	}
	
	@GetMapping("/finById")
	public DataResult<List<School>> finById(int candidateNumber) {
		return this.schoolService.findById(candidateNumber);
	}
	
	@GetMapping("/getAllOrderByFinishYear")
	public DataResult<List<School>> getAllOrderByFinishYear() {
		return this.schoolService.getAllOrderByFinishYear();
	}
	
	@GetMapping("/getById")
	public School getById(int id) {
		return this.schoolService.getById(id);
	}
	
	@PutMapping("uptadeschool")
	public Result uptadeSchool(@RequestParam int id , @RequestBody School school) {
		return this.schoolService.uptadeScholl(id,school);
	}
	
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
}
