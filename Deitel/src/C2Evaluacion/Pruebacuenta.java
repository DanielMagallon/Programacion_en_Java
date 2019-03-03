package C2Evaluacion;

import java.util.Scanner;

public class Pruebacuenta 
	{

			public static void main(String[] args) 
			
				{
				
				Cuenta cuenta1 = new Cuenta(500.00);
				Cuenta cuenta2 = new Cuenta(100.00);
			
			System.out.printf ("Saldo de cuenta 1: $%.1f\n", cuenta1.Obtenersaldo());
			System.out.printf ("Saldo de cuenta 2: $%.1f\n", cuenta2.Obtenersaldo());	
			
					Scanner lc = new Scanner(System.in);
			
				double retirocar;
				
				System.out.println("Escriba el cargo a retirar en cuenta1: ");
				retirocar=lc.nextDouble();
				System.out.println();
				if (retirocar>cuenta1.Obtenersaldo())
					{
					
					cuenta1.cargar(retirocar);
					System.out.println();
					
					}
				
				if (retirocar<=cuenta1.Obtenersaldo())
					{
				
				System.out.printf("\nRetirando %.1f al saldo de la cuenta1\n\n", retirocar);
				cuenta1.cargar(retirocar);
				
					}
				
				System.out.printf("Saldo de cuenta1: $%.1f\n", cuenta1.Obtenersaldo());
				System.out.printf("Saldo de cuenta2: $%.1f\n", cuenta2.Obtenersaldo());
				System.out.println();
				

				System.out.println("Escriba el cargo a retirar en cuenta2: ");
				retirocar=lc.nextDouble();
				System.out.println();
				if (retirocar>cuenta2.Obtenersaldo())
					{
					
					cuenta2.cargar(retirocar);
					System.out.println();
					
					}
				
				if (retirocar<=cuenta2.Obtenersaldo())
				{
				System.out.printf("\nRetirando %.1f al saldo de la cuenta2\n\n", retirocar);
				cuenta2.cargar(retirocar);
				System.out.println();
				}
				
				System.out.printf("Saldo de cuenta1: $%.1f\n", cuenta1.Obtenersaldo());
				System.out.printf("Saldo de cuenta2: $%.1f\n", cuenta2.Obtenersaldo());
				
				}
	
	}
