package C4Evaluacion;

import java.util.Scanner;

public class Corregir_errores 
{
	public static void main(String[] args) 
	{
		// Corregir los siguientes errores:
		
		// a) For (i=100; i <= 1; i++)
		//	System.out.println (i);
				
				/* Error: El for esta con mayuscula, y la instruccion hace que el programa termine en cuanto se ejecute
				 * es decir, no hara nada. Ya que mientras i sea menor o igual que 1, el programa ira incrementando
				 * y mostrando el valor de i, en este caso fue inicializado con 100, asi que no hara nada 
				 */
		
		// Correcion: Se pone el for con minuscula.
		// 1.- Para que el programa ejecute algo se puede inicializar i con un numero negativo.
		// 2.- Poner en la condicion que que i sea menor o igual que un numero mayor que 100 (110,120,etc)
		
		for (int i=100; i <= 110; i++)
		System.out.println (i);
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		// b) El siguiente codigo debe imprimirse sin importar si el valor entero es impar o par
		
		/*
		 *	switch (value % 2)
		 *	{
		 *		case 0: System.out.println ("Entero par");
		 *	
		 *		case 1: System.out.println ("Entero impar");
		 *	} 
		 */
		
		// 
		
		
		Scanner lc = new Scanner(System.in);
		
		System.out.print ("Dame un numero: ");
	    int	value=lc.nextInt();
	    
	    switch (value % 2)
		 	{
		 		case 0: System.out.println ("Entero par");
		 		case 1: System.out.println ("Entero impar");
		 	} 
	    

		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		// c) El siguiente codigo debe imprimir los enteros impares del 19 al 1:
			
			/*
			 * for (i=19; i>=1; i +=2)
			 * System.out.println (i);
			 */
		
		// Correcion:
		
		/* El programa crearia un ciclo infinito, en el que ira sumando de dos en dos.
		 * Para corregir esto nomas hay que cambiar la condicion (i += 20), cambiar el singo de suma
 		 * por el de resta, ya que asi ira decrementando su valor de -2 en -2.
		 */
		
		for (int i=19; i>=1; i -= 2)
			System.out.println (i);
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		// d) El siguiente codigo debe imprimir los enteros pares del 2 al 100
		
			/* contador=2;
			 * do
			 * {
			 * 	System.out.println (contador);
			 * 	contador += 2;
			 * }
			 * while (contador < 100); 
			 */
		
		// Correcion:
		
		/* Cuando sea ejecutado el programa solo mostrara los numeros pares del 2 al 98;
		 * para corregir tal error se debe poner el operador <= en la condicion del while
		 * y tambien falta declarar la variable contador de tipo entero
		 */
		
		int contador=2;
			do
			 {
				System.out.println (contador);
				 contador += 2;
			}
			while (contador <= 100); 
			
		
	}
}
