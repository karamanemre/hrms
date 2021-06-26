package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	
	@Query("From School order by finishYear desc")
	List<School> getOrderByFinishYear();
	
	@Query("From School where candidateNumber=:candidateNumber")
	List<School> findById(int candidateNumber);
	
	School getById(int id);

}
