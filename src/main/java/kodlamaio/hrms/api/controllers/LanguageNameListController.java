package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageNameListService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.LanguageNameList;

@CrossOrigin
@RestController
@RequestMapping("/api/languagenamelist")
public class LanguageNameListController {
	
	private LanguageNameListService languageNameListService;
	
	@Autowired
	public LanguageNameListController(LanguageNameListService languageNameListService) {
		super();
		this.languageNameListService = languageNameListService;
	}

	@GetMapping("/getAll")
	public DataResult<List<LanguageNameList>> getAll(){
		return this.languageNameListService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LanguageNameList languageNameList){
		return this.languageNameListService.add(languageNameList);
	}

}
