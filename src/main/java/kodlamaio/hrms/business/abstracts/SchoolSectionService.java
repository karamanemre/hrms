package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.SchoolSection;

public interface SchoolSectionService {
	Result add(SchoolSection schoolSection);
	DataResult<List<SchoolSection>> getAll();
}
