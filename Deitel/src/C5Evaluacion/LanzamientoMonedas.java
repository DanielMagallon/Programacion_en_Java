package C5Evaluacion;

import java.util.Random;
import java.util.Scanner;

public class LanzamientoMonedas
{
	private static final Random ran =  new Random();
	
	private enum Moneda {CARA, CRUZ}
	
	private static  int contadorCara;
	private static  int contadorCruz;
	
	public static void main(String[] args)
	{
		Instruccion();
	}

	public static void Instruccion ()
	{
		Scanner lc = new Scanner(System.in);
		char opc;
		
		Moneda estadoMoneda;
		
		System.out.println("\n Que desea hacer?");
		
		System.out.println("\n a) Lanzar moneda\n b) Salir del programa");
		
		System.out.print ("\n Eliga el inciso que desee: ");
		opc=lc.next().charAt(0);
		
		if (opc == 'a')
		{
			int mon = tirarMoneda();
			
				switch (mon)
				{
					case 1:
						estadoMoneda = Moneda.CARA;
						contadorCara++;
						break;
						
					case 0:
						estadoMoneda = Moneda.CRUZ;
						contadorCruz++;
						break;
				}
			
			System.out.printf ("\n Cara: %d\n",contadorCara);	
			System.out.printf ("\n Cruz: %d\n",contadorCruz);
			
			Instruccion();
		}
			else 
				if (opc == 'b')
					System.exit(0);
	}
	
	public static int tirarMoneda ()
	{
		int moneda = ran.nextInt(2);
		return moneda;
	}
	
}
