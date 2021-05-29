package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	boolean existsByNationalId(String national_id);
	
	/*Candidate getByFirstNameAndLastName(String firstName,String lastName);
	  
	Candidate getByFirstNameAndLastNameAndJobPositions_Id(String firstName,String lastName, int jobPositions);
	  
	List<Candidate> getByFirstNameOrLastName(String firstName, String lastName);
	  
	List<Candidate> getByJobPositionsIn(List<Integer> jobPositions);
	  
	List<Candidate> getByFirstNameContains(String candidateName); //içerisinde --- olanları getir
	  
	List<Candidate> getByFirstNameStartsWith(String productName);*/
	  
	/*@Query("From Product where nationalId=:nationalId )//and category.categoryId=:categoryId")
	List<Candidate> getByNameAndCategory(String nationalId);*/
	
}
