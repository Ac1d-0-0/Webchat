package webchat.service;

import java.util.List;

import webchat.model.Message;
import webchat.model.User;

public interface UserService 
{
	/**
	 * �û���¼����
	 * @param id
	 * @param pass
	 * @return ���ص�¼״̬��1Ϊ�ɹ���0Ϊʧ��
	 */
	public int login(String id,String pass);
	/**
	 * �û�ע�᷽��
	 * @param id
	 * @param pass
	 * @param name
	 * @param email
	 * @return ����ע��״̬��1Ϊ�ɹ���0Ϊʧ��
	 */
	public int registe(String id,String pass,String name,String email);
	/**
	 * �����û�id�����û�
	 * @param id �û�id
	 * @return ����User�����
	 */
	public User selectuser(String id);

	/**
	 * ���ұ��˺���
	 * @param id �û�id
	 * @return �����б�
	 */
	public List<User> showfriends(String id);
	/**
	 * ����Ⱥ��
	 * @param id �û�id
	 * @return 0Ϊ����ʧ�ܣ�1Ϊ����ɹ�
	 */
	public int joingroup(String id);
	/**
	 * 
	 * @param myid ����id
	 * @param fdid ����id
	 * @return
	 */
	public int makefriends(String myid,String fdid);
	
	 
}
