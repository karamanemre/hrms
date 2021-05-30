package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobPostings;

@RequestMapping("/api/jobposting")
@RestController
public class JobPostingController {
	
	JobPostingService jobPostingService;
	
	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		this.jobPostingService=jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPostings>> getAll(){
		return jobPostingService.getAll();
	}
	
	@GetMapping("/getAllSortedDesc")
	public DataResult<List<JobPostings>> getAllSortedDesc() {
		return this.jobPostingService.getAllSortedDesc();
	}
	
	@GetMapping("/getAllSortedAcs")
	public DataResult<List<JobPostings>> getAllSortedAcs() {
		return this.jobPostingService.getAllSortedDesc();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobPostings jobPostings){
		return jobPostingService.add(jobPostings);
	}
	
	
	@GetMapping("/getAllByActive")
	public DataResult<List<JobPostings>> getAllByActiveTrue(boolean jobPosting){
		return this.jobPostingService.findAllByActive(jobPosting);
	}
	
	@GetMapping("/getAllByIsActiveTrueOrderByApplicaitonDeadline")
    public DataResult<List<JobPostings>> findAllByIsActiveTrueOrderByApplicaitonDeadline() {
        return this.jobPostingService.findAllByIsActiveTrueOrderByApplicaitonDeadline();
    }
	
	
	
	
	
	
	
}
