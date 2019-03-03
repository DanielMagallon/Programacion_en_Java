package C5Evaluacion;

import java.util.Scanner;

public class SeparacionDigitos
{
	public static int cifras;
	
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		char car;
		
		System.out.println(" A continuacion se presenta un ejemplo, que\n servira de ayuda"
				+ " para poder separar el entero introducido por el usuario: ");
		
		do
		{
		System.out.print ("\n Introduce el entero a y el entero b \n (Aplica un espacion despues"
							+ " de haber introducido el primer numero): ");
		int num1 = lc.nextInt();
		int num2 = lc.nextInt();
		
		System.out.printf (" Cociente: %d\n Residuo: %d\n"
							,calcularCociente(num1,num2),calcularResiduo(num1,num2));
		
		System.out.println("\n Desea avanzar a lo siguiente? ");
		car = lc.next().charAt(0);
		}
		while (car != 'S' && car != 's');
		
		do
		{
		System.out.print ("\nAhora introduzca un entero, (menor de 5 digitos): ");
		String entero=lc.next();
		cifras=entero.length();
		
		// System.out.printf ("El numero tiene %d cifras\n",cifras);
		
		int entero2=Integer.parseInt(entero);
			if (cifras<=5)
			{
			mostrarDigitos(entero2);
			}
			
			else
			{
				System.out.println("\nEl numero es mayor de 5 digitos\nTry Again");
			}
		}
		while (cifras>5);
	}
	
	public static int calcularCociente (int num1,int num2)
	{
		return (num1/num2);
	}
	
	public static int calcularResiduo (int num1,int num2)
	{
		return (num1%num2);
	}
	
	public  static void mostrarDigitos (int entero2)
	{
		if (cifras==1)
		{
			System.out.print (entero2);
		}
		
		if (cifras==2)
		{
			int dig1 = entero2/10;
			System.out.printf ("%d  ",dig1);
			dig1 = entero2%10;
			System.out.printf ("%d  ",dig1);
		}
		
		if (cifras==3)
		{
			int dig1 = entero2/100;
			System.out.printf ("%d  ",dig1);
			dig1 = entero2%100;
			dig1 /= 10;
			System.out.printf ("%d  ",dig1);
			dig1 = entero2%10;
			System.out.printf ("%d  ",dig1);
		}
		
		if (cifras==4)
		{
			int dig1 = entero2/1000;
			System.out.printf ("%d  ",dig1);
			dig1 = entero2%1000;
			dig1 /= 100;
			System.out.printf ("%d  ",dig1);
			dig1 = entero2%100;
			dig1 /= 10;
			System.out.printf ("%d  ",dig1);
			dig1 = entero2%10; 
			System.out.printf ("%d  ",dig1);
		}
		
		if (cifras==5)
		{
			int dig1=entero2/10000;
			System.out.printf ("%d ",dig1);
			dig1 = entero2%10000;
			dig1 /= 1000;
			System.out.printf ("%d  ",dig1);
			dig1 = entero2%1000;
			dig1 /= 100;
			System.out.printf ("%d ",dig1);
			dig1 = entero2%100;
			dig1 /= 10;
			System.out.printf ("%d  ",dig1);
			dig1 = entero2%100;
			dig1 %= 10;
			System.out.printf ("%d ",dig1);
		}
	}
}
