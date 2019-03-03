package HelpClass;

public class Raizcuadrada 
{
	private static void log(String s)
	  {
	    System.out.println(s);
	  }
	  public static void main (String [] args)  
	  {
	    // sqrt(x) devuelve la raíz cuadrada.
	    for (int i=0; i < 10; i++) {
	      log("La raíz cuadrada de " + i + " es " + Math.sqrt(i));
	   }
	  }
}
