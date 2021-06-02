package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.Languageservice;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.entities.concretes.Languages;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
	
	private Languageservice languageservice;
	
	@Autowired
	public LanguageController(Languageservice languageservice) {
		super();
		this.languageservice = languageservice;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Languages languages) {
		return this.languageservice.add(languages);
	}

	@GetMapping("/getAll")
	public DataResult<List<Languages>> getAll() {
		return this.languageservice.getAll();
	}
	

	
}
