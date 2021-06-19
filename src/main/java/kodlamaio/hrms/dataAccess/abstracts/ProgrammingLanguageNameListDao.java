package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ProgrammingLanguageNameList;

public interface ProgrammingLanguageNameListDao extends JpaRepository<ProgrammingLanguageNameList, Integer>{
	
	List<ProgrammingLanguageNameList> findById(int id);
}
