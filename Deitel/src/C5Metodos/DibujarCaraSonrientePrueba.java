package C5Metodos;

import javax.swing.JFrame;

public class DibujarCaraSonrientePrueba 
{
	public static void main(String[] args) 
	{
		
		
		DibujarCaraSonriente panel = new DibujarCaraSonriente();
		JFrame aplicacion = new JFrame();
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacion.add (panel);
		aplicacion.setSize(230,250);
		aplicacion.setVisible(true);
	}
}

