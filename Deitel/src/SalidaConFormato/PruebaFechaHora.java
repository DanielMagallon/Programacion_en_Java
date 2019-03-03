package SalidaConFormato;

import java.util.Calendar;

public class PruebaFechaHora
{
	public static void main(String[] args)
	{
		// obtiene la fecha y hora actuales
		Calendar fechaHora = Calendar.getInstance();
		
		// impresion con caracteres de conversion para composiciones de fecha/hora
		System.out.printf ("%tc\n",fechaHora);
		System.out.printf ("%tF\n",fechaHora);
		System.out.printf ("%tD\n",fechaHora);
		System.out.printf ("%tr\n",fechaHora);
		System.out.printf ("%tT\n",fechaHora);
		
		// impresion con caracteres de conversion para fechas
		System.out.printf ("%1$tA, %1$tB, %1$td, %1$tY\n",fechaHora);
		System.out.printf ("%1$TA, %1$TB, %1$Td, %1$TY\n",fechaHora);
		System.out.printf ("%1$ta, %1$tb, %1$te, %1$ty\n",fechaHora);
		
		// impresion con caracteres de conversion para horas
		System.out.printf ("%1$tH:%1$tM:%1$tS\n",fechaHora);
		System.out.printf ("%1$tZ:%1$tI:%1$tS %tp",fechaHora);
		
	}
}
