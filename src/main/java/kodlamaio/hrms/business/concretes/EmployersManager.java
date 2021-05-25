package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.*;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.concretes.DataResult;
import kodlamaio.hrms.core.concretes.ErrorResult;
import kodlamaio.hrms.core.concretes.Result;
import kodlamaio.hrms.core.concretes.SuccessDataResult;
import kodlamaio.hrms.core.concretes.SuccessResult;
import kodlamaio.hrms.core.concretes.emailManager.concrete.IsEmailValid;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployersService{
	
	private EmployersDao employersDao;
	private UserDao userDao;
	private IsEmailValid isEmailValid;
	
	@Autowired
	public EmployersManager(EmployersDao employersDao,UserDao userDao,IsEmailValid isEmailValid) {
		this.employersDao=employersDao;
		this.userDao=userDao;
		this.isEmailValid=isEmailValid;
	}
	
	@Override
	public DataResult<List<Employers>> getAll() {
		
		return new SuccessDataResult<List<Employers>>(employersDao.findAll(),"Emloyers Datası Listelendi");
	}
	

	@Override
	public Result add(Employers employers) {
		if (employers.getCompanyName().equals("") ||
				employers.getEmail().equals("")||
				employers.getPassword().equals("")||
				employers.getPhoneNumber().equals("")||
				employers.getWebSite().equals("")
				) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz");
		}
		
		if (this.userDao.existsByEmail(employers.getEmail())) {
			return new ErrorResult("Email zaten kullanılıyor");
		}
		
		if (isEmailValid.isEmailValid(employers.getEmail())==false) {
			return new ErrorResult("Lütfen geçerli bir email giriniz");
		}
		
		if (employers.getPassword().equals(employers.getPassword_repeat())==false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		
		this.employersDao.save(employers);
		return new SuccessResult("Başarıyla Eklendi");
	}

}
