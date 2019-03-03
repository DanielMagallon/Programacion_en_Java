package C6ArreglosArrayList;

public class PruebaPaqueteDeCartas
{
	public static void main(String[] args)
	{
		PaqueteDeCartas mipaquetecartas = new PaqueteDeCartas();
		
		mipaquetecartas.barajar(); // coloca las cartas en orden aleatorio
		
		// imprime las 52 cartas en el orden que se reparten
		
		for (int i=1; i<=52; i++)
		{
			// reparte e imprime una carta
		
			System.out.printf ( "%-19s",mipaquetecartas.repartirCarta());
			
			if (i%4==0)
				System.out.println();
		}
	}
}
