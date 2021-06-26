package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

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

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.dtos.LanguageDto;

@CrossOrigin
@RestController
@RequestMapping("api/socialMedia")
public class SocialMediaControllers {
	
	private SocialMediaService socialMediaService;
	private ValidationException validationException;

	public SocialMediaControllers(SocialMediaService socialMediaService,ValidationException validationException) {
		super();
		this.socialMediaService = socialMediaService;
		this.validationException=validationException;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody SocialMedia socialMedia) {
		return this.socialMediaService.add(socialMedia);
	}
	
	@GetMapping("/getAll")
	public Result getAll() {
		return this.socialMediaService.getAll();
	}
	
	@GetMapping("/findByCandidateNumber")
	public Result findByCandidateNumber(int id) {
		return this.socialMediaService.findByCandidateNumber(id);
	}
	
	@GetMapping("/getById")
	public SocialMedia getById(int id) {
		return this.socialMediaService.getById(id);
	}
	
	@PutMapping("uptadesocialmedia")
	public Result uptadeSocialMedia(@RequestParam int id , @RequestBody SocialMedia socialMedia) {
		return this.socialMediaService.uptadeSocialMedia(id,socialMedia);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
}
