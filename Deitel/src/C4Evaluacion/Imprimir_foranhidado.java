package C4Evaluacion;

public class Imprimir_foranhidado 
{
	public static void main(String[] args) 
	{
		for (int i = 1; i <= 10; i++)
		{
			for (int j = 1; j <=5; j++)
				System.out.print('@');
			
		System.out.println();
		}

		System.out.println();
		System.out.println("---------------");
		System.out.println();
		
		for (int i=1; i<=5; i++ )
		{
			for (int j=1; j<=3; j++)
			{
				for (int k=1; k<=4; k++)
					System.out.print ( '*' );
				System.out.println();
			}
			System.out.println();
		}
		
		String triangulo="";
		
		for (int i = 1; i <=10; i++)
		{
			triangulo = triangulo + "*";
			System.out.println(triangulo); 
		}
		
	}
}
