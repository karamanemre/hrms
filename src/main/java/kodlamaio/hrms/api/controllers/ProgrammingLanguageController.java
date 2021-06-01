package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguages;
import kodlamaio.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/programminglanguage")
public class ProgrammingLanguageController {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody ProgrammingLanguages programmingLanguages) {
		return this.programmingLanguageService.add(programmingLanguages);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ProgrammingLanguages>> getAll(){
		return this.programmingLanguageService.getAll();
	}
	
	

}
