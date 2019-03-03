package HelpClass;

import java.util.Random;

public class IndexOf
{
	public static void main(String[] args)
	{
		String cadena = "Codigo Fuente en Java";
	    int index = cadena.indexOf("Java"); 
	    System.out.println(index);
	    
	    cadena = "Codigo Fuente en Java y aca aparece otra vez Java";
	    index = cadena.indexOf("Java"); 
	    System.out.println(index);
	    index = cadena.indexOf("Java",index+1); 
	    System.out.println(index); // imprime segunda aparicion de Java
	    
	      String Str = new String("Welcome to Tutorialspoint.com");
	      String SubStr1 = new String("Tutorials");
	      String SubStr2 = new String("Sutorials");

	      System.out.print("Found Index :" );
	      System.out.println(Str.indexOf( 'o' ));
	      System.out.print("Found Index :" );
	      System.out.println(Str.indexOf( 'o', 5 ));
	      System.out.print("Found Index :" );
	      System.out.println( Str.indexOf( SubStr1 ));
	      System.out.print("Found Index :" );
	      System.out.println( Str.indexOf( SubStr1, 15 ));
	      System.out.print("Found Index :" );
	      System.out.println(Str.indexOf( SubStr2 ));
	      
	
	      
	}
}
