package C4InstruccionControl2;

public class Ejemplos_usodel_for 
{
	public static void main(String[] args) 
	{
		System.out.println(" a) Modificar la variable de control de 1 a 100 en incrementos de 1");
			for (int i = 1; i <= 100; i++)
				System.out.printf (" %d ",i);
			
		System.out.println();
		System.out.println();	
		
		System.out.println(" b) Modificar la variable de control de 100 a 1 en decrementos de 1");
			for (int i = 100; i >= 1; i--)
				System.out.printf (" %d ",i);
			
		System.out.println();
		System.out.println();
			
		System.out.println(" c) Modificar la variable de control de 7 a 77 en incrementos de 7");
			for (int i = 7; i <= 77; i += 7)
				System.out.printf (" %d ",i);
			
		System.out.println();
		System.out.println();	
		
		System.out.println(" d) Modificar la variable de control de 20 a 2 en decrementos de 2");
			for (int i = 20; i >= 2; i -= 2)
				System.out.printf (" %d ",i);
			
		System.out.println();
		System.out.println();
			
		System.out.println(" e) Modificar la variable de control con la siguiente secuencia de valores:2,5,8,11,14,17,20.");
			for  (int i = 2; i <= 20; i  += 3 )
				System.out.printf (" %d ",i);
		 
		 System.out.println();
		 System.out.println();
		 
		 System.out.println(" f) Modificar la variable de control con la siguiente secuencia de valores: 99, 88, 77, 66,\n 55, 44, 33 2 2 , 1 1 , 0 ");
		 	for (int i = 99; i >= 0 ; i -= 11 )
		 		System.out.printf (" %d",i);
	}
}

