package HelpClass;

import java.util.Scanner;

public class SepararDigtos
{
	public static void main( String args[])
	   {
	      System.out.println("Programa que separa con 2 espacios los digitos de un: 0 < entero < 100000");
	  
	      Scanner input = new Scanner(System.in);
	  
	      int entero;
	  
	      System.out.print("Introduzca el numero entero: ");
	      entero = input.nextInt(); // Obtiene el numero ingresado por el usuario
	  
	      if ((entero >0) & (entero < 100000)) // Restringe el numero dentro del rango requerido
	         mostrarDigito(entero); // Llama al metodo mostrarDigito y le entrega el argumento entero
	      else
	         System.out.print("El numero no esta en el rango indicado");
	  
	      System.out.println();
	   } // Fin del metodo main
	 
	   public static void mostrarDigito(int dividendo) // Metodo para separar los digitos de un entero
	   {
	      int ceros = 0;
	 
	      for (int divisor=10000 ; divisor>=1 ; divisor/=10) // Itera el divisor desde 100000 hasta 1
	      {
	         int cociente = dividendo / divisor; // Obtiene la parte entera de la division
	      
	         while (ceros == 0) // Elimina los ceros a la izquierda del numero
	         {
	            if (cociente != 0)
	               ceros += 1;
	            else
	               break;
	         }
	   
	         if (ceros >0) // Condicion se cumple cuando no existan ceros a la izquierda
	         System.out.printf("%d  ",cociente); // Imprime el entero en esa posicion
	   
	         dividendo %= divisor; // Calcula el residuo entre estos 2 para entregar el nuevo dividendo
	      } // Fin de la iteracion
	   }// Fin del metodo mostrarDigito
}
