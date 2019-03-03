package C5Metodos;

import java.util.Random;

public class Craps 
{

	// crea un generador de numeros aleatorios para usarlo en el metodo tirarDado.
	private static final Random numerosAleatorios =  new Random ();
	
	// enumeracion con constantes que representan el estado del juego
	private enum Estado {CONTINUA, GANO, PERDIO};
	
	// constante que representan tiros comunes del dado 
	private static final int DOS_UNOS = 2;
	private static final int   TRES = 3;
	private static final int  SIETE = 7;
	private static final int   ONCE = 11;
	private static final int   DOCE = 12;
	// ejecuta un juego de de Craps
	
	public static void main(String[] args) 
	{
		int miPunto=0; // punto si no gana o pierde en el primer tiro
		Estado estadoJuego; // puede contener CONTINUA, GANO, PERDIO
		
		int sumaDeDados=tirarDados();
		
		//determina el estado del juego y el punto con base en el primer tiro
		switch (sumaDeDados)
		{
			case SIETE: // gana con 7 en el primer tiro
			case ONCE: // gana con 11 en el primer tiro
				estadoJuego = Estado.GANO;
				break;
				
			case DOS_UNOS:
			case TRES:
			case DOCE:
				estadoJuego = Estado.PERDIO;
				break;
				
			default:
				estadoJuego = Estado.CONTINUA;
				miPunto = sumaDeDados;
				System.out.printf ("El punto es: %d\n",miPunto);
				break;
		}
		
		// mientras el juego no este terminado
		while (estadoJuego == Estado.CONTINUA)
		{
			
			// determina el estado del juego
			if (sumaDeDados == miPunto) // gana haciendo un punto
				estadoJuego = Estado.GANO;
			
			else 
				if (sumaDeDados == SIETE) // pierde al tirar 7 antes del punto
					estadoJuego = Estado.PERDIO;
		}
		
		// muestra el mensaje de que gano o perdio
		if (estadoJuego == Estado.GANO)
			System.out.println("EL jugador gana");
		
		else 
			System.out.println("EL jugador pierde");
	}
		
		
		// tira los dados, calculala suma y muestra los resultados
			public static int tirarDados()	
			{
				// elige los valores aleatorios para los dados
				int dado1 = 1 + numerosAleatorios.nextInt(6); // primer tiro del dado
				int dado2 = 1 + numerosAleatorios.nextInt(6); // segundo tiro de dado
				
				int suma =  dado1 + dado2;
				
				// muestra los result de ese tiro
				System.out.printf ("EL jugador tiro %d + %d = %d\n",dado1,dado2,suma);
				
				return suma;
			}
}
