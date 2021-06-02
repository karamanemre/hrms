package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/school")
public class SchoolController {
	
	
	private SchoolService schoolService;
	
	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody School school) {
		return this.schoolService.add(school);
	}

	@GetMapping("/getAll")
	public DataResult<List<School>> getAll() {
		return this.schoolService.getAll();
	}
	
}
