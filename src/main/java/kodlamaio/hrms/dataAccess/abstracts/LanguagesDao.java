package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.dtos.LanguageDto;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

public interface LanguagesDao extends JpaRepository<Languages, Integer>{
	
	boolean existsByLanguageIdAndCandidateNumber(int languageId,int candidateId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.LanguageDto(l.candidateNumber,lnl.languageName)"
	 		+ " From Languages l Inner Join "
	 		+ "l.languageNameList lnl where l.candidateNumber=:id")
	List<LanguageDto> findByCandidateNumberDto(int id); 
	
}
