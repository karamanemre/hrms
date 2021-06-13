package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobPostings;
import kodlamaio.hrms.entities.dtos.JobPostingsDto;

public interface JobPostingsDao extends JpaRepository<JobPostings, Integer>{
	
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e where j.isActive=:bool order by j.applicaitonDeadline desc ")
	 List<JobPostingsDto> findAllByIsActiveTrueOrderByApplicaitonDeadlineDesc(boolean bool);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e where j.isActive=:bool order by j.applicaitonDeadline asc ")
	 List<JobPostingsDto> findAllByIsActiveTrueOrderByApplicaitonDeadlineAsc(boolean bool);

	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e where e.companyName=:companyName and j.isActive=:bool")
	 List<JobPostingsDto> getByIsActiveAndEmployer(String companyName,boolean bool);
	 
	 @Query("From JobPostings where employer_id=:employerId") 
	 JobPostings getByEmployer(int employerId);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description) From JobPostings j Inner Join j.employer e Inner Join j.jobPosition jp")
	 List<JobPostingsDto> getAll();
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e where j.isActive=:isActive ")
	 List<JobPostingsDto> getAllByIsActive(boolean isActive);
	 
	 
	 
	 
	 
	 
}