package C6ArreglosArrayList;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DibujoArcoiris extends JPanel
{
	// Define los colores indigo y violeta 
	private final static Color VIOLETA =  new Color(128,0,128);
	private final static Color INDIGO =  new Color(75,0,130);
	
	// los colores a usar en el arco iris, empezando desde los mas interiores
	// Las dos entradas de color blanco producen un arco vacio en el centro
	private Color [] colores = {Color.WHITE,Color.WHITE,VIOLETA,INDIGO,Color.BLUE,
			Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};
	
	// constructor 
	
	public DibujoArcoiris ()
	{
		setBackground (Color.WHITE); // establece el fondo al color blanco
	}
	
	// dibuja un arcoiris, usando circulos concetricos
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		int radio=20;
		
		// dibuja el arcoiris cerca de la parte central inferior
		int centroX = getWidth()/2;
		int centroY = getHeight() - 10;
		
		// dibuja arcos rellenos , empezando con el mas exterior
		for (int contador= colores.length; contador>0; contador--)
		{
			g.setColor (colores[contador-1]);
			
			
			g.fillArc (centroX - contador * radio,
					centroY - contador * radio,
					contador * radio * 2, contador * radio * 2,0,180);
		}
	}
}
