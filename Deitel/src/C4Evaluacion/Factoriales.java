package C4Evaluacion;

public class Factoriales 
{
	public static void main(String[] args) 
	{
		
		long factorial=1; 
	   
	  for (int num=1; num<=20;num++)
	  {
		for (int i=num; i>0; i--)
		{
			factorial *= i;	
		}
		System.out.printf (" El factorial de %d es %d\n",num,factorial);
		factorial = 1;
	  }
	  
	  
	}
}

