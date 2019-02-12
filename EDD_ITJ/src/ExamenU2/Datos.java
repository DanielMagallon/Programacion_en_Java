package ExamenU2;

import java.io.*;

/**
 * La clase datos permite leer valor de tipo entero, doble, caracter y cadena. para poder usar cualquiera de los metodos debe mandar el msj
 * que recibira como argumentos y mostrara antes de la lectura.
 * @author Roberto Maldonado
 *
 */

public class Datos
{

	private BufferedReader obb = new BufferedReader(new InputStreamReader(System.in));
/**
 * El metodo entero puede leer valores positivos o negativos y retornarlos para que sean utilizados en otro lugar
 * @param msj Es el mensaje que se presenta antes de leer el valor entero
 * @return Retorna un valor entero.
 */

	public int Entero(String msj)
	{
		int x = 0;
		try
		{
			System.out.print(msj + " ");
			x = Integer.parseInt(obb.readLine().trim());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Solo datos numericos");
			x = this.Entero(msj);
		}
		catch (IOException e)
		{
			System.out.println("Error de entrada..");

		}
		return x;
	}
	
	/**
	 * El metodo doble puede leer valores positivos o negativos con punto decimal y retornarlos para que sean utilizados en otro lugar
	 * @param msj Es el mensaje que se presenta antes de leer el valor con punto decimal o entero.
	 * @return Retorna un valor con punto decimal.
	 */	

	public double Doble(String msj)
	{
		double x = 0;
		try
		{
			System.out.println(msj + " ");
			x = Double.parseDouble(obb.readLine().trim());
		}
		catch (NumberFormatException e)
		{
			x = this.Doble(msj);
		}
		catch (IOException e)
		{
			System.out.println("Error de entrada..");

		}
		return x;
	}
	
	/**
	 * El metodo caracter puede leer carcater, simbolo especial para que sea utilizado en otro lugar
	 * @param msj Es el mensaje que se presenta antes de leer un caracter
	 * @return Retorna un Caracter (char)
	 */	

	public char Caracter(String msj)
	{

		char x = ' ';
		try
		{
			System.out.println(msj + " ");
			x = obb.readLine().trim().charAt(0);

		}
		catch (StringIndexOutOfBoundsException e)
		{
			x = this.Caracter(msj);

		}
		catch (IOException e)
		{
			System.out.println("Error de entrada");
		}
		return x;
	}
	
	/**
	 * El metodo String puede mostrar un caracter, simbolo especial que sea utilizado en otro lugar
	 * @param msj Es el mensaje que se presenta antes de leer el valor entero
	 * @return Retorna un valor entero.
	 */	

	public String Cadena(String msj)
	{
		String x = " ";
		try
		{
			System.out.println(msj + " ");
			x = obb.readLine().trim();

		}
		catch (IOException e)
		{
			System.out.println("Error de entrada..");

		}
		return x;
	}
}