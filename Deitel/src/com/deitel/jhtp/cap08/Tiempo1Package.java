
package com.deitel.jhtp.cap08;

public class Tiempo1Package
{
	private int hora;
	private int minuto;
	private int segundo;
	
	// establece un nuevo valor de tiempo, usando la hora universal
	// lanza la excepcion si la hora, minuto o segundo son invalidos
	
	public void establecerTiempo (int h,int m,int s)
	{
		// valida la hora,minuto, segundo
		
		if ((h>=0 && h<24) && (m>=0 && m<60) && (s>=0 && s<60))
		{
		
			hora=h;
			minuto=m;
			segundo=s;
		}
		
		else
			throw new IllegalArgumentException(
					"hora,minuto y/o segundo estaban fuera de rango");
	}
	
	// convierte a objeto String en formato de hora universal (HH:MM:SS)
	public String aStringUniversal ()
	{
		return String.format("%02d:%02d:%02d",hora,minuto,segundo);
	}
	
	// convierte objeto String a formato de hora estandar
	public String toString ()
	{
		return String.format("%d:%02d:%02d",((hora==0 || hora==12) ? 12 : hora%12 ),minuto,segundo,
				(hora<12 ? "AM" : "PM"));
	}
}
