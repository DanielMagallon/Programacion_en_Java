package HelpClass;

import java.util.Scanner;

public class Variable_doble_otra 
{
	public static void main(String[] args) 
	{
		Scanner h = new Scanner(System.in);
		
		int mes=1;
		int sueldo,cont=0, ressueldoi,mess=0;
		
		System.out.print (" Introduzca su sueldo mensual: ");
		sueldo=h.nextInt ();
		ressueldoi=sueldo;
		
		System.out.println ("\tMes\tSueldo");
		
		
		while (mes<=12)
		{
			System.out.println("\t" + mes + "\t" + sueldo);
			mes++;
			sueldo += 100;
			if(sueldo==(ressueldoi*2))
				mess=mes;
		}
		System.out.println("Mes en el que el sueldo es el doble: " + mess);
	}
}
