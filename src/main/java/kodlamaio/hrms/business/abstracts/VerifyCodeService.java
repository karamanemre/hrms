package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Users;

public interface VerifyCodeService {
	String createVerifyCode(Users user);
	void sendMail(String mail);
	Result verifyUser(String code); 
}
