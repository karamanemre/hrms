package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SchoolSection;

public interface SchoolSectionDao extends JpaRepository<SchoolSection, Integer>{
	
	boolean existsBySection(String schoolSection);
	
}
