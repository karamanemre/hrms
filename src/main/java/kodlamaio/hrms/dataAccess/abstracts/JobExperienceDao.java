package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.School;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	
	@Query("From JobExperience order by finishYear desc")
	List<JobExperience> getOrderByFinishYearDesc();
	
	List<JobExperience> findByCandidateNumber(int id);
	
	JobExperience getById(int id);
	
}
