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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.JobPostings;
import kodlamaio.hrms.entities.dtos.JobPostingsDto;

@CrossOrigin
@RequestMapping("/api/jobposting")
@RestController
public class JobPostingController {
	
	JobPostingService jobPostingService;
	private ValidationException validationException;
	
	@Autowired
	public JobPostingController(JobPostingService jobPostingService,ValidationException validationException) {
		this.jobPostingService=jobPostingService;
		this.validationException=validationException;
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobPostings jobPostings){
		return jobPostingService.add(jobPostings);
	}
	
	
	@GetMapping("/getAllByIsActiveTrueOrderByApplicaitonDeadlineDesc")
    public DataResult<List<JobPostingsDto>> findAllByIsActiveTrueOrderByApplicaitonDeadlineDesc(boolean bool) {
        return this.jobPostingService.findAllByIsActiveTrueOrderByApplicaitonDeadlineDesc(bool);
    }
	

	@GetMapping("/getAllByIsActiveTrueOrderByApplicaitonDeadlineAsc")
    public DataResult<List<JobPostingsDto>> findAllByIsActiveTrueOrderByApplicaitonDeadlineAsc(boolean bool) {
        return this.jobPostingService.findAllByIsActiveTrueOrderByApplicaitonDeadlineAsc(bool);
    }
	
	@GetMapping("/getByIsActiveAndEmployer")
	public DataResult<List<JobPostingsDto>> getByIsActiveAndEmployer(String companyName,boolean bool) {
        return this.jobPostingService.getByIsActiveAndEmployer(companyName,bool);
    }
	
	
	@GetMapping("/toggleActiveStatus")
	public Result toggleActiveStatus(int id) {
       return this.jobPostingService.toggleActiveStatus(id);
    }
	
	@GetMapping("/getAll")
	public Result getJobPostingsDtoDetails() {
	       return this.jobPostingService.getAll();
	    }
	
	@GetMapping("/getAllByIsActive")
	public Result getAllByIsActiveOrderByCreatedDate(boolean isActive ) {
	       return this.jobPostingService.getAllByIsActive(isActive);
	    }
	
	
	
	
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	
	
	
	
	
	
}
