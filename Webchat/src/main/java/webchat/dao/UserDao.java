package webchat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import webchat.model.User;

public interface UserDao 
{
	public User login(@Param("User")String User,@Param("UserPass")String Password);
	
	//public User getUserbyId(@Param("UserId")String UserID);
	
	public int register(@Param("Password")String pass,@Param("UserName")String name,@Param("UserEmail")String email);
	
	public User GetUserbyemail(@Param("UserEmail")String email);
	
	public int addfriend(@Param("MyID")int myid,@Param("FID")int fid);
	
	public int isFriend(@Param("MyID")int myid,@Param("FID")int fid);
	
	public List<String> getfriend(@Param("MyID")int myid);
}
