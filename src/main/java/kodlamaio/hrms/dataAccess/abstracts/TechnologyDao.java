package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
	
	boolean existsByTechnologyIdAndCandidateNumber(int technologyId,int cvId);
	
	 @Query("Select new kodlamaio.hrms.entities.dtos.TechnologyDto(t.id,t.candidateNumber,tnl.name)"
		 		+ " From Technology t Inner Join "
		 		+ "t.technologyNameList tnl where t.candidateNumber=:id")
		List<TechnologyDto> getAllDto(int id); 
	 
	 Technology getById(int id);
	 
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.TechnologyDto(t.id,t.candidateNumber,tnl.name)"
		 		+ " From Technology t Inner Join "
		 		+ "t.technologyNameList tnl where t.id=:id")
	 TechnologyDto getByIdDto(int id);
}
