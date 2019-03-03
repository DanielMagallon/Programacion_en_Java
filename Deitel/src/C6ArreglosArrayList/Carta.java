package C6ArreglosArrayList;

public class Carta
{
	private String cara; // cara de la carta: "As, Dos..."
	private String palo; // palo de la carata: "Corazones,diamantes"
	
	public Carta (String caraCarta, String paloCarta)
	{
		cara=caraCarta;
		palo=paloCarta;
	}
	
	public String toString ()
	{
		return cara + " de " + palo;
	}
}
