package C6ArreglosArrayList;

// La clase PaqueteDeCartas representa un paquete de cartas en el juego

import java.util.Random;

public class PaqueteDeCartas
{
	private Carta[] paquete; // arreglo de objetos carta
	private int cartaActual; // subindice de la siguiente carta a repartir (0 a 51)
	private static final int NUMERO_DE_CARTAS=52;
	
	private static final Random lb = new Random();
	
	// el contructor llena el paquete de cartas
	
	public PaqueteDeCartas ()
	{
		String [] caras = { "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", 
				            "Siete", "Ocho", "Nueve", "Diez", "Joto", "Quina", "Rey" };
		
		String [] palos = { "Corazones", "Diamantes", "Trebloes", "Espadas" };
		
		paquete = new Carta [NUMERO_DE_CARTAS]; // crea arreglo de obetos carta
		
		cartaActual=0; // establece carta actual, para que la primera Carta repartida sea paquete [0]
		
		
		// lena el paquete con objetos Carta
		for (int cuenta = 0; cuenta < paquete.length; cuenta++)
			paquete [cuenta] = new Carta (caras [cuenta%13], palos [cuenta/13]);
	}
	
	// baraja el paquete cartas con el algoritmo de una pasada
	
	public void barajar ()
	{
		
		// despues de barajar, la reparticion debe empezar en paquete [0] otra vez
		cartaActual=0; // reinicializa cartaActual
		
		// para cada carta, seleccciona otra carta aleatoria  (0-51) y las intercambia
		
		for (int primera = 0; primera < paquete.length; primera++)
		{
			
			// selecciona un numero aleatorio entre 0 y 51
			int segunda = lb.nextInt(NUMERO_DE_CARTAS);
			
			// intercambia Cartaactual con la carta seleccionada al azar
			
			Carta temp = paquete [primera];
			paquete [primera] = paquete [segunda];
			paquete [segunda] = temp;
		}
		
	}
	
	// reparte una carta
	
	public Carta repartirCarta ()
	{
		// determina si quedan cartas por repartir
		if (cartaActual < paquete.length)
			return paquete [cartaActual++]; // devuelve la carta actual en el arreglo
		
		else
			return null; // devuelve null, para indicar que se repartieron todas las cartas
	}
	
	
}
