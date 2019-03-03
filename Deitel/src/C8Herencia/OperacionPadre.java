package C8Herencia;

import java.util.Scanner;

public class OperacionPadre
{
	protected Scanner lc;
	protected int valor1;
	protected int valor2;
	protected int resultado;
	
	public OperacionPadre()
	{
		lc=new Scanner(System.in);
	}
	
	public void cargar1()
	{
		System.out.print("Ingrese el primer valor: ");
		valor1=lc.nextInt();
	}
	
	public void cargar2()
	{
		System.out.print("Ingrese el primer valor: ");
		valor2=lc.nextInt();
	}
	
	 int mostrarResulatdo ()
	{
		return resultado;
	}
}

class Suma extends OperacionPadre
{
	void sumar ()
	{
		resultado=valor1+valor2;
	}
}

class Resta extends OperacionPadre
{
	void restar ()
	{
		resultado=valor1-valor2;
	}
}
