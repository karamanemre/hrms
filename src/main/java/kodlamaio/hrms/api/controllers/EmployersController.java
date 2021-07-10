package kodlamaio.hrms.api.controllers;

import java.io.Console;
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

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.Employers;

@CrossOrigin
@RestController
@RequestMapping("api/employers")
public class EmployersController {
	
	private EmployersService employersService;
	private ValidationException validationException;
	
	@Autowired 
	public EmployersController(EmployersService employersService,ValidationException validationException) {
		this.employersService=employersService;
		this.validationException=validationException;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employers>> getAll(){
		return employersService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Employers employers) {
		return employersService.add(employers);
	}
	
	@PutMapping("/uptadeEmployers")
	public Result uptadeEmployers(@RequestBody Employers uptadeInformation) {
		return employersService.uptadeEmployers(uptadeInformation);
		
	}
	
	@PutMapping("/updateConfirmation")
	public Result updateConfirmation(@RequestParam int userId) {
		return employersService.uptadeConfirmation(userId); 
		
	}
	
	@GetMapping("/getByUserId")
	public DataResult<List<Employers>> getByUserId(int id) {
		return this.employersService.getByUserId(id);
	}
	
	@GetMapping("/getByUptadeConfirmationWait")
	public DataResult<List<Employers>> getByUptadeConfirmationWait() {
		return this.employersService.getByUptadeConfirmationWait();
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	
}
