package C5Evaluacion;

import java.util.Scanner;

public class Metodos 
{
	public static Scanner input=new Scanner(System.in);
	
	
	public static void main(String[] args) 
	{
		Instrucciones();
		LeerLados ();
		System.out.println("\n");
		LeerMenor ();
		System.out.println("\n");
		leerEntero();
	}
	
	public static void Instrucciones ()
	{
		System.out.println(" Lea con atencion lo que se le pide a continuacion:  ");
		System.out.println();
	}
	
	public static void LeerLados ()
	{
		double lado1,lado2;
		
		System.out.print (" Introduzca el cateto a y el cateto b del trinagulo\n (Introduzca decimales, y separelos por espacios): ");
		lado1=input.nextDouble ();
		lado2=input.nextDouble ();
		
		double hip = hipotenusa (lado1,lado2);
		
		System.out.printf ("\n La hipotenusa del triangulo es de %f\n",hip);
	}
	
	public static double hipotenusa (double catetoa,double catetob)
	{
		double lado3  = Math.sqrt (Math.pow(catetoa, 2) + (Math.pow(catetob,2)));
		return lado3;
	
	}
	
	public static void LeerMenor ()
	{
		int n1,n2,n3;
		
		System.out.print (" Introduzca tres numeros enteros seprados por espacios: ");
		n1=input.nextInt ();
		n2=input.nextInt ();
		n3=input.nextInt ();
		
		int minum = menor (n1,n2,n3);
		
		System.out.printf (" El numero menor es: %d\n",minum);
	}
	
	public static int menor (int num1,int num2,int num3)
	{
		return Math.min (num1,Math.min (num2,num3));
	}
	
	public static void leerEntero ()
	{
		int num;
		
		System.out.print (" Introduce un valor de tipo entero: ");
		num=input.nextInt ();
		
		float flotante = intAFloat (num);
		
		System.out.printf (" El valor entero convertido a flotante es: %.1f\n",flotante);
	}
	
	public static float intAFloat (int entero)
	{
		float flot = entero;
		return flot;
	}
}
