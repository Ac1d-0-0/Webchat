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
	
	public int register(String pass,String name,String email)
	{
		 int result = ud.register(pass, name, email);
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

	public int makefriends(int myid, String femail) {
		// TODO 自动生成的方法存根
		User u =ud.GetUserbyemail(femail);
		if (u==null) 
			return 5;
		else {
			int fid=u.getUserId();
			int isfriend = ud.isFriend(myid,fid);
			if (isfriend==1) {
				return 4;
			}
			else {
				int status=ud.addfriend(myid,fid);
				return status;
			}
		}
	}
	
	public List<User> getFriends(int myid){
		List<User> l= ud.getfriend(myid);
		return l;
	}

	public User GetUserbyid(int id) 
	{
		return ud.GetUserbyid(id);
	}

	public int isfriend(int myid, int fid) {
		return ud.isFriend(myid, fid);
	}

}
