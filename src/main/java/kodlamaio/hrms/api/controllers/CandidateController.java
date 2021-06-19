package kodlamaio.hrms.api.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@CrossOrigin
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	
	private CandidateService candidateService;
	private ValidationException validationException;
	
	
	@Autowired
	public CandidateController(CandidateService candidateService,ValidationException validationException) {
		this.candidateService=candidateService;
		this.validationException=validationException;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateService.getAll()); 
	}
	

	@GetMapping("/findById")
	public ResponseEntity<?> findById(int id){
		return ResponseEntity.ok(this.candidateService.findById(id)); 
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.add(candidate));
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
	
	
	
	
}
