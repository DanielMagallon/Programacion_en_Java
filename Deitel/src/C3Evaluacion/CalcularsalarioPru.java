package C3Evaluacion;

import java.util.Scanner;


public class CalcularsalarioPru 
	{
		public static void main(String[] args) 
			{
				Calcularsalario cs1 = new Calcularsalario ("Edgar",0,500);
				Calcularsalario cs2 = new Calcularsalario ("Jesus",0,200);
				Calcularsalario cs3 = new Calcularsalario ("Luis",0,1500);
				
				Scanner input = new Scanner(System.in);
				
				int horast,
				sal=0;
				System.out.printf (" Empleado 1: %s\n",cs1.Obteneremp());
				System.out.print  (" Horas trabajadas durante la semana pasada: ");
				horast=input.nextInt();
				cs1.Establecerhours(horast);
				System.out.printf (" Tarifa del empleado 1: $%d\n",cs1.Obtenertarif());
				cs1.determinarTarifatotal(sal);
				
				System.out.println();
				
				System.out.printf (" Empleado 2: %s\n",cs2.Obteneremp());
				System.out.print  (" Horas trabajadas durante la semana pasada: ");
				horast=input.nextInt();
				cs2.Establecerhours(horast);
				System.out.printf (" Tarifa del empleado 1: $%d\n",cs2.Obtenertarif());
				cs2.determinarTarifatotal(sal);

				System.out.println();
				
				System.out.printf (" Empleado 3: %s\n",cs3.Obteneremp());
				System.out.print  (" Horas trabajadas durante la semana pasada: ");
				horast=input.nextInt();
				cs3.Establecerhours(horast);
				System.out.printf (" Tarifa del empleado 1: $%d\n",cs3.Obtenertarif());
				cs3.determinarTarifatotal(sal);
				
			}
		
	}
