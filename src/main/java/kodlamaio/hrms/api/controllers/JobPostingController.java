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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import kodlamaio.hrms.entities.concretes.VerifyCode;
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
	
	@GetMapping("/getAllPageSize")
	public Result getJobPostingsDtoDetails(int pageNo,int pageSize) {
	       return this.jobPostingService.getAll(pageNo,pageSize);
	    }
	
	@GetMapping("/getById")
	public JobPostings getById(int id) {
	       return this.jobPostingService.getById(id);
	    }
	
	@GetMapping("/getByIdDto")
	public DataResult<List<JobPostingsDto>> getByIdDto(int id) {
	       return this.jobPostingService.getByIdDto(id);
	    }
	
	@GetMapping("/getByIdList")
	public DataResult<List<JobPostingsDto>> getByIdList(int id) {
	       return this.jobPostingService.getByIdList(id);
	    }
	
	@GetMapping("/getAllByIsActive")
	public Result getAllByIsActiveOrderByCreatedDate(boolean isActive ) {
	       return this.jobPostingService.getAllByIsActive(isActive);
	    }
	
	@GetMapping("/getAllByIsConfirmation")
	public DataResult<List<JobPostingsDto>> getAllByIsConfirmation() {
		return this.jobPostingService.getAllByIsConfirmation();
	}
	
	@GetMapping("/getAllByIsConfirmationFalse")
	public DataResult<List<JobPostingsDto>> getAllByIsConfirmationFalse() {
		return this.jobPostingService.getAllByIsConfirmationFalse();
	}
	
	@GetMapping("/filterWorkplace")
	public DataResult<List<JobPostingsDto>> filterWorkplace(int id) {
		return this.jobPostingService.filterWorkplace(id);
	}
	
	@GetMapping("/filterTypeOfWork")
	public DataResult<List<JobPostingsDto>> filterTypeOfWork(int id) {
		return this.jobPostingService.filterTypeOfWork(id);
	}
	
	@GetMapping("/filterCityPositionTypeWorkWorkPlace")
	public DataResult<List<JobPostingsDto>> filterCityPositionTypeWorkWorkPlace(@RequestParam List<Integer> cities,@RequestParam List<Integer> positions,@RequestParam List<Integer> typeWork,@RequestParam List<Integer> workPlace) {
		return this.jobPostingService.filterCityPositionTypeWorkWorkPlace(cities,positions,typeWork,workPlace);
	}
	
	
	
 

	@PutMapping("isConfirmation")
	public Result update(@RequestParam int id) {
		return this.jobPostingService.isConfirmation( id);
	}
	
	@PutMapping("uptadeJobPosting")
	public Result update(@RequestBody JobPostings jobPostings) {
		return this.jobPostingService.uptade( jobPostings);
	}
	
	
	
	
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	
	
	
	
	
	
}
