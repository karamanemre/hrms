package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ProgrammingLanguages;

public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguages, Integer>{

}
