package Practica2;

import java.util.Random;

public class ValorTablas 
{
	public static int obtenerTiempoLlegada(int random)
	{
			if(random<=30)
				return 1;
			
			if(random<=70)
				return 2;
			
			if(random<=85)
				return 3;
			
			
			return 4;
	}
	
	public static int tiempoServicioAble(int random)
	{
			if(random<=30)
				return 2;
			
			if(random<=58)
				return 3;
			
			if(random<=83)
				return 4;
			
			return 5;
	}
	
	public static int tiempoServicioBecker(int random)
	{
			if(random<=35)
				return 3;
			
			if(random<=60)
				return 4;
			
			if(random<=80)
				return 5;
			
			return 6;
	}
	
	public static int generarAleatorio()
	{
		Random lb = new Random();
		
		return lb.nextInt(100)+1;
	}
}
