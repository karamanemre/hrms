package kodlamaio.hrms.core.abstracts;


import kodlamaio.hrms.entities.concretes.Candidate;

public interface CustomerCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
