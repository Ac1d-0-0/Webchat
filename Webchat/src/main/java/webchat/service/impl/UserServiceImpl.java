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
	public int login(String id, String pass) 
	{
		User u = ud.login(id, pass);
		if(u.getUserId()==id&&u.getUserPass()==pass)
		{
			
		}
		return 0;
	}

}
