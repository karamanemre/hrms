package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.CustomerCheckService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.entities.concretes.Users;

//@RestController
//@RequestMapping("api/users")
public class UserControllers {
	
	/*private UserService userService;
	
	
    @Autowired
    public UserControllers(UserService userService) {
		this.userService=userService; 
		
	}

    @GetMapping("/getall")
    public DataResult<List<Users>> getAll(){
        return userService.getAll();
    }
    
   @PostMapping("/add")
    public Result add(@RequestBody Users users) {
    	return this.userService.add(users);
    	
    	
    	
    	
    }
    
    @PostMapping("/delete")
    public Result delete(@RequestBody int id) {
    	return this.userService.delete(id);
  
    }*/
}
