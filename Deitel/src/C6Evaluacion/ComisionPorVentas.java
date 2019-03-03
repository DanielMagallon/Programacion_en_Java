package C6Evaluacion;

import java.util.Scanner;

public class ComisionPorVentas
{
	public static int [] saldos; 
	
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		int trabajadores;
		
		
		System.out.print ("Introduzca el numero de trabajadores en la compañia: ");
		trabajadores=lc.nextInt();
		
		final int [] VENDEDORES = new int [trabajadores];
		int [] venta = new int [trabajadores];
		saldos = new int [trabajadores];
		
		for (int i=0; i<VENDEDORES.length; i++)
		{
			do
			{
			System.out.printf ("\nIntroduzca el total de ventas vendidas por el trabajador %d: ",i+1);
			venta[i] =lc.nextInt();
			
				if (venta[i] >=10000)
					System.out.println("\nEL total de ventas introdudcidas excede el limite de lo que se puede vender"
							+ "\nIntroducelo de nuevo.");
			}
			while (venta[i] >=10000);
		}
		
		System.out.println();
		
		for (int i=0; i<VENDEDORES.length; i++)
		{
			saldos[i] =  determinarSaldo(venta[i],venta);
			
			System.out.printf ("El pago para el trabajador %d sera de %d\n",i+1,saldos[i]);
		}
		
		/*System.out.println("\nLos saldos son: ");
			
		for (int i=0; i<VENDEDORES.length; i++)
		{
			System.out.println(saldos[i]);
		}*/
		
		imprimirGraficoDeBarras();
		
	}
	
	public static int determinarSaldo (int dinero,int [] v)
	{
		double nuevoSaldo  = (double) (200 + (0.09 * dinero )); 
		
		return (int)nuevoSaldo;
		
	}
	
	public static void imprimirGraficoDeBarras ()
	{
		System.out.println("\nDistribucion de las ventas de cada vendedor:\n");
		
		int [] frecuencia = new int [11];
		
		for (int Dinero : saldos)
			++frecuencia[Dinero/100];
		
		for (int cuenta=2; cuenta < frecuencia.length; cuenta++)
		{
			if (cuenta>=10)
				System.out.printf ("Mayor $%d: ",1000);
			
			else
				System.out.printf ("$%2d-%2d: ",
						cuenta*100, cuenta * 100 + 99);
			
			for(int estrellas=0; estrellas < frecuencia[cuenta]; estrellas++)
				System.out.print ( "*" );
		
			System.out.println();
		}
		
	}
}
