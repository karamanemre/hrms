package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.emails.IsEmailValid;
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
