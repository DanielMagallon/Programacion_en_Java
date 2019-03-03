package C2Evaluacion;

import java.util.Scanner;

public class FrecuenciasCardiacasP 
{

	public static void main(String[] args) 
	{
	
		FrecuenciasCardiacas lc = new FrecuenciasCardiacas("","", 0,0,0);
		FrecuenciasCardiacas lc1 = new FrecuenciasCardiacas("","",0,0,0);
		Scanner input = new Scanner(System.in);
		
		String n,ap;
		int d,m,an;
		
		System.out.println("PACIENTE 1");
		System.out.println("Nombre del paciente: ");
		n=input.nextLine();
		lc.Establecernombre(n);
		System.out.println();
		
		System.out.println("Apellido inicial del paciente: ");
		ap=input.nextLine();
		lc.Establecerapei(ap);
		System.out.println();
		
		System.out.println("Fecha de nacimiento (Introduzcala solo con numeros)");
		System.out.println("Dia: ");
		d=input.nextInt();
		lc.Establecerdia(d);
		System.out.println();
		
		System.out.println("Mes: ");
		m=input.nextInt();
		lc.Establecermes(m);
		System.out.println();
		
		System.out.println("Anio: ");
		an=input.nextInt();
		lc.Estableceranio(an);
		System.out.println();
		
		
		System.out.println("PACIENTE 2");
		System.out.println("Nombre del paciente: ");
		n=input.next();
		lc1.Establecernombre(n);
		System.out.println();
		
		System.out.println("Apellido inicial del paciente: ");
		ap=input.next();
		lc1.Establecerapei(ap);
		System.out.println();
		
		System.out.println("Fecha de nacimiento (Introduzcala solo con numeros)");
		System.out.println("Dia: ");
		d=input.nextInt();
		lc1.Establecerdia(d);
		System.out.println();
		
		System.out.println("Mes: ");
		m=input.nextInt();
		lc1.Establecermes(m);
		System.out.println();
		
		System.out.println("Anio: ");
		an=input.nextInt();
		lc1.Estableceranio(an);
		System.out.println();
		
		System.out.println("----------------------------------------------------");
		
		System.out.println("PACIENTE 1");
		System.out.println();
		System.out.printf ("Nombre: %s\n", lc.Obtenernombre());
		System.out.printf("Apellido: %s\n", lc.Obtenerapellido());
		System.out.print ("Fecha de naciemiento: ");
		lc.Mostrarfecha();
		System.out.println();
		System.out.printf ("Edad: %d\n",lc.Obteneredad());
		System.out.printf ("Frecuanecia Cardiaca Maxima: %d pulsos por minuto", lc.Obtenerfrecuenciacmx());
		System.out.println();
		System.out.printf ("Rango de Frecuencia cardiaca esperada entre %.0f y %.0f pulsos por minuto ",lc.Obtnerfrecesperada(),lc.Obtnerfrecesperada2());
		
		System.out.println();
		System.out.println();
		
		
		
		System.out.println("PACIENTE 2");
		System.out.println();
		System.out.printf ("Nombre: %s\n", lc1.Obtenernombre());
		System.out.printf("Apellido: %s\n", lc1.Obtenerapellido());
		System.out.print ("Fecha de naciemiento: ");
		lc1.Mostrarfecha();
		System.out.println();
		System.out.printf ("Edad: %d\n",lc1.Obteneredad());
		System.out.printf ("Frecuanecia Cardiaca Maxima: %d pulsos por minuto", lc1.Obtenerfrecuenciacmx());
		System.out.println();
		System.out.printf ("Rango de Frecuencia cardiaca esperada entre %.0f y %.0f pulsos por minuto ",lc1.Obtnerfrecesperada(),lc1.Obtnerfrecesperada2());
	}
	
}
