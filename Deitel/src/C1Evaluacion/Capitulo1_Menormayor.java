package C1Evaluacion;

// Suma, producto, promedio, y el numero mayor y menor de tres numeros.
import java.util.Scanner;

public class Capitulo1_Menormayor 
	{
		public static void main(String[] args) 
			{
			
			System.out.println(Math.PI);
			
			Scanner input=new Scanner (System.in);
			
			int num1, num2, num3,suma,prod,prom;
			
			System.out.print ("Introduzca el primer numero: ");
			num1=input.nextInt();
			
			System.out.print ("Introduzca el segundo numero: ");
			num2=input.nextInt();
			
			System.out.print ("Introduzca el tercer numero: ");
			num3=input.nextInt();
			
			suma = num1 + num2 + num3;
			prod = num1 * num2 * num3;
			prom = suma/3;
			
			System.out.printf("La suma de los tres numeros es igual a: %d\n", suma);
			System.out.printf("El producto de los tres numeros es igual a: %d\n", prod);
			System.out.printf("El promedio es de: %d\n", prom);
			
			if (num1>num2)
				if ( num1>num3)
				System.out.printf ("El numero mayor es: %d\n",num1);	
			
			if (num1<num2)
				if ( num1<num3)
				System.out.printf ("El numero menor es: %d\n" ,num1);	
			
			
			 if (num2>num1)
				if ( num1>num3)
				 System.out.printf ("El numero mayor es: %d\n",num2);
			  
			 if (num2<num1)
				 if (num1<num3)
				System.out.printf ("El numero menor es: %d\n" ,num2);
			
			 
			if (num3>num2)
				if ( num3>num1)
				System.out.printf ("El numero mayor es: %d\n" ,num3);
			
			if (num3<num2)
				if (num3<num1)
				System.out.printf ("El numero menor es: %d\n" ,num3);
			
			}
	}	
