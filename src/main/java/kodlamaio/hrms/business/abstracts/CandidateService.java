package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
    Result add(Candidate candidate);
    
    /*DataResult<Candidate> getByFirstNameAndLastName(String firstName,String lastName);
	  
    DataResult<Candidate> getByFirstNameAndLastNameAndJobPositions_Id(String firstName,String lastName, int jobPositions);
	  
    DataResult<List<Candidate>> getByFirstNameOrLastName(String firstName, String lastName);
	  
    DataResult<List<Candidate>> getByJobPositionsIn(List<Integer> jobPositions);
	  
    DataResult<List<Candidate>> getByFirstNameContains(String candidateName); 
	  
    DataResult<List<Candidate>> getByFirstNameStartsWith(String productName);*/
	  
    //DataResult<List<Candidate>> getByNameAndCategory(String nationalId);
}
