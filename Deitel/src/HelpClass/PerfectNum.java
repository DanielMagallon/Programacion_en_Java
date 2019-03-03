package HelpClass;

import java.util.Scanner;

public class PerfectNum
{
	public static void main(String[] args)
	{
		 Scanner entrada = new Scanner(System.in);
		 int numero;
		 

		 System.out.println("\nEste programa imprime los numeros perfectos entre");
		 System.out.println(" 1 y un numero dado. ");

		 do
		 {         // Abre do
		 System.out.println("\nPor favor introduzca un entero positivo: ");
		 numero = entrada.nextInt();
		 } while ( 0 > numero );      // Cierra do

		 Perfecto(numero);
	}
	
	public static void Perfecto( int N )

	 /* El metodo Perfecto recibe el limite superior
	    es decir el numero hasta el que debe buscar perfectos.
	    */
	 {           // Abre metodo perfecto
	 
	 int cuenta = 0; 

	 // La variable cuenta se utiliza para ir sumando los factores
	 // del numero j, al final se verifica la condicion de que esa
	 // suma sea igual al numero j. Si es asi, solo si es asi, se
	 // manda a imprimir el numero. Esto porque de otra manera se
	 // tendria que ir almacenando cada vez los factores, pero no 
	 // se tiene a priori el numero, asi que no se sabe cuantas 
	 // variables hay que declarar. Por lo tanto he decidido 
	 // usar otro metodo para imprimir el numero que resulte perfecto.
	 

	 for ( int j = 1; j <= N; j++ ) 
	 {       // Abre for

	 cuenta = 0;
	 // La variable cuenta se debe poner en cero cada vez que se 
	 // analiza otro numero.
	  
	 for ( int i = 1; i <= j/2 ; i++ ) 

	 // Solo hay que buscar los factores hasta j/2, porque despues
	 // de ese numero ya no hay mas. 
	 
	 if( 0 == j % i )
	 cuenta += i; 

	 // Si la variable i es un  factor, se suma
	 
	 if ( cuenta == j )
	 // Si la suma de los factores es igual al numero, entonces
	 
	 {      // ABre if
	 Imprime(j);
	  // se imprime
	 }  // Cierra if
	 }      // Cierra for
	 }           // Cierra metodo perfecto


	 //////////////////////////////////////
	 //METODO IMPRIME
	 //////////////////////////////////////
	   
	 public static void Imprime( int x )
	 
	 // Esta funcion primero imprime el numero 
	 {           // Abre Imprime
	  
	 System.out.printf("%d = ", x);
	  
	 for ( int s = 1; s <= x/2; s++ )
	 {     // Abre for
	 if ( 0 == x%s )
	 System.out.printf("\t%3d", s);
	 // y despues imprime los factores
	 }     // Cierra for

	 System.out.println("\n");

	 }           // Cierra Imprime     
	 
}
