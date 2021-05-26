package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.JobPositions;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;

public interface JobPositionsService {
	 
	DataResult<List<JobPositions>> getAll();
    Result add(JobPositions jobPositions);
    Result delete(JobPositions jobPositions);

}
