package Funcionamiento;

import java.awt.Point;

import Interfaz.Position;
import Piezas.Pieza;

public class Destino 
{
	//int matriz[][] = new int[8][8];
	static int f,  c;
	static int fDestino,cDestino;
	
	public static void destinoPieza(Position posIni, Position posFinal, Pieza pieza)
	{
		fDestino = posFinal.fila;
		cDestino = posFinal.columna;
		
		f = posIni.fila;
		c = posIni.columna;
		
		int x2=3,y2=2;
		
		double distancia1 = Point.distance(6,4,x2,y2);
		double distancia2 = Point.distance(5,5,x2,y2);
		double distancia3 = Point.distance(3,5,x2,y2);
		double distancia4 = Point.distance(2,4,x2,y2);
		double distancia5 = Point.distance(2,2,x2,y2);
		double distancia6 = Point.distance(3,1,x2,y2);
		
		//Si la distancia es de 2.24 esa es la buena
		//final double DISTANCIA_ESPECIAL = 2.2360680103302; 
		
		System.out.printf ("Distancia entre [4][6] a [%d][%d] = %.2f\n",y2,x2,distancia1);
		System.out.printf ("Distancia entre [5][5] a [%d][%d] = %.2f\n",y2,x2,distancia2);
		System.out.printf ("Distancia entre [5][3] a [%d][%d] = %.2f\n",y2,x2,distancia3);

		System.out.printf ("Distancia entre [4][2] a [%d][%d] = %.2f\n",y2,x2,distancia4);
		System.out.printf ("Distancia entre [2][2] a [%d][%d] = %.2f\n",y2,x2,distancia5);
		System.out.printf ("Distancia entre [1][3] a [%d][%d] = %.2f\n",y2,x2,distancia6);
		
		//System.out.println(distancia2==DISTANCIA_ESPECIAL);
		
		
//		for(int i=0; i<Variables.movsCaballo.length; i++)
//		{
//			
//		}
		
	}
	
	
	public static void main(String[] args) {
		
		if(args==null)
			return;
		destinoPieza(new Position(7, 6), new Position(2, 0), null);
		main(null);
		
	}
}
