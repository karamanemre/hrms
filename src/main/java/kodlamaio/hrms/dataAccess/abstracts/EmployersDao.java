package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{
	
	
	List<Employers> getByUserId(int id);
	
}
