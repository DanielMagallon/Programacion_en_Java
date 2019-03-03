package myjava;

public class Date 
{
	private String cad;
	private int second;
	
	public Date(int seconds)
	{
		second=seconds;
	}

	public Date (String date)
	{
		if(!date.matches("[0-9]+"))
			throw new IllegalArgumentException("The date is not correct");
		
		else
			System.out.println("Good");
	}
	
	public Date toHMS()
	{
		cad = "["+second+"]";
		return this;
	}
	
	public Date toSeconds()
	{
		
		return this;
	}
	
	@Override
	public String toString()
	{
		return cad;
	}
	
	
}
