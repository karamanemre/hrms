package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.TechnologyNameList;

public interface TechnologyNameListDao extends JpaRepository<TechnologyNameList, Integer>{

}
