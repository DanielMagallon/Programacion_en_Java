package C10Excepciones;

public class ExcepcionA
{
	private int num1;
	private int num2;
	
	void setNumero1(int n)
	{
		if (n>=0)
		{
		num1=n;
		}
		
		else
			throw new IllegalArgumentException("El numero debe ser mayor que 0");
		
	}
	
	int getNum1()
	{
		return num1;
	}
	
	void setNumero2(int n)
	{
		if (n>=0)
		{
		num2=n;
		}
		
		else
			throw new IllegalArgumentException("El numero debe ser mayor que 0");
		
	}
	
	int getNum2()
	{
		return num2;
	}
}
