package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {
	
	private SocialMediaDao socialMediaDao;
	
	public SocialMediaManager(SocialMediaDao socialMedia) {
		super();
		this.socialMediaDao = socialMedia;
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		return new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<List<SocialMedia>> findByCandidateNumber(int id) {
		return new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.findByCandidateNumber(id),"Data Listelendi");
	}

	@Override
	public SocialMedia getById(int id) {
		return this.socialMediaDao.getById(id);
	}

	@Override
	public Result uptadeSocialMedia(int id, SocialMedia socialMedia) {
		SocialMedia socialMediaId = this.socialMediaDao.getById(id);
		socialMediaId=socialMedia;
		socialMediaId.setId(id);
		this.socialMediaDao.save(socialMediaId);
		return new SuccessResult("Güncellendi");
	}

}
