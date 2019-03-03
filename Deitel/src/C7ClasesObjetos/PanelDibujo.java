package C7ClasesObjetos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class PanelDibujo extends JPanel  
{
	private Random lb=new Random();
	private  MiLinea[] lineas; // arreglo de Lineas
	
	public PanelDibujo ()
	{
		setBackground(Color.WHITE);
		
		lineas=new MiLinea[5+lb.nextInt(5)];
		
		// crea lineas
		for (int cuenta=0; cuenta<lineas.length; cuenta++)
		{
			// genera coordenas aleatorias
			int x1=lb.nextInt(300);
			int y1=lb.nextInt(300);
			int x2=lb.nextInt(300);
			int y2=lb.nextInt(300);
			
			// genera un color aleatorio
			Color color = new Color(lb.nextInt(256),
					lb.nextInt(256),lb.nextInt(256));
			
			// agrega la linea a la lista   de lineas a mostrar en pantalla
			lineas[cuenta] = new MiLinea (x1,y1,x2,y2,color);
			
		}
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		// dibuja las lineas
		for (MiLinea linea: lineas)
			linea.dibujar(g);
	}
}
