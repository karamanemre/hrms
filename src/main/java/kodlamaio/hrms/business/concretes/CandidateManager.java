package kodlamaio.hrms.business.concretes;


import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.adapters.CustomerCheckService;
import kodlamaio.hrms.core.adapters.MernisServiceAdapter;
import kodlamaio.hrms.core.emails.EmailRules;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Users;
import net.bytebuddy.asm.Advice.This;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private UserDao userDao;
	private CustomerCheckService<Candidate> customerCheckService;
	private EmailRules emailRules;
	private VerifyCodeService verifyCodeService;
	
	@Autowired
	public CandidateManager(CandidateDao jobSeekersDao,UserDao userDao,CustomerCheckService<Candidate> customerCheckService,EmailRules emailRules, VerifyCodeService verifyCodeService) {
		this.candidateDao=jobSeekersDao;
		this.userDao=userDao;
		this.customerCheckService=customerCheckService;
		this.emailRules=emailRules;
		this.verifyCodeService=verifyCodeService;
		
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		
		/*if (customerCheckService.mernisControl(candidate)==false) {
			return new ErrorResult("Mernis Doğrulama Başarısız");
		}*/
		
		if (userDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("Email zaten mevcut");
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
		//this.verifyCodeService.createVerifyCode(userDao.getOne(candidate.getUserId()));
		//this.verifyCodeService.sendMail(candidate.getEmail());
		return new SuccessResult("Başarıyla Eklendi");
		
		
	}
	
}
