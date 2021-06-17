package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.imageUploaders.ImageService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concretes.Photo;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class PhotoManager implements PhotoService {
	
	private PhotoDao candidatePhotoDao;
	private ImageService imageService;
	
	
	@Autowired
	public PhotoManager(PhotoDao candidatePhotoDao, ImageService imageService) {
		super();
		this.candidatePhotoDao = candidatePhotoDao;
		this.imageService = imageService;
		
	}
	
	@Override
	public Result add(Photo candidatePhoto) {
		this.candidatePhotoDao.save(candidatePhoto);
		return new SuccessResult();
	}


	@Override
	public Result add(Photo candidatePhoto, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		String url = result.get("url");
		candidatePhoto.setUrl(url);
		return add(candidatePhoto);
	}

	@Override
	public DataResult<List<Photo>> getAll() {
		return new SuccessDataResult<List<Photo>>(this.candidatePhotoDao.findAll(),"Data Listelendi");
	}

	
}