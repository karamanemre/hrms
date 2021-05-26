package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.CustomerCheckService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Users;
import tr.gov.nvi.tckimlik.WS.KPSPublic;

//@Service
public class UserManager implements UserService{
	
	/*private UserDao userDao;
	//private CustomerCheckService customerCheckService;
	
	@Autowired
	public UserManager(UserDao userDao) {
	    this.userDao=userDao;
	    
	}
	

	@Override
	public DataResult<List<Users>> getAll() {
		
		return new SuccessDataResult<>(userDao.findAll());
	}

	@Override
	public Result add(Users users) {
		
		
		this.userDao.save(users);
		return new SuccessResult(users+ " Eklendi");
    	
    		
	}

	@Override
	public Result update(Users users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		this.userDao.deleteById(id);
		return new SuccessResult(id+"Silindi");
	}


	*/
	
	
}
