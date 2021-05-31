package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.annotation.Resource;
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

import kodlamaio.hrms.business.abstracts.JobPositionsService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.JobPositions;


@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsControllers {
	
	private JobPositionsService jobPositionsService;
	private ValidationException validationException;
	
	
	@Autowired
	public JobPositionsControllers(JobPositionsService jobPositions,ValidationException validationException) {
		this.jobPositionsService = jobPositions; 
		this.validationException=validationException;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<JobPositions>> getAll(){
		return this.jobPositionsService.getAll();
	}
	
	@GetMapping("/getByName")
	public DataResult<JobPositions> getByName(@RequestBody String positionName){
		return this.jobPositionsService.findByPositionName(positionName);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobPositions jobPositions) {
		return this.jobPositionsService.add(jobPositions);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody JobPositions jobPositions) {
		return this.jobPositionsService.delete(jobPositions);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	

}
