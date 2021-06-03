package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;


public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{
	
	
	/*@Query("Select new kodlamaio.hrms.entities.dtos.CandidateCvDto(s.schoolName,l.languageName,l.languageLevel,je.companyName,"
			+ "je.startingYear,je.finishYear,cv.githubLink,cv.linkedinLink,cv.description) " 
			+ "From CandidateCv cv  Inner Join cv.schools s  Inner Join cv.languages l Inner Join cv.jobExperiences je"
			+ " where cv.id=:id")
	List<CandidateCvDto> getAllDto(int id);*/
	
	@Query("From CandidateCv where id=:id")
	List<CandidateCv> getByCandidateId(int id);
	
	
	
}
