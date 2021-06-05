package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.CandidatePhoto;

public interface CandidatePhotoService {
	//Result add(CandidatePhoto candidatePhoto);

	

	Result add(CandidatePhoto candidatePhoto, MultipartFile file);
	/*Result addAll(List<CandidatePhoto> candidatePhoto);
	Result delete(CandidatePhoto candidatePhoto);

	DataResult<CandidatePhoto> getById(int candidatePhotoId);
*/
	DataResult<List<CandidatePhoto>> getAll();

	

}
