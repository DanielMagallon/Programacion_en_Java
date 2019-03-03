package C6Evaluacion;

import java.util.Random;

public class TirarDadoFrecuenciaSumas
{
	public static void main(String[] args)
	{
			Random lb = new Random();
			
			int [] frecuencia = new int [13];
			
			
		for (int tiro=1; tiro<=36000000; tiro++)
			++ frecuencia[(lb.nextInt(6)+1)  + (lb.nextInt(6)+1)];
			
		
		System.out.printf ("%s%12s%n%n","Suma","Frecuencia");
		
		for (int suma=2; suma<frecuencia.length; suma++)
			System.out.printf ("%4d %10d\n",suma,frecuencia[suma]);
	}
}
