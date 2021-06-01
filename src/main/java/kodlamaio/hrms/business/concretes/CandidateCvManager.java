package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@Service
public class CandidateCvManager implements CandidateCvService{
	
	private CandidateCvDao candidateCvDao;
	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao) {
		this.candidateCvDao = candidateCvDao;
	}

	@Override
	public Result add(CandidateCv candidateCv) {
		this.candidateCvDao.save(candidateCv);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<CandidateCv>> getAll() {
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<List<CandidateCv>> getAllSchoolName() {
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.getAllSchoolName(),"Data Listelendi");
	}

	@Override
	public DataResult<List<CandidateCv>> getAllJobExperience() {
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.getAllJobExperience(),"Data Listelendi");
	}


	/*@Override
	public DataResult<List<CandidateCvDto>> getAllllll() {
		
		return new SuccessDataResult<List<CandidateCvDto>>(this.candidateCvDao.getAllllll(),"Data Listelendi dto");
	}*/

	

}
