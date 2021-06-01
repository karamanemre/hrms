package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	boolean existsByNationalId(String national_id);
	
	
	
}
