package kodlamaio.hrms.business.concretes;


import java.util.List;
import java.util.regex.Pattern;

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
import kodlamaio.hrms.core.concretes.emailManager.concrete.IsEmailValid;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class CandidateManager implements CandidateService{
	
	
	
	private CandidateDao candidateDao;
	private UserDao userDao;
	private CustomerCheckService customerCheckService;
	private IsEmailValid isEmailValid;
	
	@Autowired
	public CandidateManager(CandidateDao jobSeekersDao,UserDao userDao,CustomerCheckService customerCheckService,IsEmailValid isEmailValid) {
		this.candidateDao=jobSeekersDao;
		this.userDao=userDao;
		this.customerCheckService=customerCheckService;
		this.isEmailValid=isEmailValid;
		
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
				candidate.getNationalId().equals("")||
				candidate.getEmail().equals("")
				) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz");
		}
		
		if (userDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("Email zaten mevcut");
		}
		
		if (isEmailValid.isEmailValid(candidate.getEmail())==false) {
			return new ErrorResult("Lütfen geçerli bir email giriniz");
		}
		
		if (candidateDao.existsByNationalId(candidate.getNationalId())) {
			return new ErrorResult("Tc kimlik numarası zaten mevcut");
		}
		
		if ((candidate.getNationalId().length() >10  && candidate.getNationalId().length()<12)==false) {
			return new ErrorResult("Tc Kimlik Numarası 11 Haneli Olmalıdır");
		}
		
		if (candidate.getPassword().equals(candidate.getPassword_repeat())==false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		
		
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Başarıyla Eklendi");
		
		
	}
	
	
}
