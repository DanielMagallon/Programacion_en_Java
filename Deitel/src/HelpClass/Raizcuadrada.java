package HelpClass;

public class Raizcuadrada 
{
	private static void log(String s)
	  {
	    System.out.println(s);
	  }
	  public static void main (String [] args)  
	  {
	    // sqrt(x) devuelve la ra�z cuadrada.
	    for (int i=0; i < 10; i++) {
	      log("La ra�z cuadrada de " + i + " es " + Math.sqrt(i));
	   }
	  }
}
