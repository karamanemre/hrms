package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Photo;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	boolean existsByNationalId(String national_id);
	Photo findByUserId(int id);
	
	@Query("From Candidate where userId=:id")
	List<Candidate> findById(int id);

	
	
	
}
