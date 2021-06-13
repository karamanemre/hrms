package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidatePhoto;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	boolean existsByNationalId(String national_id);
	CandidatePhoto findByUserId(int id);
	
//	@Query("Select new kodlamaio.hrms.entities.dtos.CandidateCvDto(c.firstName,c.lastName,s.schoolNameList.schoolName,"
//			+ "s.schoollSection.schoolSection,l.languageNameList.languageName,l.languageLevel,je.companyName,je.finishYear,"
//			+ "sm.linkedin,sm.github,cl.coverLetter) From Candidate c Inner Join c.schools s Inner Join c.languages l Inner Join"
//			+ " c.jobExperiences je Inner Join c.socialMedia sm Inner Join c.coverLetter cl")
//	List<CandidateCvDto> getAllCv();
	
	
	
}
