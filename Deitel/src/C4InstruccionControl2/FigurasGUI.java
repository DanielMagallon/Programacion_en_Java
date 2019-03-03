package C4InstruccionControl2;

// demuestra como dibujar distintas figuras

import java.awt.Graphics;
import javax.swing.JPanel;

public class FigurasGUI extends JPanel
{
	private int opcion; // opcion del usuario acerca de cual figura dibujar
	
	// el constructor establece la opcion del usuario
	public FigurasGUI (int opcionUsuario)
	{
		opcion = opcionUsuario;
	}
	
	// dibuja una cascada de figuras, empezando desde la esquina superior izquierda
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		for (int i = 0; i < 10; i++)
		{
			
			// elije la figura con base en la opcion del usuario 
			switch (opcion)
			{
				case 1: // dibuja rectangulos
					g.drawRect( 10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
					break;
					
				case 2: // dibuja ovalos
					g.drawOval( 10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
					break;
			}
		}
	}
}
