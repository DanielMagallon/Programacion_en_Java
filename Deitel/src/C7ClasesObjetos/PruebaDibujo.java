package C7ClasesObjetos;

import javax.swing.JFrame;

public class PruebaDibujo
{
	public static void main(String[] args)
	{
		PanelDibujo panel = new PanelDibujo();
		JFrame aplicacion = new JFrame();
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacion.add(panel);
		aplicacion.setSize(300,300);
		aplicacion.setVisible(true);
	}
}
