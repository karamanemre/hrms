package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.JobPostings;

@Service
public class CoverLetterManager implements CoverLetterService {
	private CoverLetterDao coverLetterDao;
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}
	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Eklendi");
	}
	
	@Override
	public CoverLetter getById(int id) {
	 	return this.coverLetterDao.getById(id);
	}
	
	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll(),"Data Listelendi");
	}
	@Override
	public Result uptadeCoverLetter( int id ,CoverLetter coverLetter) {
		
		CoverLetter coverLetterId = coverLetterDao.getById(id);
		coverLetterId=coverLetter;
		coverLetterId.setId(id);
		this.coverLetterDao.save(coverLetterId);
		return new SuccessResult("Güncellendi");
		
	}
	

}
