package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class EmployersManager implements EmployersService{
	
	private EmployersDao employersDao;
	private UserDao userDao;
	private VerifyCodeService verifyCodeService;
	
	@Autowired
	public EmployersManager(EmployersDao employersDao,UserDao userDao,VerifyCodeService verifyCodeService) {
		this.employersDao=employersDao;
		this.userDao=userDao;
		this.verifyCodeService=verifyCodeService;
		
	}
	
	@Override
	public DataResult<List<Employers>> getAll() {
		
		return new SuccessDataResult<List<Employers>>(employersDao.findAll(),"Emloyers Datası Listelendi");
	}
	

	@Override
	public Result add(Employers employers) {
		
		if (this.userDao.existsByEmail(employers.getEmail())) {
			return new ErrorResult("Email zaten kullanılıyor");
		}
		
		String websiteString = employers.getWebSite().split("www.")[1];
		if (!employers.getEmail().split("@")[0].equals(websiteString.split(".com")[0])) {
			return new ErrorResult("Lütfen Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olun");
		}
		
		
		if (employers.getPassword().equals(employers.getPassword_repeat())==false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		
		this.employersDao.save(employers);
		this.verifyCodeService.createVerifyCode(userDao.getOne(employers.getUserId()));
		this.verifyCodeService.sendMail(employers.getEmail());
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<Employers>> getByUserId(int id) {
		return new SuccessDataResult<List<Employers>>(this.employersDao.getByUserId(id),"Data Listelendi");
	}

	@Override
	public Result uptadeEmployers(Employers update_information) {
		Employers employersId = employersDao.getByUserIdEmployers(update_information.getUserId());
		update_information.setUserId(employersId.getUserId());
		
		if (update_information.getCompanyName().equals("")) { 
			update_information.setCompanyName(employersId.getCompanyName());
		}
		if (update_information.getPhoneNumber().equals("")) {
			update_information.setPhoneNumber(employersId.getPhoneNumber());
		}
		if (update_information.getWebSite().equals("")) {
			update_information.setWebSite(employersId.getWebSite());
		}
		if (update_information.getEmail().equals("")) {
			update_information.setEmail(employersId.getEmail());
		}
		if (update_information.getPassword().equals("")) {
			update_information.setPassword(employersId.getEmail());
		}
		employersId.setUptade_information(update_information);
		this.employersDao.save(employersId);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public Result uptadeConfirmation(int userId) {
		Employers employersId = employersDao.getByUserIdEmployers(userId);
		employersId.setEmail(employersId.getUptade_information().getEmail());
		employersId.setPassword(employersId.getUptade_information().getPassword());
		employersId.setCompanyName(employersId.getUptade_information().getCompanyName());
		employersId.setPhoneNumber(employersId.getUptade_information().getPhoneNumber());
		employersId.setWebSite(employersId.getUptade_information().getWebSite());
		employersId.setUptade_information(null);
		this.employersDao.save(employersId);
		return new SuccessResult("Başarıyla Güncellendi");
	}

	@Override
	public DataResult<List<Employers>> getByUptadeConfirmationWait() {
		return new SuccessDataResult<List<Employers>>(this.employersDao.getByUptadeConfirmationWait());
	}
	
	

}
