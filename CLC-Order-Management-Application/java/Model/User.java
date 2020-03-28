package Model;

/**
 * User class.
 * @author Cameron Deao & John Harrison
 *
 */
public class User 
{
	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private int phoneNumber;
	private String username;
	private String password;

	/**
	 * getId()
	 * @return
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * setId()
	 * @param id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * getFirstName()
	 * @return
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * getLastName()
	 * @return
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * getEmailAddress()
	 * @return
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	/**
	 * getPhoneNumber()
	 * @return
	 */
	public int getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/**
	 * getUsername()
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
	 * setFirstName()
	 * @param incFirst
	 */
	public void setFirstName(String incFirst)
	{
		this.firstName = incFirst;
	}
	
	/**
	 * setLastName()
	 * @param incLast
	 */
	public void setLastName(String incLast)
	{
		this.lastName = incLast;
	}
	
	/**
	 * setEmailAddress()
	 * @param incEmail
	 */
	public void setEmailAddress(String incEmail)
	{
		this.emailAddress = incEmail;
	}
	
	/**
	 * setPhoneNumber()
	 * @param incPhone
	 */
	public void setPhoneNumber(int incPhone)
	{
		this.phoneNumber = incPhone;
	}
	
	/**
	 * setUsername()
	 * @param incUsername
	 */
	public void setUsername(String incUsername)
	{
		this.username = incUsername;
	}
	
	/**
	 * setPassword()
	 * @param incPassword
	 */
	public void setPassword(String incPassword)
	{
		this.password = incPassword;
	}
}
