package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.VerifyCode;

@CrossOrigin
@RestController
@RequestMapping("/valid")
public class VerifyCodeController {
	
	VerifyCodeService verifyCodeService;
	

	public VerifyCodeController(VerifyCodeService verifyCodeService) {
		super();
		this.verifyCodeService = verifyCodeService;
	}


	@PutMapping("/{verifyCode}")
	public Result update(@PathVariable("verifyCode") String verifyCode,	@RequestBody VerifyCode verifyingCode) {
		return verifyCodeService.verifyUser(verifyCode);
	}
}
