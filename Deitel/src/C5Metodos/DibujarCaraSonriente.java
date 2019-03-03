package C5Metodos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DibujarCaraSonriente extends JPanel
{
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		// dibuja la cara
		g.setColor(Color.YELLOW);
		g.fillOval(10, 10,200,200);
		
		// dibuja los ojos
		g.setColor(Color.BLACK);
		g.fillOval(55,65,30,30);
		g.fillOval(135,65,30,30);
		
		// dibuja la boca
		g.fillOval(50,110,120,60);
		
		// convierte la boca en sonrisa
		g.setColor(Color.YELLOW);
		g.fillRect(50,110,120,30);
		g.fillOval(50,120,120,40);
	}
}
