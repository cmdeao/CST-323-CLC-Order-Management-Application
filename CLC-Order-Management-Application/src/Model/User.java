package Model;

public class User 
{
	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private int phoneNumber;
	private String username;
	private String password;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public int getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setFirstName(String incFirst)
	{
		this.firstName = incFirst;
	}
	
	public void setLastName(String incLast)
	{
		this.lastName = incLast;
	}
	
	public void setEmailAddress(String incEmail)
	{
		this.emailAddress = incEmail;
	}
	
	public void setPhoneNumber(int incPhone)
	{
		this.phoneNumber = incPhone;
	}
	
	public void setUsername(String incUsername)
	{
		this.username = incUsername;
	}
	
	public void setPassword(String incPassword)
	{
		this.password = incPassword;
	}
}
