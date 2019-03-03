package C1Evaluacion;

import java.util.Scanner;

// Indicar el numero de positivos, negativos y ceros que se introduzcan.

public class Capitulo1_Valorpone0 
	{
		public static void main(String[] args) 
			{
			
			Scanner input=new Scanner(System.in);
			
			int cont,n1,n2,n3,n4,n5;
			cont=0;
			
			System.out.print ("Introduzca el primer valor: ");
			n1=input.nextInt();
			
			System.out.print ("Introduzca el segundo valor: ");
			n2=input.nextInt();
			
			System.out.print ("Introduzca el tercer valor: ");
			n3=input.nextInt();
			
			System.out.print ("Introduzca el cuarto valor:");
			n4=input.nextInt();
			
			System.out.print ("Introduzca el quinto valor: ");
			n5=input.nextInt();
			
			if (n1>0)
				cont=cont+1;
			
			if (n2>0)
				cont=cont+1;
			
			if (n3>0)
				cont=cont+1;
			
			if (n4>0)
				cont=cont+1;
			
			if (n5>0)
				cont=cont+1;
			
			System.out.printf("Se introdujeron %d numeros positivos",cont);
			System.out.println();
			cont=0;
			
			if (n1==0)
				cont=cont+1;
			
			if (n2==0)
				cont=cont+1;
			
			if (n3==0)
				cont=cont+1;
			
			if (n4==0)
				cont=cont+1;
			
			if (n5==0)
				cont=cont+1;
			
			System.out.printf("Se introdujeron %d ceros",cont);
			System.out.println();
			cont=0;
			
			
			if (n1<0)
				cont=cont+1;
			
			if (n2<0)
				cont=cont+1;
			
			if (n3<0)
				cont=cont+1;
			
			if (n4<0)
				cont=cont+1;
			
			if (n5<0)
				cont=cont+1;
			
			System.out.printf("Se introdujeron %d numeros negativos",cont);
			}
	}
