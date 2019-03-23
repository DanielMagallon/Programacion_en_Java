package Simulacion;

import java.math.BigDecimal;

import javax.swing.SwingUtilities;

public class Exe
{
	/*
	 * Rsrc-Class-Path: .lib/stringop.jar
		Rsrc-Main-Class: UnidadII.Interfaz
		Class-Path: .
	 */
	public static void main(String[] args) 
	{
		int t;
		int x,y;
		
		for(t=-2; t<=2; t++)
		{
			x = 5-(4*t);
			y = 2+(5*t);
			System.out.printf("(t) = %d -> x: %d -- y: %d\n",t,x,y);
		}
		
//		SwingUtilities.invokeLater(
//				
//					()-> 
//					{
//						new App().setVisible(true);
//					}
//					
//				
//				);
	}
}
