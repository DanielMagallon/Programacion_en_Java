package C4Evaluacion;

import java.util.Scanner;

public class Examen_Calentamientoglobal 
{
	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
	
		int opcion,acu=0;
		
		System.out.println();
		System.out.println("\t\t   BIENVENIDO AL EXAMEN DEL CALENTAMINETO GLOBAL\n\t\tUSTED SERA EVALUADO CON LAS SIGUIENTES 5 PREGUNTAS");
		System.out.println();
		
		
		System.out.print ("Escriba por favor su nombre: ");
		String nombre = input.nextLine();
		
		System.out.println();
		System.out.printf (" %s%s%s%s%s%s"," 1.- ¿Que es el calentamiento global?\n","\n",
				"1)  Es el aumento observado en los últimos siglos de la atmosfera de la Tierra\n",
				"2)  Se refiere al aumento gradual de los océanos de la Tierra\n",
				"3)  El aumento de temperatura debido al calor que hay en la Tierra\n",
				"4)  Es el incremento continuo de la temperatura promedio global: específicamente la temperatura de la atmósfera y de los mares");
	
		System.out.println();
		
		do
		{
			System.out.println();
			System.out.print (" Elige una opcion: ");
			opcion=input.nextInt();
			
			if (opcion==4)
			{
				acu += 1;
			}
			
			else 
			{
				if (opcion>4 || opcion <1)
				{
					System.out.println();
					System.out.println(" No exista esa opcion. Vuelva a introducirla");
					System.out.println();
				}
			}
		}
		while (opcion<1 || opcion >4);
	
		System.out.println();
		System.out.printf (" %s%s%s%s%s%s"," 2.- ¿Cuales son algunas de las causas que provacan el calentamiento global?\n","\n",
				"1) Deforestacion,cultivo de arroz,hidrocarburos,produccion de basura.\n",
				"2) Radicacion solar,deforestacion,cultivo de trigo,metano.\n",
				"3) Cultivo de arroz,hidrocarburos,cultivo de trigo,deforestacion.\n",
				"4) Deforestacion,cultivo de trigo, hidrocarburos, produccion de basura.");
	
		System.out.println();
		
		do
		{
			System.out.println();
			System.out.print (" Elige una opcion: ");
			opcion=input.nextInt();
			
			if (opcion==1)
			{
				acu += 1;
			}
			
			else 
			{
				if (opcion>4 || opcion <1)
				{
					System.out.println();
					System.out.println(" No exista esa opcion. Vuelva a introducirla");
					System.out.println();
				}
			}
		}
		while (opcion<1 || opcion >4);
		
		System.out.println();
		System.out.printf (" %s%s%s%s%s%s"," 3.- ¿Que es el efecto invernadero?\n","\n",
				"1) Fenómeno en el que los gases retienen la energía emitida por el suelo.\n",
				"2) Decremento de la temperatura de la atmosfera terrestre.\n",
				"3) Subida de la temperatura de la atmósfera que se produce como resultado de la concentración en la atmósfera de gases,"
				+ " principalmente dióxido de carbono.\n",
				"4) Subida de la temperatura de la atmósfera que se produce como resultado de la energia solar.");
	
		System.out.println();
		
		do
		{
			System.out.println();
			System.out.print (" Elige una opcion: ");
			opcion=input.nextInt();
			
			if (opcion==3)
			{
				acu += 1;
			}
			
			else 
			{
				if (opcion>4 || opcion <1)
				{
					System.out.println();
					System.out.println(" No exista esa opcion. Vuelva a introducirla");
					System.out.println();
				}
			}
		}
		while (opcion<1 || opcion >4);
		
		System.out.println();
		System.out.printf (" %s%s%s%s%s%s"," 4.- ¿Quien tiene la mayor parte de la culpa por el calentamiento global? \n","\n",
				"1) El Gobierno.\n",
				"2) El Hombre.\n",
				"3) La Naturaleza.\n",
				"4) El Sol.");
	
		System.out.println();
		
		do
		{
			System.out.println();
			System.out.print (" Elige una opcion: ");
			opcion=input.nextInt();
			
			if (opcion==2)
			{
				acu += 1;
			}
			
			else 
			{
				if (opcion>4 || opcion <1)
				{
					System.out.println();
					System.out.println(" No exista esa opcion. Vuelva a introducirla");
					System.out.println();
				}
			}
		}
		while (opcion<1 || opcion >4);
		
		System.out.println();
		System.out.printf (" %s%s%s%s%s%s"," 5.- ¿Qué efectos tiene el calentamiento global sobre los glaciares?\n","\n",
				"1) Provoca grandes cambios en las condiciones climáticas y biológicas del planeta,"
					+ "al aumentar los niveles de la superficies de agua y reducir las áreas habitables.\n",
				"2) Reduce los niveles de la superficie del agua y aumenta las áreas habitables..\n",
				"3) Aumento de la temperatura atmosferica.\n",
				"4) Los hace agua.");
	
		System.out.println();
		

		do
		{
			System.out.println();
			System.out.print (" Elige una opcion: ");
			opcion=input.nextInt();
			
			if (opcion==1)
			{
				acu += 1;
			}
			
			else 
			{
				if (opcion>4 || opcion <1)
				{
					System.out.println();
					System.out.println(" No exista esa opcion. Vuelva a introducirla");
					System.out.println();
				}
			}
		}
		while (opcion<1 || opcion >4);
		
		switch (acu)
		{
		case 5:
			System.out.println();
			System.out.printf (" EXCELENTE¡¡ %s usted saco las 5 respuestas correctas.",nombre,acu);
			break;
		
		case 4:
			System.out.println();
			System.out.printf (" Muy Bien¡ %s usted saco %d respuestas correctas.",nombre,acu);
			break;
		
		default: 
		
			System.out.println();
			System.out.printf (" %S es tiempo de aprender mas sobre el calentamiento global¡\n"	+ "\n"
					+ " Tal vez quiera visitar la siguientes paginas para tener un mejor conocimineto sobre nuestro tema:\n" + "\n"
					+ " http://www.nationalgeographic.es/medio-ambiente/calentamiento-global/calentamiento-global-definicion\n"
					+ " https://es.wikipedia.org/wiki/Calentamiento_global\n"
					+ " http://www.ehowenespanol.com/10-causas-del-calentamiento-global",nombre);
			break;
		}
		
	}
}
