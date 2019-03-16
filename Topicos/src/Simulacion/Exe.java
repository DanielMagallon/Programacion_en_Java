package Simulacion;

import java.math.BigDecimal;

import javax.swing.SwingUtilities;

public class Exe
{
	public static void main(String[] args) 
	{
		
		SwingUtilities.invokeLater(
				
					()-> 
					{
						new App().setVisible(true);
					}
					
				
				);
	}
}
