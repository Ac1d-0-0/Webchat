package webchat.service;

import java.util.List;

import webchat.model.Message;
import webchat.model.User;

public interface UserService 
{
	/**
	 * 用户登录方法
	 * @param id
	 * @param pass
	 * @return 返回登录状态，1为成功，0为失败
	 */
	public int login(String id,String pass);
	/**
	 * 用户注册方法
	 * @param id
	 * @param pass
	 * @param name
	 * @param email
	 * @return 返回注册状态，1为成功，0为失败
	 */
	public int registe(String id,String pass,String name,String email);
	/**
	 * 根据用户id查找用户
	 * @param id 用户id
	 * @return 返回User类对象
	 */
	public User selectuser(String id);

	/**
	 * 查找本人好友
	 * @param id 用户id
	 * @return 好友列表
	 */
	public List<User> showfriends(String id);
	/**
	 * 加入群聊
	 * @param id 用户id
	 * @return 0为加入失败，1为加入成功
	 */
	public int joingroup(String id);
	/**
	 * 
	 * @param myid 本人id
	 * @param fdid 好友id
	 * @return
	 */
	public int makefriends(String myid,String fdid);
	
	 
}
