package Recursividad;

import java.util.Scanner;

public class BajarEscalera 
{
	public static void main(String[] args) 
	{
		/*
		 * Recursividad: Metodos que se llaman a si mismo
		 */
		
		Scanner lc = new Scanner(System.in);
		
		System.out.print ("En que escalon se encuentra? ");
		int esc=lc.nextInt();
		
		System.out.println();
		
		bajarEscalera(esc);
		
	}
	
	static void bajarEscalera(int escalones)
	{
		if (escalones==0) // Caso base, respuesta explicita
		{
			System.out.println("Ha terminado de bajar la escalera");
		}
		
		else // Dominio: division del problema original en (problema-1)
		{
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.printf ("Bajando Escalón: %d\n",escalones);
			bajarEscalera(escalones-1);
		}
	}
}
