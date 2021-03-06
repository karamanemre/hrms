package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
	Result add(SocialMedia socialMedia);
	DataResult<List<SocialMedia>> getAll();
	
	DataResult<List<SocialMedia>> findByCandidateNumber(int id);
	
	SocialMedia getById(int id);
	Result uptadeSocialMedia(int id,SocialMedia socialMedia);
}
