package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.concretes.DataResult;
import kodlamaio.hrms.core.concretes.ErrorResult;
import kodlamaio.hrms.core.concretes.Result;
import kodlamaio.hrms.core.concretes.SuccessDataResult;
import kodlamaio.hrms.core.concretes.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class EmployersManager implements EmployersService{
	
	private EmployersDao employersDao;
	private UserDao userDao;
	
	@Autowired
	public EmployersManager(EmployersDao employersDao,UserDao userDao) {
		this.employersDao=employersDao;
		this.userDao=userDao;
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
		

		for (Users iterator : this.userDao.findAll()) {
			if (iterator.getEmail().equals(employers.getEmail())) {
				return new ErrorResult("Email zaten kullanılıyor");
			}
		}
		
		if (employers.getPassword().equals(employers.getPassword_repeat())==false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		
		this.employersDao.save(employers);
		return new SuccessResult("Başarıyla Eklendi");
	}

}
