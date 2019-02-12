package Evaluacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Datos
{
	private  BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	private  int entero;
	private  double doble;
	private  float flotante;
	private  boolean hayError=false;
	
	public  String leerCadena(String msg)
	{
		System.out.print(msg);
		
		try 
		{
			return leer.readLine();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public  char leerChar(String cad)
	{
		try 
		{
			System.out.print(cad);
			return leer.readLine().charAt(0);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ' ';
		}
	}
	
	public  int leerEntero(String cad)
	{
		do
		{
			try 
			{
				System.out.print(cad);
				entero = Integer.parseInt(leer.readLine());
				hayError=false;
			} 
			catch (NumberFormatException e) 
			{
				System.out.print("Solo datos numericos enteros");
				System.out.print ("Vuelva a introducir\n");
				hayError=true;
			} 
			catch (IOException e) 
			{
				System.out.print("Error hard");
				hayError=true;
			}
		}
		while(hayError);
			
		return entero;
	}
	
	public  double leerDouble(String cad)
	{
		do
		{
			try 
			{
				System.out.print(cad);
				doble = Double.parseDouble(leer.readLine());
				hayError=false;
			} 
			catch (NumberFormatException e) 
			{
				System.out.print("Solo datos numericos");
				System.out.print ("Vuelva a introducir\n");
				hayError=true;
			} 
			catch (IOException e) 
			{
				System.out.print("Error hard");
				hayError=true;
			}
		}
		while(hayError);
			return doble;
	}
	
	public  float leerFlotante (String cad)
	{
		do
		{
			try 
			{
				System.out.print(cad);
				flotante = Float.parseFloat(leer.readLine());
				hayError=false;
			} 
			catch (NumberFormatException e) 
			{
				System.out.print("Solo datos numericos");
				System.out.print("Vuelva a introducir\n");
				hayError=true;
			} 
			catch (IOException e) 
			{
				System.out.print("Error hard");
				hayError=true;
			}
		}
		while(hayError);

		return flotante;
	}
}
