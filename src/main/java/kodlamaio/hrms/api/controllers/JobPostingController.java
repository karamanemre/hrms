package kodlamaio.hrms.api.controllers;

import java.util.List;

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
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPostings jobPostings){
		return jobPostingService.add(jobPostings);
	}
	
	
	@GetMapping("/getAllByActiveTrue")
	public DataResult<List<JobPostings>> getAllByActiveTrue(){
		return this.jobPostingService.findAllByActiveTrue();
	}
	
	@GetMapping("/getAllByIsActiveTrueOrderByApplicaitonDeadline")
    public DataResult<List<JobPostings>> findAllByIsActiveTrueOrderByApplicaitonDeadline() {
        return this.jobPostingService.findAllByIsActiveTrueOrderByApplicaitonDeadline();
    }
	
	/*@PostMapping("/setValue")
    public Result setValue(@RequestParam int id, boolean value) {
        return this.jobPostingService.setIsActiveValue(id, value);
    }
	
	@GetMapping("/findAllByIsActiveTrueAndEmployerIdddd")
    public DataResult<List<JobPostings>> findAllByIsActiveTrueAndEmployerId(@RequestParam int id) {
        return this.jobPostingService.getByIsActiveTrueAndEmployer(id);*/
    }
	
	
	
	
}
