package C5Evaluacion;

import java.util.Random;
import java.util.Scanner;
 
public class Craps_Sueldo
{
	private static Random numberAleat = new Random();
	
	private static Random cadenasAleat = new Random();
	
	public static Scanner lc = new Scanner(System.in);
	
	private enum Estado {CONTINUA,GANO,PERDIO}
	
	private static final int DOS_UNOS = 2;
	private static final int  TRES = 3;
	private static final int  SIETE = 7;
	private static final int  ONCE = 11;
	private static final int  DOCE = 12;
	
	private static int sueldoBanco = 1000;
	private static int apuesta, miPunto = 0;;
	
	public static void main(String[] args)
	{
		
		Estado estadoJuego;

		System.out.printf (" Saldo Banco: %d fichas ",sueldoBanco);
		
		if (sueldoBanco==0)
		{
			System.out.println("\n Lo siento. Se quedos sin fondos¡");
			System.exit(0);
		}
		
		do
		{
			System.out.print ("\n Introduzca la cantidad a apostar: ");
			apuesta=lc.nextInt();
			
			System.out.println();
			
			if (apuesta<=sueldoBanco)
			{
				int sumaDeDados = tirarDados();
				
				switch (sumaDeDados)
				{
					case SIETE:
					case ONCE:
						estadoJuego = Estado.GANO;
						break;
						
					case DOS_UNOS:
					case TRES:
					case DOCE:
						estadoJuego = Estado.PERDIO;
						break;
						
					default:
						estadoJuego = Estado.CONTINUA;
						miPunto=sumaDeDados;
						System.out.printf ("El punto es: %d\n",miPunto);
						break;
				}
				
				while (estadoJuego == Estado.CONTINUA)
				{
					if (sumaDeDados==miPunto)
							estadoJuego=Estado.GANO;
					
					else 
						if (sumaDeDados== SIETE)
							estadoJuego=Estado.PERDIO;
				}
				
				if (estadoJuego == Estado.GANO)
				{
					System.out.println("EL jugador gana");
					System.out.printf ("\n Agregando %d fichas + %d de la apuesta",sueldoBanco,apuesta);
					sueldoBanco += apuesta; 
					System.out.printf ("\n Sueldo Banco: %d fichas ",sueldoBanco);
					System.out.println();
					NextApuesta();
					
				}
				else 
				{
					System.out.println("EL jugador pierde");
					System.out.printf ("\n Retirando %d fichas - %d de la apuesta",sueldoBanco,apuesta);
					sueldoBanco -= apuesta; 
					System.out.printf ("\n Sueldo Banco: %d fichas",sueldoBanco);
					System.out.println();
					NextApuesta ();
				}
			}

			else 
				if (apuesta>sueldoBanco)
				System.out.println(" No tiene las suficientes fichas para apostar\n Vuelva a introducir un valor");
		}
		while (apuesta>sueldoBanco);
		
}
	
	public static int tirarDados ()
	{
		int dado1 = 1 + numberAleat.nextInt(6);
		int dado2 = 1 + numberAleat.nextInt(6);
		
		int suma = dado1 +dado2;
		
		System.out.printf ("EL jugador tiro %d + %d = %d\n",dado1,dado2,suma);
		
		return suma;
	}
	
	public static void NextApuesta ()
	{
		Estado estadoJuego;
		
		if (sueldoBanco==0)
		{
			System.out.println("\n Lo siento. Se quedos sin fondos¡");
			System.exit(0);
		}
		
		generarCadenasAleatorias(sueldoBanco);
		
		do
		{
			System.out.print ("\n Introduzca la cantidad a apostar: ");
			apuesta=lc.nextInt();
			
			System.out.println();
			
			if (apuesta<=sueldoBanco)
			{
				int sumaDeDados = tirarDados();
				
				switch (sumaDeDados)
				{
					case SIETE:
					case ONCE:
						estadoJuego = Estado.GANO;
						break;
						
					case DOS_UNOS:
					case TRES:
					case DOCE:
						estadoJuego = Estado.PERDIO;
						break;
						
					default:
						estadoJuego = Estado.CONTINUA;
						miPunto=sumaDeDados;
						System.out.printf ("El punto es: %d\n",miPunto);
						break;
				}
				
				while (estadoJuego == Estado.CONTINUA)
				{
					if (sumaDeDados==miPunto)
							estadoJuego=Estado.GANO;
					
					else 
						if (sumaDeDados== SIETE)
							estadoJuego=Estado.PERDIO;
				}
				
				if (estadoJuego == Estado.GANO)
				{
					System.out.println("EL jugador gana");
					System.out.printf ("\n Agregando %d fichas + %d de la apuesta",sueldoBanco,apuesta);
					sueldoBanco += apuesta; 
					System.out.printf ("\n Sueldo Banco: %d fichas",sueldoBanco);
					System.out.println();
					NextApuesta();
					
				}
				else 
				{
					System.out.println("EL jugador pierde");
					System.out.printf ("\n Retirando %d fichas - %d de la apuesta",sueldoBanco,apuesta);
					sueldoBanco -= apuesta; 
					System.out.printf ("\n Sueldo Banco: %d fichas",sueldoBanco);
					System.out.println();
					NextApuesta ();
				}
			}

			else
				if (apuesta>sueldoBanco)
				System.out.println(" No tiene las suficientes fichas para apostar\n Vuelva a introducir un valor");
		}
		while (apuesta>sueldoBanco);
		
	}
	
	public static void generarCadenasAleatorias (int sueldoBanco )
	{
		int cadena = 1 + cadenasAleat.nextInt(4);
		
		if (sueldoBanco <=800)
		{
			switch (cadena)
			{
				case 1:
					System.out.println("\n Oh, se esta iendo a la quiebra verdad?¡");
					break;
					
				case 2:
					System.out.println("\n Oh, vamos arriesguese");
					break;
					
				case 3:
					System.out.println("\n Deberia retirarse. Le quedan pocas fichas¡¡");
					break;
					
				case 4:
					System.out.println("\n Esta seguro que desea continuar?¡");
					break;
			}
		}
		
		else 
			if (sueldoBanco >=10000)
			{
				switch (cadena)
				{
					case 1: 
						System.out.println("\n La hizo en grande.\n Ahora es tiempo de cambiar fichas por efectivo"); 
						break;
						
					case 2:
						System.out.println("\n Oh, vamos arriesguese");
						break;
						
					case 3:
						System.out.println("\n Lo esta haciendo muy bien. Siga asi¡");
						break;
						
					case 4:
						System.out.println("\n Son muchas fichas, deberia cambiarlas por efectivo¡");
						break;
				}
			}
	}
}
