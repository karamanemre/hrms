package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SchoolNameList;

public interface SchoolNameListDao extends JpaRepository<SchoolNameList, Integer> {
	
	boolean existsBySchoolName(String schoolName);
	
}
