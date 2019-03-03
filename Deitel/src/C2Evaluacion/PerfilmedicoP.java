package C2Evaluacion;

import java.util.Scanner;

public class PerfilmedicoP 
{
	
	public static void main(String[] args) 
	{
	
		PerfilMedico pm = new PerfilMedico("","","",0,0,0,0,0);
		Scanner input = new Scanner (System.in);
		
		String n,ap,sx;
		int di,me,an;
		double al,pes;
		
		System.out.println ("Nombre de la persona: ");
		n=input.nextLine();
		pm.Establecernom(n);
		System.out.println();
		
		System.out.println ("Apellido de la persona: ");
		ap=input.nextLine();
		pm.Establecerapell(ap);
		System.out.println();
		
		System.out.println ("Sexo: ");
		sx=input.nextLine();
		pm.Establecersexo(sx);
		System.out.println();
		
		System.out.println ("Fecha de nacimiento (Solo introducir numeros)");
		System.out.println ("Dnia: ");
		di=input.nextInt();
		pm.Establecerdia(di);
		System.out.println ("Mes: ");
		me=input.nextInt();
		pm.Establcermes(me);
		System.out.println ("Anio: ");
		an=input.nextInt();
		pm.Estableceranio(an);
		System.out.println();
		
		System.out.println ("Introduzca su altura en centimetros: ");
		al=input.nextDouble();
		pm.Estableceraltura(al);
		System.out.println ("Introduzca su peso (en kg): ");
		pes=input.nextDouble();
		pm.Establecerpeso(pes);
		System.out.println();
		
		
		System.out.printf ("Nombre: %s ", pm.Obtenernom());
		System.out.println();
		System.out.printf ("Apellido: %s ", pm.Obtenerapell());
		System.out.println();
		System.out.printf ("Sexo: %s", pm.Obtenersexo());
		System.out.println();
		System.out.print ("Fecha de nacimiento: ");
		pm.Mostrarfecha();
		System.out.println();
		System.out.printf ("Altura: %.2f cm ", pm.Obteneraltura());
		System.out.println();
		System.out.printf ("Peso: %.2f kg ", pm.Obtenerpeso());
		System.out.println();
		System.out.printf ("Edad: %d", pm.Obteneredad());
		System.out.println();
		System.out.printf ("Masa Corporal (BMI): %.2f ", pm.Obtenermasacoroporal());
		System.out.println();
		System.out.printf ("Frecuencia Cardiaca Maxima: %d pulsos por minuto", pm.Obtenerfrecmax());
		System.out.println();
		System.out.printf ("Rango de la Frecuencia Esperada entre %.0f y %.0f pulsos por minuto", pm.Obtenerfrecespe(),pm.Obtenerfrecespe2());
		System.out.println("\n");
		pm.MostrarBMI();

	}
	
	
}
