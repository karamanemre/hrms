package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidatePhotoService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidatePhoto;

@CrossOrigin
@RestController
@RequestMapping("/api/image")
public class CandidatePhotoController {
	
	private CandidatePhotoService candidatePhotoService;
	
	@Autowired
	public CandidatePhotoController(CandidatePhotoService candidatePhotoService) {
		super();
		this.candidatePhotoService = candidatePhotoService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody MultipartFile file, @RequestParam int candidateId) {
		CandidatePhoto candidatePhoto = new CandidatePhoto();
		Candidate candidate = new Candidate();
		candidate.setUserId(candidateId);
		candidatePhoto.setCandidate(candidate);
		return ResponseEntity.ok(this.candidatePhotoService.add(candidatePhoto, file));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.candidatePhotoService.getAll());
	}
	
}
