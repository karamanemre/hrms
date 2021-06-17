package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Photo;

public interface PhotoService {
	Result add(Photo photo);
	Result add(Photo photo, MultipartFile file);
	DataResult<List<Photo>> getAll();

	

}
