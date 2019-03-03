package C2Evaluacion;

import java.util.Scanner;

public class FechaP 
{

	public static void main(String[] args) 
	{
	
		Fecha lc=new Fecha (0,0,0);
		lc.Mostrarfecha();
	    System.out.println();
		
	    System.out.println("----------------------------------");
	    
		Fecha lc1=new Fecha (0,0,0);
		Scanner input=new Scanner(System.in);
		
		int dia, mes, anio;
		System.out.println ("Introduzca el dia: ");
		dia=input.nextInt();
		lc1.Establecerdia(dia);
		System.out.println();
		
		System.out.println ("Introduzca el mes: ");
		mes=input.nextInt();
		lc1.Establecermes(mes);
		System.out.println();
		
		System.out.println ("Introduzca el anio: ");
		anio=input.nextInt();
		lc1.Estableceranio(anio);
		System.out.println();
		lc1.Mostrarfecha();
	}
	
}
