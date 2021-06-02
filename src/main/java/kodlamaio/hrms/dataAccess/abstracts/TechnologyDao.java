package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
	
	//@Query("Select new kodlamaio.hrms.entities.dtos.TechnologyDto(t.technology) From Technology t  ")
	//List<TechnologyDto> getAllDto();  
	
}
