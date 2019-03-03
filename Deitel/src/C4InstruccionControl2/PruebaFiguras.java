package C4InstruccionControl2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PruebaFiguras 
{
	public static void main(String[] args) 
	{
		String entrada = JOptionPane.showInputDialog(
				"Escriba 1 para dibujar rectnagulos\n"
				+ "Escriba 2 para dibujar ovalos" );
		
		int opcion = Integer.parseInt(entrada); // convierte entrada eb int
		
		// crea el Panel con la entrada del usuario
		FigurasGUI panel = new FigurasGUI(opcion);
		
		JFrame aplicacion = new JFrame(); // crea un nuevo objeto JFrame
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacion.add (panel);
		aplicacion.setSize(300,300);
		aplicacion.setVisible( true );
	}
}
