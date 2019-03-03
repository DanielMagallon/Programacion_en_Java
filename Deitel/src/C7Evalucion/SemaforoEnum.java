package C7Evalucion;

import java.util.Random;
import java.util.Scanner;

public class SemaforoEnum
{
	 static Random lb = new Random();
	 static int duracion=1;
	 static boolean entrada=true;
	 
	 private enum LuzSemaforo {ROJO,VERDE,AMARILLO};
	
	 public static void duracionLuz (LuzSemaforo estadoSemaforo)
	 {
		 switch (estadoSemaforo)
		 {
		 	case ROJO:
		 		duracion=15;
		 		break;
		 		
		 	case VERDE:
		 		duracion=20;
		 		break;
		 		
		 	case AMARILLO:
		 		duracion=5;
		 		break;
		 }
	 }
	
	 public static void cambiarColorSemaforo ()
	 {
		 int color=lb.nextInt(9)+1;
			LuzSemaforo estadoSemaforo = null;
			
			if (color==1 || color==3 || color==5)
			{
				estadoSemaforo = LuzSemaforo.ROJO;
				duracionLuz(estadoSemaforo);
			}
			
			else
			if (color==2 || color==4 || color==6)
			{
				estadoSemaforo = LuzSemaforo.VERDE;
				duracionLuz(estadoSemaforo);
			}
			
			else
			if (color==7 || color==8 || color==9)
			{
				estadoSemaforo = LuzSemaforo.AMARILLO;
				duracionLuz(estadoSemaforo);
			}
			
			int duracionAleatoria=lb.nextInt(duracion)+1;
			
			int n=0;
			
			if (entrada==true)
			System.out.println("El semaforo se encuentra en:\n");
			
			entrada=false;
			
			while (n<duracionAleatoria)
			{
				System.out.printf ("%s\n",estadoSemaforo);
				n++;
			}
			System.out.printf ("\nLa duracion del color %s fue %d segundos",estadoSemaforo,n);
	 }
	 
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		cambiarColorSemaforo();
		
		int repeticion=1;
		
		while (repeticion<=10)
		{
			System.out.print("\n\nEl semaforo cambiara al:\n");
			repeticion++;
			cambiarColorSemaforo();
		}
		
	}
	
}
