package ClaseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReader
{
		  public static void main(String args[]) throws IOException
		  {

			  int ncd =0;
              String micd=null;
              BufferedReader entrada = new BufferedReader(
                         new InputStreamReader(System.in));
              System.out.println("Ingrese una cadena de caracteres ;"+
                         "Termina Crtl+Z");
              
              System.out.flush();
              
              do{
                         micd=null;
                         micd= entrada.readLine();
                         
                         if(micd !=null)
                         {
                                     ncd++;
                                     System.out.println(micd);
                         }
              }
              while (micd !=null);
              
              System.out.println("\nNumero de Lineas :"+ncd);
		  }
}
