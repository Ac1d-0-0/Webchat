package webchat.dao;

import org.apache.ibatis.annotations.Param;

import webchat.model.User;

public interface UserDao 
{
	public User login(@Param("UserId")String UserID,@Param("UserPass")String Password);
}
