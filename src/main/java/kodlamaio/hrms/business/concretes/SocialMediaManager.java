package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {
	
	private SocialMediaDao socialMedia;
	
	public SocialMediaManager(SocialMediaDao socialMedia) {
		super();
		this.socialMedia = socialMedia;
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		this.socialMedia.save(socialMedia);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		return new SuccessDataResult<List<SocialMedia>>(this.socialMedia.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<List<SocialMedia>> findByCandidateNumber(int id) {
		return new SuccessDataResult<List<SocialMedia>>(this.socialMedia.findByCandidateNumber(id),"Data Listelendi");
	}

}
