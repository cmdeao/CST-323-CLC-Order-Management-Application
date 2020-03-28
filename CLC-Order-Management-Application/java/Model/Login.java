package Model;

/**
 * Login class.
 * @author Cameron Deao & John Harrison
 *
 */
public class Login 
{
	private String username;
	private String password;
	
	/**
	 * getUserName()
	 * @return
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * getPassword()
	 * @return
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * setUsername()
	 * @param incUser
	 */
	public void setUsername(String incUser)
	{
		this.username = incUser;
	}
	
	/**
	 * setPassword()
	 * @param incPass
	 */
	public void setPassword(String incPass)
	{
		this.password = incPass;
	}
}
