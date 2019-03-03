package C5Evaluacion;

import java.io.IOException;
import java.util.Scanner;

// System.out.printf (" Triangulo\tCateto A\tCateto B\t Valor de la hipotenusa");
public class CalculoHipotenusa
{
	public static void main(String[] args) throws IOException
	{
		
		System.out.println(" Calcular la hipotenusa de acuerdo con la siguiente tabla: ");
		
		System.out.println("\n Triangulo\tCateto A\tCateo B\t    Valor de la hipotenusa");
		
		for (int triangulo=1; triangulo<=3;triangulo++)
		{
			if (triangulo==1)
			{
				double cateA=3.0,cateB=4.0;
				
				System.out.printf ("\n%6d%15.1f%16.1f%17.1f\n",triangulo,cateA,cateB,
						Math.sqrt(Math.pow(cateA, 2) + Math.pow(cateB, 2)));
			}
			
			if (triangulo==2)
			{
				double cateA=5.0,cateB=12.0;
				
				System.out.printf ("\n%6d%15.1f%16.1f%17.1f\n",triangulo,cateA,cateB,
						Math.sqrt(Math.pow(cateA, 2) + Math.pow(cateB, 2)));
			}
			
			if (triangulo==3)
			{
				double cateA=8.0,cateB=15.0;
				
				System.out.printf ("\n%6d%15.1f%16.1f%17.1f\n",triangulo,cateA,cateB,
						Math.sqrt(Math.pow(cateA, 2) + Math.pow(cateB, 2)));
			}
		}
		
		Scanner lc = new Scanner(System.in);
		
		double lado1,lado2; 
		char dec;
		
		System.out.println("\n------------------------------------------------------------\n");
		
	System.out.println("\n Calcular la hipotenusa de un triangulo dependiendo de los lados 1 y 2\n introducidos por el usuario");
		
	do
	{
		System.out.print ("\n Intrdozca el Cateto A del triangulo (en valor decimal): ");
		lado1=lc.nextDouble();
		
		System.out.print (" Introduzca el Cateto B del triangulo (en valor decimal): ");
		lado2=lc.nextDouble();
		
		System.out.printf ("\n El valor de la hipotenusa es de: %f\n",hipotenusa(lado1, lado2));
		
		System.out.println("\n Desea continuar con la ejecucion del porgrama?");
		dec = (char)System.in.read();
	}
	while (dec != 'N' && dec != 'n');
	}
	
	public static double hipotenusa (double lado1,double lado2)
	{
		return Math.hypot(lado1, lado2);
	}
}
