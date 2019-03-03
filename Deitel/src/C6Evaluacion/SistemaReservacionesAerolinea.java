package C6Evaluacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;


public class SistemaReservacionesAerolinea
{
	
	public static Calendar fechaHora = Calendar.getInstance();
	public static String nombres;
	public static boolean PC=false,CE=false;
	public static int clase;
	public static int asiento=0;
	public static	Scanner lc = new Scanner(System.in);
	public static	boolean [] asientos = new boolean [10];
	public static ArrayList< String > cadenas = new ArrayList<String>();
	
	public static void main(String[] args)
	{
		String decision1 = "Si";
		String aceptar;
		int cont=1;
		
		
	 while (PC==false || CE==false)		
	{
		
			System.out.printf ("%d.- Escriba su nombre: ",cont);
			nombres=lc.next();
			
			
		//	cadenas.add(nombres);
			cont++;
			
			if (PC==true)
			{
				
				System.out.println("\nLos lugares en la seccion de primera Clase se encuentran llenos.");
				System.out.print ("\nDesea ser colocado en la seccion Econmica?");
				aceptar=lc.next();
				
				if (aceptar.equalsIgnoreCase(decision1))
				{
					claseEconomica(nombres);
				}
				
				else
				{
					System.out.println("\nEl proximo vuelo sale en tres horas\n");
					
				}
			}
			
			
			else
				if (CE==true)
				{
						System.out.println("\nLos lugares en la seccion de Clase Economica se encuntran llenos.");
						System.out.print ("\nDesea ser colocado en la seccion de Primera Clase?");
						aceptar=lc.next();
						
						if (aceptar.equalsIgnoreCase(decision1))
						{
							clasePrincipal(nombres);
						}
						
						else
						{
							System.out.println("\nEl proximo vuelo sale en tres horas\n");
							
						}
				}
			
			
			else
				if (PC==false)
				{
				do
				{
			System.out.print ("\nPor favor escriba 1 para para la Primera Clase o 2 para Economico: ");
			clase=lc.nextInt();
				}
				while (clase != 1 && clase != 2);
			
			
			if (clase != 1 && clase != 2)
				System.out.println("\nNo existe esa clase. Intentelo de nuevo\n");
			
			else
				if (clase==1)
				{
					clasePrincipal(nombres);
				}
				
				else
					if (clase==2)
				{
					claseEconomica(nombres);
				}
			}
			
		if (PC==true && CE==true)
			System.out.println("Lo sentimos se han acabado los lugares en ambas secciones. Regrese pronto");
		
	}

	 	
	 
	}	
		
	public static void clasePrincipal (String nombres)
	{
		System.out.println("\nEntro a la Primera Clase\n");
		
		System.out.println ("Estan disponibles los siguientes asientos:\n");
		
		for (int i=0; i<5; i++)
		{
			if (asientos[i]==false)
				System.out.printf ("Asiento %d (Desocupado)\n",i + 1);
			
			else
				System.out.printf ("Asiento %d (Ocupado)\n",i + 1);
			
		}
		
		do
		{
		System.out.print ("\nEscoga el asiento que desee: ");
		asiento=lc.nextInt();
		
		
			if (asiento>5 || asiento<=0)
				System.out.println("\nNo existe ese asiento");
		}
		while (asiento>5 || asiento<=0 || asientos[asiento-1]==true);
		
		asientos[asiento-1]=true;
		
		System.out.println("\n");
		
		clase=1;
		
		if (asientos[0]==true && asientos[1]==true && asientos[2]==true && asientos[3]==true && asientos[4]==true)
			PC=true;
		
		imprimirPaseAbordo(clase,nombres,asiento);
		
		
	}
	
	public static void claseEconomica (String nombres)
	{
		System.out.println("\nEntro a la Clase Economica\n");
		
		System.out.println ("Estan disponibles los siguientes asientos:\n");
			
		for (int i=5; i<asientos.length; i++)
			{
				if (asientos[i]==false)
				System.out.printf ("Asiento %d (Desocupado)\n",i + 1);
			
				else
					System.out.printf ("Asiento %d (Ocupado)\n",i + 1);
			}
		
		do
		{
		System.out.print ("\nEscoga el asiento que desee: ");
		asiento=lc.nextInt();
		
				if (asiento<6 || asiento>10)
				System.out.println("\nNo existe ese asiento");
		}
		while (asiento<6 || asiento>10 || asientos[asiento-1]==true);
		asientos[asiento-1]=true;
		
		System.out.println("\n");
		
		clase=2;
		
		if (asientos[5]==true && asientos[6]==true && asientos[7]==true && asientos[8]==true && asientos[9]==true)
			CE=true;
		
		imprimirPaseAbordo(clase,nombres,asiento);
		
	}
	
	public static void imprimirPaseAbordo (int cl,String nom,int as)
	{
		
		String clases [] = new String [2];
		clases [0]="Primera Clase";
		clases [1]="Clase economica";
		
		Random lb = new Random();
		
		int numeroBoleto=lb.nextInt(10000) + 1;
		
	System.out.println("************************************************************************************");
	System.out.printf ("%50S\n","Pase de abordo ");
	System.out.println("************************************************************************************");
	
		System.out.printf (" Nombre de la Aerolinea: %s","AmericanArlines");  System.out.printf ("\tFecha: %tD\n",fechaHora);
		
     if (cl==1)
		{
    	 System.out.printf ("\n Clase: %s  ",clases[0]);	System.out.printf ("\t\t\t\tNumero de boleto: %d\n",numeroBoleto);
		}
			
		else
		{
		 System.out.printf ("\n Clase: %s  ",clases[1]);	System.out.printf ("\t\t\tNumero de boleto: %d\n",numeroBoleto);
		}
			
     	 System.out.printf ("\n Nombre del pasajero: %s  ",nom);	System.out.printf ("\t\t\tNumero de asiento: %d\n",as);
	
	System.out.println();
	System.out.println("************************************************************************************\n");
		
	}
}
