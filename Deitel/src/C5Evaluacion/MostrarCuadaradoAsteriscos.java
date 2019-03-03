package C5Evaluacion;

import java.io.IOException;
import java.util.Scanner;

public class MostrarCuadaradoAsteriscos
{
	public static void main(String[] args) throws IOException
	{
		System.out.println(" Este programa imprime un cuadro de asteriscos.\n"
				+ " El tamaño depende del valor introducido por el usuario.");
		
		Scanner lc = new Scanner(System.in);
		
		int lado;
		char conti;
		
		do
		{
		System.out.print ("\n Introduzca el lado del cuadrado: ");
		lado=lc.nextInt();
		
		System.out.println();
		
		cuadradoAsteriscos(lado);
		
		System.out.println("\n Volver a ejecutar? ");
		conti = (char)System.in.read ();
		}
		
		while (conti != 'N' && conti != 'n');
	}
	
	public static void cuadradoAsteriscos (int lado)
	{
		for (int renglon=1;renglon<=lado;renglon++)
		{
			for (int vertical=1;vertical<=lado;vertical++)
				System.out.print ("* ");

			System.out.println();
		}
	}
}
