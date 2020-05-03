package webchat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webchat.dao.UserDao;
import webchat.model.User;
import webchat.service.UserService;
@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService 
{
	@Resource
	private UserDao ud;
	public int login(String UserNameOrUserEmail, String Password) 
	{
		User u = ud.login(UserNameOrUserEmail, Password);
		if((u.getUserName()==UserNameOrUserEmail&&u.getUserPass()==Password)||u.getUserEmail()==UserNameOrUserEmail&&u.getUserPass()==Password)
		{
			return 1;
		}
		return 0;
	}
	
	public int registe(String pass,String name,String email)
	{
		 int result = ud.registe(pass, name, email);
		 if(result==0)
			 return 0;
		 else
			 return 1;
	}

}
