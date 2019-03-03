package C1Evaluacion;

// Imprimir 5 numeros, y determinar cual es el mayor, y cual el menor.

import java.util.Scanner;

public class Capitulo1_nummay_men 
	{
		public static void main(String[] args) 
			{
			
			Scanner input=new Scanner (System.in);
			
			int n1, n2, n3, n4, n5;
			
			System.out.print ("Introduce el primer numero: ");
			n1=input.nextInt ();
			
			System.out.print ("Introduce el segundo numero: ");
			n2=input.nextInt ();
			
			System.out.print ("Introduce el tercer numero: ");
			n3=input.nextInt ();
			
			System.out.print ("Introduce el cuarto numero: ");
			n4=input.nextInt ();
			
			System.out.print ("Introduce el quinto numero: ");
			n5=input.nextInt ();
			
			if (n1>n2)
				if (n1>n3)
					if (n1>n4)
						if (n1>n5)
			System.out.printf ("El numero mayor es: %d",n1);
				
			if (n2>n1)
				if (n2>n3)
					if (n2>n4)
						if (n2>n5)
			System.out.printf ("El numero mayor es: %d",n2);
				
			if (n3>n1)
				if (n3>n2)
					if (n3>n4)
						if (n3>n5)
			System.out.printf ("El numero mayor es: %d",n3);
				
			if (n4>n1)
				if (n4>n2)
					if (n4>n3)
						if (n4>n5)
			System.out.printf ("El numero mayor es: %d",n4);
				
			if (n5>n1)
				if (n5>n2)
					if (n5>n3)
						if (n5>n4)
			System.out.printf ("El numero mayor es: %d",n5);
			
			System.out.println();

			
			if (n1<n2)
				if (n1<n3)
					if (n1<n4)
						if (n1<n5)
			System.out.printf ("El numero menor es: %d",n1);
				
			if (n2<n1)
				if (n2<n3)
					if (n2<n4)
						if (n2<n5)
			System.out.printf ("El numero menor es: %d",n2);
				
			if (n3<n1)
				if (n3<n2)
					if (n3<n4)
						if (n3<n5)
			System.out.printf ("El numero menor es: %d",n3);
				
			if (n4<n1)
				if (n4<n2)
					if (n4<n3)
						if (n4<n5)
			System.out.printf ("El numero menor es: %d",n4);
				
			if (n5<n1)
				if (n5<n2)
					if (n5<n3)
						if (n5<n4)
			System.out.printf ("El numero menor es: %d",n5);
			
			
			
			
				
			}
	}	
