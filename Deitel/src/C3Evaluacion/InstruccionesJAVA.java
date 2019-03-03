package C3Evaluacion;

import java.util.Scanner;

public class InstruccionesJAVA 
{
	public static void main(String[] args) 
	{
		System.out.println("------Sumar 1 a x con 4 instrucciones diferentes------");
		
		/* Instrucciones:
		* 1.- x = x + 1;
		* 2.- x += 1;
		* 3.- x++;
		* 4.- ++x;
		*/
		
		int x;
		x=10;
		
		System.out.println(x);
		System.out.println(x=x+1); 	 // Instruccion 1
		
		System.out.println();
		
		x=10; 
		System.out.println(x); 
		System.out.println(x += 1); // Inruccion 2
		
		System.out.println();
		
		x=10;
		System.out.println(x);
		System.out.println(x++); // Inruccion 3
		System.out.println(x);
		
		System.out.println();
		
		x=10;
		System.out.println(x);
		System.out.println(++x); // Inruccion 4
		System.out.println(x);
		
		System.out.println("-------------------------------------------------------");
		
		System.out.println("----Incrementar - x - en 1, depsues de calcular la suma-----");
		
		/* Instruccion:
		 * z = x++ + y;
		 */
		
		int z,y;
		z=0;
		x=5;
		y=3;
		
		System.out.printf(" z = %d\n x = %d\n y = %d\n",z,x,y);
		System.out.println();
		System.out.println(" z = x + y");
		System.out.println(" x = x + 1");
		z=x++ + y;
		System.out.println();
		System.out.printf (" z = %d\n", z);
		System.out.printf (" x = %d\n",x);
		System.out.println();
		System.out.println("Resultado de la operacion despues de haberse incrementado x en +1");
		System.out.println();
		System.out.printf(" z = %d\n x = %d\n y = %d\n",z,x,y);
		System.out.println();
		System.out.println(" z = x + y");
		System.out.println(" x = x + 1");
		z=x++ + y;
		System.out.println();
		System.out.printf (" z = %d\n", z);
		System.out.printf (" x = %d\n",x);
		System.out.println();
		System.out.printf(" z = %d\n x = %d\n y = %d\n",z,x,y);
		System.out.println();
		System.out.println("-------------------------------------------------------");
		
		System.out.println("--Evlauar si la variable -cuenta- es mayor que 10, de ser asi, \nimprimir Cuenta es mayor que 10-- ");
		
		/* Instruccion:
		 * if (cuenta>10)
		 * 	System.out.println("Cuenta es mayor que 10");
		 */
		Scanner input=new Scanner(System.in);
		int cuenta;
		System.out.println();
		System.out.print ("Introduzca el numero de la cuenta: ");
		cuenta=input.nextInt();
		
		if (cuenta>10)
			System.out.println("Cuenta es mayor que 10");
		
		System.out.println();
		System.out.println("-------------------------------------------------------");
		
		System.out.println("--Usar una instruccion para decrementar la variable x en 1, luego restarla a la variable total\n y almacenar el resultado en la variable total--");
	
		/* 		Instruccion:
		 * 	 total -= --x;
		 */
		int total=50;
		x=20;
		
		System.out.printf (" x = %d\n", x);
		System.out.printf (" Total = %d\n ",total);
		System.out.println();
		System.out.println(" Total = Total - (x-1)");
		total -= --x;
		System.out.println();
		System.out.printf (" x = %d\n", x);
		System.out.printf (" Total = %d\n ",total);
		System.out.println();
		System.out.println("-------------------------------------------------------");
		
		System.out.println("--Calcular el residuo despues de dividir 'q' entre divisor y asignar\n el resultado a q--");
		
		/*
		 *	Isntruccion 1:
		 *		q %= divisor; 
		 *	Instruccion 2:
		 *		q = q % divisor;
		 *			
		 */
		
		int divisor,q;
		
		
		System.out.println("Introduzca un numero: ");
		q=input.nextInt();
		System.out.println("Introduzca su divisor: ");
		divisor=input.nextInt();
		System.out.println();
		System.out.printf ("El residuo de %d entre %d es igual a: %d",q,divisor,q %= divisor );
		System.out.println();
		System.out.println("-------------------------------------------------------");
		
		System.out.println("--Determinar el valor--");
		
		/*
		 * 		Instruccion:
		 * 	  producto *= x++; Variables de tipo int y valor en 5.
		 * 
		 */
		
		int producto = 5;
				   x = 5;
				   
				  
			System.out.printf (" Producto = %d\n x = %d\n", producto,x);
			System.out.println();
			System.out.printf (" %d = %d * (%d ++)\n",producto,producto,x);   
			System.out.printf (" El resultado es: %d\n", producto *= x++);
			System.out.printf (" Procduto = %d\n x = %d\n", producto,x);
			System.out.println();
			producto = 5;
			   x = 5;
			System.out.printf (" %d = %d * (++%d)\n",producto,producto,x);   
			System.out.printf (" El resultado es: %d\n", producto *= ++x);
			System.out.printf (" Procduto = %d\n x = %d\n", producto,x);
			
			
	}
}
