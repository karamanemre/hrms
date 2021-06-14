package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidatePhotoService;
import kodlamaio.hrms.core.imageUploaders.ImageService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidatePhotoDao;
import kodlamaio.hrms.entities.concretes.CandidatePhoto;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class CandidatePhotoManager implements CandidatePhotoService {
	
	private CandidatePhotoDao candidatePhotoDao;
	private ImageService imageService;
	
	
	@Autowired
	public CandidatePhotoManager(CandidatePhotoDao candidatePhotoDao, ImageService imageService) {
		super();
		this.candidatePhotoDao = candidatePhotoDao;
		this.imageService = imageService;
		
	}

	@Override
	public Result add(CandidatePhoto candidatePhoto, MultipartFile file) {
		this.candidatePhotoDao.save(candidatePhoto);
		return new SuccessResult("Photo added");
	}

	@Override
	public DataResult<List<CandidatePhoto>> getAll() {
		return new SuccessDataResult<List<CandidatePhoto>>(this.candidatePhotoDao.findAll(),"Data Listelendi");
	}
}
