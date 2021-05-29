package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionsService;
import kodlamaio.hrms.business.abstracts.UsersService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobPositions;
import kodlamaio.hrms.entities.concretes.Users;


@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsControllers {
	
	private JobPositionsService jobPositionsService;
	
	
	@Autowired
	public JobPositionsControllers(JobPositionsService jobPositions) {
		this.jobPositionsService = jobPositions; 
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
	public Result add(@RequestBody JobPositions jobPositions) {
		return this.jobPositionsService.add(jobPositions);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody JobPositions jobPositions) {
		return this.jobPositionsService.delete(jobPositions);
	}
	

}
