package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobPostings;
import kodlamaio.hrms.entities.dtos.JobPostingsDto;

public interface JobPostingsDao extends JpaRepository<JobPostings, Integer>{
	
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where j.isActive=:bool order by j.applicaitonDeadline desc ")
	 List<JobPostingsDto> findAllByIsActiveTrueOrderByApplicaitonDeadlineDesc(boolean bool);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where j.isActive=:bool order by j.applicaitonDeadline asc ")
	 List<JobPostingsDto> findAllByIsActiveTrueOrderByApplicaitonDeadlineAsc(boolean bool);

	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where e.companyName=:companyName and j.isActive=:bool")
	 List<JobPostingsDto> getByIsActiveAndEmployer(String companyName,boolean bool);
	 
	 @Query("From JobPostings where employer_id=:employerId") 
	 JobPostings getByEmployer(int employerId);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where e.id=:id ") 
	 List<JobPostingsDto> getByIdList(int id);
	 
	 JobPostings getById(int id);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where j.id=:id ")
	 List<JobPostingsDto> getByIdDto(int id);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where j.isConfirmation=false ")
	 List<JobPostingsDto> getAllByIsConfirmationFalse();
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.employer e Inner Join j.city c Inner Join j.jobPosition jp")
	 List<JobPostingsDto> getAll();
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.employer e Inner Join j.city c Inner Join j.jobPosition jp where j.isConfirmation=true")
	 List<JobPostingsDto> getAll(Pageable pageable);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where j.isActive=:isActive ")
	 List<JobPostingsDto> getAllByIsActive(boolean isActive);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where j.isConfirmation=true ")
	 List<JobPostingsDto> getAllByIsConfirmation();
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where j.workplace=:id ")
	 List<JobPostingsDto> filterWorkplace(int id);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where j.typeOfWork=:id ")
	 List<JobPostingsDto> filterTypeOfWork(int id);
	 

	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,"
	 		+ "jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,"
	 		+ "j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary,c.id,jp.id) From JobPostings j Inner Join j.jobPosition"
	 		+ " jp Inner Join j.employer e Inner Join j.city c where j.cityId IN :cities and jp.id IN :positions")
	 List<JobPostingsDto> filterCityAndPosition(List<Integer> cities,List<Integer> positions);
	 
	
	 
	 
	 
	 
	 
//	 @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where  j.city=:cities ") 
//	 List<JobPostingsDto> findByCitiesName(String cities);
	 
	 //  @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsDto(j.id,e.companyName,jp.positionName,j.numberOfOpenPosition,j.applicaitonDeadline,j.releaseDate,j.description,j.isConfirmation,j.workplace,j.typeOfWork,c.city,j.minSalary,j.maxSalary) From JobPostings j Inner Join j.jobPosition jp Inner Join j.employer e Inner Join j.city c where c IN :cities ")
	 
	 
	 
	 
	 
	 
}