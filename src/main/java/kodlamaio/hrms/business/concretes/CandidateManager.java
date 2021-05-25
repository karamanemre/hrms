package kodlamaio.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.abstracts.CustomerCheckService;
import kodlamaio.hrms.core.concretes.DataResult;
import kodlamaio.hrms.core.concretes.ErrorResult;
import kodlamaio.hrms.core.concretes.MernisServiceAdapter;
import kodlamaio.hrms.core.concretes.Result;
import kodlamaio.hrms.core.concretes.SuccessDataResult;
import kodlamaio.hrms.core.concretes.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private UserDao userDao;
	private CustomerCheckService customerCheckService;
	
	@Autowired
	public CandidateManager(CandidateDao jobSeekersDao,UserDao userDao,CustomerCheckService customerCheckService) {
		this.candidateDao=jobSeekersDao;
		this.userDao=userDao;
		this.customerCheckService=customerCheckService;
		
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
			
		if (candidate.getFirstName().equals("") ||
				candidate.getLastName().equals("")||
				candidate.getPassword().equals("")||
				candidate.getDateOfBirth().equals("")||
				candidate.getNational_id().equals("")||
				candidate.getEmail().equals("")
				) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz");
		}
		
		for (Users iterator : this.userDao.findAll()) {
			if (iterator.getEmail().equals(candidate.getEmail())) {
				return new ErrorResult("Email zaten kullanılıyor");
			}
		}
		
		for (Candidate iterator : this.candidateDao.findAll()) {
			if (iterator.getNational_id().equals(candidate.getNational_id())) {
				return new ErrorResult("Tc kimlik numarası zaten kayıtlı");
			}
		}
		
		if ((candidate.getNational_id().length() >10  && candidate.getNational_id().length()<12)==false) {
			return new ErrorResult("Tc Kimlik Numarası 11 Haneli Olmalıdır");
		}
		
		if (candidate.getPassword().equals(candidate.getPassword_repeat())==false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		
		
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Başarıyla Eklendi");
		
		
	}
	
	
}
