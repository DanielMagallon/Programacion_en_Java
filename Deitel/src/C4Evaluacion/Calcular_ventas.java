package C4Evaluacion;

import java.util.Scanner;

public class Calcular_ventas 
{
	
	private double total1;
	private double total2;
	private double total3;
	private double total4;
	private double total5;
	private double totaltodo;
	private boolean bandera;
	private int cont1;
	private int cont2;
	private int cont3;
	private int cont4;
	private int cont5;
	private double totalp1;
	private double totalp2;
	private double totalp3;
	private double totalp4;
	private double totalp5;
	
	
	Scanner lc = new Scanner(System.in);
	
	public void mostrarCartel ()
	{
		System.out.printf ("   %s%40s\n","Producto","Precio del articulo");
		System.out.println();
		
		for (int prod = 1; prod<=5; prod++)
		{
			switch (prod)
			{
			case 1:
				System.out.printf ("%4d.-\t%2s%31s\n\n",prod,"Soda","$2.98");
				break;
				
			case 2:
				System.out.printf ("%4d.-\t%2s%22s\n\n",prod,"Potatoe chips","$4.50");
				break;
			
			case 3:
				System.out.printf ("%4d.-\t%2s%28s\n\n",prod,"Cookies","$9.98");
				break;
				
			case 4:
				System.out.printf ("%4d.-\t%2s%23s\n\n",prod,"Oranje juice","$4.49");
				break;
				
			case 5:
				System.out.printf ("%4d.-\t%2s%28s\n\n",prod,"Candies","$6.87");
				break;
			}
		}
	}
	
	public void introducirCompras ()
	{
	
		int productos;
		double cantidad;
		
		System.out.print (" Inroduzca el producto que desee comprar: ");
		productos=lc.nextInt();
		
		while (productos != 0)
	{
		System.out.print (" Inroduzca la cantidad de productos a comprar: ");
		cantidad=lc.nextInt();
		calcularPrecio (productos,cantidad);
		System.out.println();
		System.out.print (" Inroduzca el producto que desee comprar: ");
		productos=lc.nextInt();
		
	}
	}
	
	private void calcularPrecio (int productos,double cantidad)
	{
	
		switch (productos)
		{
			case 1: 
			
				total1 = cantidad * 2.98;
				totaltodo += total1;
				bandera=true;
				cont1 += cantidad;
				totalp1= cont1 * 2.98;
				break;
			
			case 2:	
				total2 = cantidad * 4.50;
				totaltodo += total2;
				bandera=true;
				cont2 += cantidad;
				totalp2= cont2 * 4.50;
				break;
				
			case 3:
				total3 = cantidad * 9.98;
				totaltodo += total3;
				bandera=true;
				cont3 += cantidad;
				totalp3= cont3 * 9.98;
				break;
				
			case 4:
				total4 = cantidad * 4.49;
				totaltodo += total4;
				bandera=true;
				cont4 += cantidad;
				totalp4= cont4 * 4.49;
				break;
				
			case 5:
				total5 = cantidad * 6.87;
				totaltodo += total5;
				bandera=true;
				cont5 += cantidad;
				totalp5= cont5 * 6.87;
				break;	
				
			default:
				System.out.println();
				System.out.println("No existe ese articulo");
				
		}
		
	}
	
	public void mostrarTotal ()
	{
		System.out.println();
		
		if (bandera==true)
		{
		System.out.printf("%4s%25s%15s\n","Producto", "Cantidad comprada", "Total");
		System.out.println();
		
		for (int producto=1; producto <= 5; producto++)
		{
			switch (producto)
			{
			
			case 1:  
			System.out.printf ("%4d%20d%20s%.2f\n",producto,cont1,"$",totalp1);
			break;
			
			case 2:
			System.out.printf ("%4d%20d%20s%.2f\n",producto,cont2,"$",totalp2);
			break;
			
			case 3:
			System.out.printf ("%4d%20d%20s%.2f\n",producto,cont3,"$",totalp3);
			break;
			
			case 4: 
			System.out.printf ("%4d%20d%20s%.2f\n",producto,cont4,"$",totalp4);
			break;
			
			case 5:
			System.out.printf ("%4d%20d%20s%.2f\n",producto,cont5,"$",totalp5);
			break;
			}
		}

		System.out.println();
		System.out.printf (" El total a pagar por todos los articulos comprados es de $%.2f",totaltodo);
		
		}
		
		else
		{
			System.out.println(" No se compro ningun articulo");
		}
			
	}
}
