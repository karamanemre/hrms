package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ProgrammingLanguageNameList;

public interface ProgrammingLanguageNameListDao extends JpaRepository<ProgrammingLanguageNameList, Integer>{

}
