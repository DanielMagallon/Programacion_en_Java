package C3Evaluacion;

import java.util.Scanner;

public class Kilometrosgas 
{
		private int km,l;
	
	public Kilometrosgas (int kilom,int litros)
		{
			km = kilom;
			l = litros;
		}
	
	public void Establecerkm (int kilom)
		{
			km = kilom;
		}
	public int Obtenerkm ()
		{
			return km;
		}
	
	public void Establecerlitros (int litros)
		{
			l = litros;
		}
	public int Obtenerlitros ()
		{
		return l;
		}
	
	public void determinarKm ()
	{
		Scanner input=new Scanner(System.in);
		
		int k,li,cont=0;
		k=0;
		li=0;
		double promviaje=0,totalkm = 0,totallt=0,promkm=0,promlt=0;
		
	System.out.println("Intrduzca los km y litros recorridos por cada viaje.\nCuando haya terminado introduzca -1 para saber que ha\nacabado con su viaje");
		System.out.println();
		
		System.out.print ("Kilometros recorridos: ");
		k=input.nextInt();
		System.out.print ("Litros gastados: ");
		li=input.nextInt();
		
		while (k != -1 && li != -1)
			{
		
		totalkm += k;
		totallt += li;
		
		System.out.println();
		System.out.print ("Kilometros recorridos: ");
		k=input.nextInt();
		System.out.print ("Litros gastados: ");
		li=input.nextInt();
		
		cont += 1;
		
		promkm = totalkm/cont;
		promlt = totallt/cont;
		
		promviaje = totalkm/totallt;
			}
		System.out.println();
		System.out.printf (" Los kilometros recorridos fueron: %.2f\n",totalkm);
		System.out.printf (" Los litros gastados fueron: %.2f\n",totallt);
		System.out.println();
		System.out.printf (" Los kilometros recorridos por litro son: %.0fkm/%.0fl\n", promkm,promlt);
		System.out.printf (" El promedio de los kilometros por litro obtenidos es de: %.2fkm/l",promviaje);
	}
}
