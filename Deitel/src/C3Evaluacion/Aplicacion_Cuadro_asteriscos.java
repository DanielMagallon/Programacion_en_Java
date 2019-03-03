package C3Evaluacion;

import java.util.Scanner;

public class Aplicacion_Cuadro_asteriscos 
{
	public static void main(String[] args) 
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print (" Dame el tamanio del cuadrado: ");
		int tamanio = lc.nextInt();
		
		for (int i = 1; i <= tamanio; i++)
		{
			for (int j = 1; j <= tamanio; j++)
			{
				if (j == 1 || j == tamanio || i == 1 || i == tamanio)
				{
					System.out.print ("* ");
				}
				else
				{
					System.out.print ("  ");
				}
			}
		System.out.println();
		}
		
	}
}
