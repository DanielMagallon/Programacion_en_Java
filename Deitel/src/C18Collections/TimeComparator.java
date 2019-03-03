package C18Collections;

import java.util.Comparator;

import C7ClasesObjetos.HoraEnSegundos;

public class TimeComparator implements Comparator<HoraEnSegundos>
{
	public int compare(HoraEnSegundos time1, HoraEnSegundos time2) 
	{
		int hourCompare = time1.obtenerHora() - time2.obtenerHora();
		
		if(hourCompare != 0)
			return hourCompare;
		
		int minuteCompare = time1.obtenerMinuto() - time2.obtenerMinuto();
		
		if ( minuteCompare != 0 )
			return minuteCompare;
		
		int secondCompare = time1.obtenerSegundo() - time2.obtenerSegundo();
		
		return secondCompare;
	}
	
	
}
