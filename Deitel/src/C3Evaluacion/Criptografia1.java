package C3Evaluacion;

import java.util.Scanner;

public class Criptografia1 
{
	private int num,entero;
	
	public Criptografia1 (int numero,int enteroo)
	{
		num=numero;
		entero=enteroo;
	}
	
	public void Establecernumero (int numero)
	{
		num=numero;
	}
	
	public int Obtenernumero ()
	{
		return num;
	}
	
	public void Establcerentero (int enteroo)
	{
		entero=enteroo;
	}
	
	public int Obtenerentero ()
	{
		return entero;
	}
	
	public void Encriptarnumero ()
	{
		Scanner input = new Scanner(System.in);
		
		int dig1,dig2,dig3,dig4,temp1,temp2,validardig;
		
		System.out.print(" Introduce una clave que contenga 4 digitos: ");
		num=input.nextInt();
		Establecernumero(num);	
		
		validardig=num/1000;
		
		System.out.println();
	 
		if (validardig>=1 && validardig<=9)
		{
			dig1=num/1000;
		
			dig2=num%1000;
			dig2=dig2/100;
		
			dig3=num%100;
			dig3=dig3/10;
		
			dig4=num%10;
			dig4=dig4/1;
		
			dig1=(dig1+7);
			dig1=dig1%10;
		
			dig2=(dig2+7);
			dig2=dig2%10;
		
			dig3=(dig3+7);
			dig3=dig3%10;
		
			dig4=(dig4+7);
			dig4=dig4%10;
		
			temp1=dig1;
			dig1=dig3;
			dig3=temp1;
			
			temp2=dig2;
			dig2=dig4;
			dig4=temp2;
			
			entero = (dig4*1) + (dig3*10) + (dig2*100) + (dig1*1000);
			Establcerentero(entero);
			System.out.printf (" Su nueva clave privada será: %d\n",entero);
			
		}
		
		else 
			System.out.println (" Error: La cantidad de digitos pedidos puede ser menor o exceda\n de la cantidad de digitos pedidos");
	
	
		while (validardig<1 || validardig>9)
			{
			
		System.out.println();	
		System.out.print(" Introduce una clave que contenga 4 digitos: ");
		num=input.nextInt();
		Establecernumero(num);	
		
		validardig=num/1000;
			
		System.out.println();
		 
			if (validardig>=1 && validardig<=9)
			{
				dig1=num/1000;
			
				dig2=num%1000;
				dig2=dig2/100;
			
				dig3=num%100;
				dig3=dig3/10;
			
				dig4=num%10;
				dig4=dig4/1;
			
				dig1=(dig1+7);
				dig1=dig1%10;
			
				dig2=(dig2+7);
				dig2=dig2%10;
			
				dig3=(dig3+7);
				dig3=dig3%10;
			
				dig4=(dig4+7);
				dig4=dig4%10;
			
				temp1=dig1;
				dig1=dig3;
				dig3=temp1;
				
				temp2=dig2;
				dig2=dig4;
				dig4=temp2;
				
				entero = (dig4*1) + (dig3*10) + (dig2*100) + (dig1*1000);
		
				System.out.printf (" Su nueva clave privada será: %d\n",entero);
			
			}
			
			else 
				System.out.println (" Error: La cantidad de digitos pedidos puede ser menor o exceda\n de la cantidad de digitos pedidos");
		
			}
	}
	
	public static void main(String[] args) 
	{
		Criptografia1 sc = new Criptografia1(0,0);
		
		sc.Encriptarnumero();
	}

}
