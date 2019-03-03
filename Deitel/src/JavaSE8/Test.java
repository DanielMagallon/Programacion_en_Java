package JavaSE8;

public class Test
{
	
	public static void main(String[] args)
	{
		
		
		Operaciones sumar = (a,b) -> (a+b);
		Operaciones restar = (a,b) -> (a-b);
		
		System.out.printf("Suma: %d",sumar.makeCalculate(3, 4));
		System.out.printf("Resta %d",restar.makeCalculate(3, 4));
		
		
	}
	
	
}
