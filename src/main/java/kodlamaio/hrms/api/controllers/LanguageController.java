package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.Languageservice;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
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
	
	@PostMapping("add")
	public Result add(@RequestBody Languages language) {
		return this.languageservice.add(language);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Languages>> getAll(){
		return this.languageservice.getAll();
	}
	
	
}
