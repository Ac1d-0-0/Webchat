package webchat.dao;

import org.apache.ibatis.annotations.Param;

import webchat.model.User;

public interface UserDao 
{
	public User login(@Param("User")String User,@Param("UserPass")String Password);
	
	public User getUserbyId(@Param("UserId")String UserID);
	
	public int registe(@Param("Password")String pass,@Param("UserName")String name,@Param("UserEmail")String email);
}
