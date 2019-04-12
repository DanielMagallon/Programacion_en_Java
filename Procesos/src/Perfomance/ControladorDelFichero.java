package Perfomance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ControladorDelFichero
{
   private PrintWriter fichero;

   public ControladorDelFichero()
   {
      // Aqui abrimos el fichero y lo dejamos listo
      // para escribir.
	   try {
		fichero = new PrintWriter(new File("eje.txt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   } 

   public synchronized void println(String cadena)
   {
       fichero.println(cadena);
       
   } 
   
   public static void main(String[] args) {
	
	   ControladorDelFichero control = new ControladorDelFichero();
	   // Hilo Cervantes
	   control.println("En un lugar de la Mancha ...");
	   // Hilo Shakespeare
	   control.println("... ser o no ser ...");
   }
}