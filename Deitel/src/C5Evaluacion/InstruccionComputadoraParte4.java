package C5Evaluacion;

import java.util.Random;
import java.util.Scanner;

public class InstruccionComputadoraParte4
{
	public static Scanner lc = new Scanner(System.in);
	public static Random lb = new Random();
	public static int contadorCorrectas;
	public static int contadorIncorrectas;
	public static int cont=1;
	public static int nivel;
	public static boolean b;
	
	public static void main(String[] args)
	{
		System.out.println("\n El siguiente programa muestra las tablas de multiplicar.\n"
				+ " El usuario podra introducir el nivel que desse para reailzar\n las multplicaciones.\n");		
		
		elegirNivel();
		
	}
	
	public static void elegirNivel ()
	{
		
		System.out.println ("\n Niveles disponibles: ");
		System.out.println("\n 1) Nivel 1: Multiplicaciones de un digito.");
		System.out.println("\n 2) Nivel 2: Multiplicaciones de dos digitos");
		System.out.println("\n 3) Nivel 3: Multiplicaciones de tres digitos");
		System.out.println("\n 0) Salir del sistema");
		
		System.out.print ("\n Eliga la opcion o nivel que desee hacer: ");
		nivel=lc.nextInt();
		b=false;
		niveles(nivel);
		
		
	}
	
	public static void niveles (int nivel)
	{
		
		switch (nivel)
		{
			case 0:
				System.exit (0);
				break;
		
			case 1:
				if (b==false)
				{
				System.out.println("\n Ha entrado a las multiplicaciones de un digito");
				System.out.println(" Es momneto de empezar: ");
				b=true;
				}
				generarNumerosAleatorios1D();
				mostrarRespuestas();
				tryAgain();
				break;
				
			case 2:
				if (b==false)
				{
				System.out.println("\n Ha entrado a las multiplicaciones de dos digitos");
				System.out.println(" Es momneto de empezar: ");
				b=true;
				}
				generarNumerosAleatorios2D();
				mostrarRespuestas();
				tryAgain();
				break;
				
			case 3:
				if (b==false)
				{
				System.out.println("\n Ha entrado a las multiplicaciones de tres digitos");
				System.out.println(" Es momneto de empezar: ");
				b=true;
				}
				generarNumerosAleatorios3D();
				mostrarRespuestas();
				tryAgain();
				break;
		}
	}
	
	public static void generarNumerosAleatorios1D ()
	{
		int numero1 = 1 + lb.nextInt(9);
		int numero2 = 1 + lb.nextInt(9);

		int result;
		
		System.out.printf ("\n Cuanto es %d x %d?",numero1,numero2);
		System.out.print ("\n Escriba su resultado: ");
		result=lc.nextInt();
		
		if (result == (numero1*numero2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				niveles(nivel);
			}
		}
		
		else
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				niveles(nivel);
				
			}
		}
			
	}
	
	public static void generarNumerosAleatorios2D ()
	{
		int numero1 = lb.nextInt(99 - 10 +1)+10;
		int numero2 = lb.nextInt(99 - 10 +1)+10;

		int result;
		
		System.out.printf ("\n Cuanto es %d x %d?",numero1,numero2);
		System.out.print ("\n Escriba su resultado: ");
		result=lc.nextInt();
		
		if (result == (numero1*numero2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				niveles(nivel);
			}
		}
		
		else
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				niveles(nivel);
				
			}
		}
			
	}
	
	public static void generarNumerosAleatorios3D ()
	{
		int numero1 = lb.nextInt(999 - 100 +1)+100;
		int numero2 = lb.nextInt(999 - 100 +1)+100;

		int result;
		
		System.out.printf ("\n Cuanto es %d x %d?",numero1,numero2);
		System.out.print ("\n Escriba su resultado: ");
		result=lc.nextInt();
		
		if (result == (numero1*numero2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				niveles(nivel);
			}
		}
		
		else
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				niveles(nivel);
				
			}
		}
			
	}
	
	
	public static void mensajesAleatoriosCorrecto ()
	{
		int cadena = 1 + lb.nextInt(4);
		
		switch (cadena)
		{
			case 1:
				System.out.println("\n Muy Bien¡");
				break;
				
			case 2:
				System.out.println("\n Excelente¡");
				break;
				
			case 3:
				System.out.println("\n Buen Trabajo¡");
				break;
				
			case 4:
				System.out.println("\n Sigue asi¡");
				break;
		}
	}
	
	public static void tryAgain ()
	{
		char opc;
		
		System.out.print ("\n Falta alguien mas de hacer la prueba?");
		opc = lc.next().charAt(0);
		
		if (opc=='S' || opc == 's')
		{
			cont=1;
			contadorCorrectas=0;
			contadorIncorrectas=0;
			niveles(nivel);
		}
		else
		{
			cont=1;
			contadorCorrectas=0;
			contadorIncorrectas=0;
			elegirNivel();
		}
	}
	
	public static void mostrarRespuestas ()
	{
		if (contadorCorrectas>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectas);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectas);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
		}
		
		else 
			if (contadorCorrectas<=8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectas);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectas);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
			} 
	}
}
