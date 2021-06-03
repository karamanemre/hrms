package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Languages;

public interface LanguagesDao extends JpaRepository<Languages, Integer>{
	boolean existsByLanguageName(String languageName);
	boolean existsByCvId(int cvId);
}
