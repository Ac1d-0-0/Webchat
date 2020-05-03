package webchat.model;

public class User 
{
	private String UserName;
	private int UserId;
	private String UserPass;
	private String UserEmail;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserPass() {
		return UserPass;
	}
	public void setUserPass(String userPass) {
		UserPass = userPass;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	
}
