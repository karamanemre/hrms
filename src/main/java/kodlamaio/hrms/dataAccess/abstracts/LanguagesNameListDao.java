package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LanguageNameList;

public interface LanguagesNameListDao extends JpaRepository<LanguageNameList, Integer>{

}
