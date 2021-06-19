package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {
	Result add(School school);
	DataResult<List<School>> getAll();
	DataResult<List<School>> getAllOrderByFinishYear();
	DataResult<List<School>> findById(int candidateNumber);
}
