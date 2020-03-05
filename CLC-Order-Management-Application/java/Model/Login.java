package Model;

public class Login 
{
	private String userName;
	private String passWord;
	
	public String getUsername()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return passWord;
	}
	
	public void setUsername(String incUser)
	{
		this.userName = incUser;
	}
	
	public void setPassword(String incPass)
	{
		this.passWord = incPass;
	}
}
