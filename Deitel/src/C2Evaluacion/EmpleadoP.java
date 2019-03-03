package C2Evaluacion;

import java.util.Scanner;

public class EmpleadoP 
{
	
	public static void main(String[] args) 
	{
	
		Scanner input = new Scanner(System.in);
		Empleado lc1 = new Empleado("","",0);
		Empleado lc2 = new Empleado ("","",0);
		
		String nom,apell;
		double salario;
		
		System.out.println ("Nombre del empleado1: ");
		nom=input.nextLine();
		lc1.Establecernombre(nom);
		System.out.println();
		
		System.out.println("Apellido del empleado1: ");
		apell=input.nextLine();
		lc1.Establecerapellido(apell);
		System.out.println();
		
		System.out.println("Salario mensual del empleado1: ");
		salario=input.nextDouble();
		lc1.Establecersalario(salario);
		
		
		System.out.printf ("Nombre: %s\n", lc1.Obtenernombre());
		System.out.printf ("Apellido: %s\n", lc1.Obtenerapellido());
		System.out.printf ("Salario mensual: %.2f\n",lc1.Obtenersalario());
		System.out.printf ("Salario anual: %.2f\n",lc1.Obtenersalarioanual());
		System.out.printf ("Salario anual del empleado incrementado en 10xciento: %.2f\n", lc1.Obtenersalarioanualinc());
		
		System.out.println("-----------------------------------------------------------");
		
		System.out.println(); 
		System.out.println ("Nombre del empleado2: ");
		nom=input.next();
		lc2.Establecernombre(nom);
		System.out.println();
		
		System.out.println("Apellido del empleado2: ");
		apell=input.next();
		lc2.Establecerapellido(apell);
		System.out.println();
		
		System.out.println("Salario mensual del empleado2: ");
		salario=input.nextDouble();
		lc2.Establecersalario(salario);
		
		
		System.out.printf ("Nombre: %s\n", lc2.Obtenernombre());
		System.out.printf ("Apellido: %s\n", lc2.Obtenerapellido());
		System.out.printf ("Salario mensual: %.2f\n",lc2.Obtenersalario());
		System.out.printf ("Salario anual: %.2f\n",lc2.Obtenersalarioanual());
		System.out.printf ("Salario anual del empleado incrementado en 10xciento: %.2f\n", lc2.Obtenersalarioanualinc());
	}
	
	
	
}
