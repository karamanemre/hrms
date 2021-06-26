package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends  JpaRepository<CoverLetter, Integer>{
	
	
	CoverLetter getById(int id);

}
