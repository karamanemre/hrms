package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;

public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer>{
	
	 @Query("Select new kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto(pl.candidateNumber,plnl.programmingLanguageName)"
	 		+ " From ProgrammingLanguage pl Inner Join "
	 		+ "pl.programmingLanguageNameList plnl where pl.candidateNumber=:id")
	List<ProgrammingLanguageDto> getAllDto(int id); 
 
}
