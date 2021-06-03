package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolSectionService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolSectionDao;
import kodlamaio.hrms.entities.concretes.SchoolSection;

@Service
public class SchoolSectionManager implements SchoolSectionService {
	
	private SchoolSectionDao schoolSectionDao;
	
	@Autowired
	public SchoolSectionManager(SchoolSectionDao schoolSectionDao) {
		super();
		this.schoolSectionDao = schoolSectionDao;
	}

	@Override
	public Result add(SchoolSection schoolSection) {
		if (schoolSectionDao.existsBySchoolSection(schoolSection.getSchoolSection())) {
			return new ErrorResult("Daha Önce Eklendi");
		}
		this.schoolSectionDao.save(schoolSection);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<SchoolSection>> getAll() {
		return new SuccessDataResult<List<SchoolSection>>(this.schoolSectionDao.findAll(),"Data Listelendi");
	}

}
