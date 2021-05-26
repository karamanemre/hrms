package kodlamaio.hrms.core.adapters;


import kodlamaio.hrms.entities.concretes.Candidate;

public interface CustomerCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
