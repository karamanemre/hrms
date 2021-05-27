package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerifyCodeDao;
import kodlamaio.hrms.entities.concretes.Users;
import kodlamaio.hrms.entities.concretes.VerifyCode;

@Service
public class VerifyCodeManager implements VerifyCodeService{
	
	private VerifyCodeDao verifyCodeDao;
	
	@Autowired
	public VerifyCodeManager(VerifyCodeDao verifyCodeDao) {
		super();
		this.verifyCodeDao = verifyCodeDao;
	}

	@Override
	public String createVerifyCode(Users user) {
		String vCode = UUID.randomUUID().toString();
		VerifyCode Code = new VerifyCode();
		LocalDate e = (LocalDate.now());
		Code.setUserId(user);
		Code.setCreatedDate(Date.valueOf(e));
		Code.setVerifyCode(UUID.randomUUID().toString());
		this.verifyCodeDao.save(Code);
		return vCode;
	}

	@Override
	public void sendMail(String mail) {
		System.out.println("Doğrulama Maili Gönderildi : " + mail);
		
	}

	@Override
	public Result verifyUser(String code) {
		if (!this.verifyCodeDao.existsByVerifyCode(code)) {
			return new ErrorResult("Hatalı Doğrulama İşlemi");
		}
		VerifyCode newVerifyCode = verifyCodeDao.getByVerifyCode(code);
		LocalDate e = (LocalDate.now());
		newVerifyCode.setConfirmed(true);
		newVerifyCode.setConfirmedDate(Date.valueOf(e));
		verifyCodeDao.save(newVerifyCode);
		return new SuccessResult("Doğrulama Başarılı");	
	}

	
}
