package C3Evaluacion;

public class elsesuelto 
{
	public static void main(String[] args) 
	{
		int x,y;
		x=33;
		y=11;
		
		System.out.println();
		System.out.println("--- if sin llaves 'x=9 y y=11'----");
		
			if (x < 10)
				if (y > 10)
					System.out.println ("******");
		
			else 
				System.out.println("#####");
				System.out.println("$$$$$");
				
		System.out.println();
		System.out.println("--- if con llaves----");
		
			if (x < 10)
				{
					if  (y > 10)
						System.out.println("*****");
				}
			
			else 
				{
					System.out.println("#####");
					System.out.println("$$$$$");
				}
			
			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println();
			System.out.println("--- if sin llaves 'x=11 y y=9'----");
			
			x=11;
			y=9;
			

			if (x < 10)
				if (y > 10)
					System.out.println ("******");
		
			else 
				System.out.println("#####");
				System.out.println("$$$$$");
				
				System.out.println();
				System.out.println("--- if con llaves----");
				
			if (x < 10)
				{
					if  (y > 10)
						System.out.println("*****");
				}
					
			else 
				{
					System.out.println("#####");
					System.out.println("$$$$$");
				}
	}
}
