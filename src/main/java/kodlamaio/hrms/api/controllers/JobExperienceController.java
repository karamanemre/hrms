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

import kodlamaio.hrms.business.abstracts.JobExperienceService;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.JobExperience;

@CrossOrigin
@RestController
@RequestMapping("/api/jobexperience")
public class JobExperienceController {
	
	private JobExperienceService jobExperienceService;
	private ValidationException validationException;
	
	@Autowired
	public JobExperienceController(JobExperienceService jobExperienceService,ValidationException validationException) {
		super();
		this.jobExperienceService = jobExperienceService;
		this.validationException=validationException;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll() {
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/findByCandidateNumber")
	public DataResult<List<JobExperience>> findByCandidateNumber(int id) {
		return this.jobExperienceService.findByCandidateNumber(id);
	}
	
	@GetMapping("/getAllOrderByFinishYearDesc")
	public DataResult<List<JobExperience>> getAllOrderByFinishYearDesc() {
		return this.jobExperienceService.getAllOrderByFinishYearDesc();
	}
	
	@GetMapping("getById")
	public JobExperience getById(int id){
		return this.jobExperienceService.getById(id);
	}
	
	@PutMapping("uptadejobExperience")
	public Result uptadeCoverLetter(@RequestParam int id , @RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.uptadeJobExperience(id,jobExperience);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
}
