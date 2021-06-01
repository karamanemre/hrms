package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;


public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{
	
	
	//@Query("Select new kodlamaio.hrms.entities.dtos.CandidateCvDto(cv.coverLetter,c.firstNameAndLastName) From CandidateId c Inner Join c.candidateCv cv")
	//List<CandidateCvDto> getAllllll();
	
	@Query("From CandidateCv where isGoToSchool=true order by schoolLeavingDate desc")
	List<CandidateCv> getAllSchoolName();
	
	@Query("From CandidateCv where jobExperience=true order by jobLeavingDate desc")
	List<CandidateCv> getAllJobExperience();
}
