package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.core.validationException.ValidationException;
import kodlamaio.hrms.entities.concretes.SocialMedia;

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
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody SocialMedia socialMedia) {
		return this.socialMediaService.add(socialMedia);
	}
	
	@GetMapping("getAll")
	public Result getAll() {
		return this.socialMediaService.getAll();
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> validation(MethodArgumentNotValidException exceptions) {
		return validationException.handleValidationException(exceptions);
	}
}
