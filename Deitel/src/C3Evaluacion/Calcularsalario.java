package C3Evaluacion;

import java.util.Scanner;

public class Calcularsalario 
{
	private String empleado;
	private int horastrab,tarifxh,saldo;
	
	public Calcularsalario (String nombre,int horas,int tarifa)
		{
			empleado = nombre;
			horastrab = horas;
			tarifxh = tarifa;
		}
	
	public void Estableceremp (String nombre) 
		{
			empleado = nombre;
		}

	public String Obteneremp () 
		{
			return empleado;
		}
	
	public void Establecerhours (int horas) 
		{
			horastrab = horas;
		}

	public int Obtenerhours() 
		{
			return horastrab;
		}
	
	public void Establecertarifa (int tarifa) 
		{
			tarifxh = tarifa;
		}

	public int Obtenertarif() 
		{
			return tarifxh;
		}
	
	public void determinarTarifatotal (int saldo)
		{
			if (horastrab>40)
				{
					saldo = (tarifxh+ (tarifxh/2)) * (horastrab);
					System.out.printf (" Su salario será de: $%d\n",saldo);
				}
			
			else
				{
			saldo = tarifxh * horastrab; 
			System.out.printf (" Su salario será de: $%d\n",saldo);
				}
			
		}
}
