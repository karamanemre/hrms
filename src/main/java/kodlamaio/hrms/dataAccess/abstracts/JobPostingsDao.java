package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobPostings;

public interface JobPostingsDao extends JpaRepository<JobPostings, Integer>{
	
	 List<JobPostings> findAllByIsActive(boolean jobPosting);
	 List<JobPostings> findAllByIsActiveTrueOrderByApplicaitonDeadline();
	 
	 @Query("From JobPostings where isActive=:bool and employer_id=:id")
	 List<JobPostings> getByIsActiveAndEmployer(boolean bool,int id);
	 
}