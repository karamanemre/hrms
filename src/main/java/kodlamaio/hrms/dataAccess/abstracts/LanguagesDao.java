package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.dtos.LanguageDto;

public interface LanguagesDao extends JpaRepository<Languages, Integer>{
	
	boolean existsByLanguageIdAndCandidateNumber(int languageId,int candidateId);
	
}
