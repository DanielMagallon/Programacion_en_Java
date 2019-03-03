package C15Files;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountRecordSerializable implements Serializable
{
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	ArrayList<Object> arr = new ArrayList<>();
	
	public AccountRecordSerializable()
	{
		this(0, "", "", 0.0);
	}
	
	public AccountRecordSerializable(int acct, String name, String last, double bal)
	{
		setAccount( acct );
		setFirstName( name );
		setLastName( last );
		setBalance( bal );
	}
	
	public void setBalance(double bal)
	{
		balance=bal;
	}

	public void setLastName(String last)
	{
		lastName=last;
	}

	public void setFirstName(String name)
	{
		firstName=name;
	}

	public void setAccount(int acct)
	{
		account=acct;
	}
	
	public int getAccount()
	{
		return account;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public double getBalance()
	{
		return balance;
	}
}
