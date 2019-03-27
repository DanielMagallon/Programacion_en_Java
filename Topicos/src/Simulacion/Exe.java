package Simulacion;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Exe
{
	public static void main(String[] args) 
	{
		
		SwingUtilities.invokeLater(
				
					()-> 
					{
						try
						{
							new App().setVisible(true);
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
						}
					}
					
				
				);
	}
}
