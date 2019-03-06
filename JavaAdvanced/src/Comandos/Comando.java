package Comandos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Comando 
{
	
	static void crear(StringBuilder comando)
	{
		String s = null;

		try {
		// Ejcutamos el comando
			
		Process p = Runtime.getRuntime().exec(comando.toString());

		
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

		// Leemos la salida del comando y la desplegamos en el jTextArea
		while ((s = stdInput.readLine()) != null) {
		comando.append(s+"\n");
		}

		// Leemos los errores si los hubiera y la desplegamos en el jTextArea
		while ((s = stdError.readLine()) != null) {
		comando.append(s+"\n");
		}
		} catch (IOException e) {
		System.out.println("Excepción: ");
		e.printStackTrace();
		}  
			
		System.out.println("\n"+comando);
	}
	
	public static void main(String[] args) throws IOException 
	{
		
		long x = 10000;
		System.out.println(x*x);
//	    try 
//	    {
//	    	String cmd = "halt"; //Comando de apagado en linux
//	    	Runtime.getRuntime().exec(cmd);
//	    	
//	    } catch (IOException ioe) {
//	    	System.out.println (ioe);
//	    }
		
		StringBuilder comando;
		comando = new StringBuilder(
				
//				"mkdir nueva"//crea una carpeta en la ruta del proyecto
//				"git add Comandos"
				"git add /home/yeo/git_works/Programacion_en_Java/JavaAdvanced/src/Comandos/Comando.java\n"
//				"touch h.java"
				
				);
		crear(comando);
//		
//		
//		
		comando = new StringBuilder(
				
				"git commit -m \"com\" /home/yeo/git_works/Programacion_en_Java/JavaAdvanced/src/Comandos/Comando.java"
				
				);
		crear(comando);
//		
		 comando = new StringBuilder(
				
//				"git /home/yeo/git_works/Programacion_en_Java/JavaAdvanced/src/Comandos push -u origin master "
				
				);
		crear(comando);
//		
	}
}
