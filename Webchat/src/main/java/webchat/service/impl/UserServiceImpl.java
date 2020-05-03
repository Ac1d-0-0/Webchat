package webchat.service.impl;

import java.util.List;

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
	public User login(String UserNameOrUserEmail, String Password) 
	{
		User u = ud.login(UserNameOrUserEmail, Password);
		return u;
	}
	
	public int registe(String pass,String name,String email)
	{
		 int result = ud.registe(pass, name, email);
		 if(result==0)
			 return 0;
		 else
			 return 1;
	}

	public User selectuser(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	public List<User> showfriends(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	public int joingroup(String id) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int makefriends(String myid, String fdid) {
		// TODO 自动生成的方法存根
		return 0;
	}

}
