package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.emails.EmailRules;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployersService{
	
	private EmployersDao employersDao;
	private UserDao userDao;
	private EmailRules emailRules;
	
	@Autowired
	public EmployersManager(EmployersDao employersDao,UserDao userDao,EmailRules emailRules) {
		this.employersDao=employersDao;
		this.userDao=userDao;
		this.emailRules=emailRules;
	}
	
	@Override
	public DataResult<List<Employers>> getAll() {
		
		return new SuccessDataResult<List<Employers>>(employersDao.findAll(),"Emloyers Datası Listelendi");
	}
	

	@Override
	public Result add(Employers employers) {
		if (employers.getCompanyName().isBlank()||
				employers.getEmail().isBlank()||
				employers.getPassword().isBlank()||
				employers.getPhoneNumber().isBlank()||
				employers.getWebSite().isBlank()
				) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz");
		}
		
		
		if (this.userDao.existsByEmail(employers.getEmail())) {
			return new ErrorResult("Email zaten kullanılıyor");
		}
		
		if (emailRules.isEmailValid(employers.getEmail())==false) {
			return new ErrorResult("Lütfen geçerli bir email giriniz");
		}
		
		String websiteString = employers.getWebSite().split("www.")[1];
		if (!employers.getEmail().split("@")[0].equals(websiteString.split(".com")[0])) {
			return new ErrorResult("Lütfen Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olun");
		}
		
		
		if (employers.getPassword().equals(employers.getPassword_repeat())==false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		
		this.employersDao.save(employers);
		return new SuccessResult("Başarıyla Eklendi");
	}

}
