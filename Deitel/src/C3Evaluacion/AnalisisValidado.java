package C3Evaluacion;

import java.util.Scanner;

public class AnalisisValidado 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

		int aprobados = 0;
		int reprobados = 0;
		int contEstudiantes = 1;
		int result;
		
		

		while (contEstudiantes <= 10) 
		{
	
			System.out.print("Escriba el resultado (1 = Aprobado, 2 = Reprobado):");
			result = input.nextInt();
	
			if (result == 1 || result == 2)
			{
				if (result == 1)
					aprobados += 1;
					
				if (result == 2)
					reprobados += 1;	
				
				contEstudiantes += 1;
			}
			else 
			{
				System.out.print("Escriba el resultado (1 = Aprobado, 2 = Reprobado):");
				result = input.nextInt();
				
				if (result == 1 || result == 2)
				{
					if (result == 1)
						aprobados += 1;
						
					if (result == 2)
						reprobados += 1;	
					
					contEstudiantes += 1;
				}
				
			}
		 }

		System.out.printf("Aprobados: %d\n Reprobados: %d\n", aprobados,reprobados);

		if (aprobados > 8)
			System.out.println("Bono para el instructor!");
			
	}
}
