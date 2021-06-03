package kodlamaio.hrms.api.controllers;

import java.util.List;

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

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;


@RestController
@RequestMapping("/api/candidatecv")
public class CandidateCvControllers {
	
	private CandidateCvService candidateCvService;
	private ValidationException validationException;
	
	@Autowired
	public CandidateCvControllers(CandidateCvService candidateCvService,ValidationException validationException) {
		this.candidateCvService = candidateCvService;
		this.validationException=validationException;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateCv>> findAll(){
		return this.candidateCvService.findAll();
	}
	
	/*@GetMapping("/getallDtoo")
	public DataResult<List<CandidateCvDto>> getAllDto(int id){
		return this.candidateCvService.getAllDto(id);
	}*/
	
	@GetMapping("/getAllCandidateId")
	public DataResult<List<CandidateCv>> getAllCandidateId(int id){
		return this.candidateCvService.getByCandidateId(id);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CandidateCv candidateCv){
		return this.candidateCvService.add(candidateCv);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	
	
	
	
}
