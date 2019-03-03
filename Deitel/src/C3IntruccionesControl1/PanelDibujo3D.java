package C3IntruccionesControl1;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDibujo3D extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int ancho = getWidth();
		int altura = getHeight();

		// dibuja una linea de la esquina superior izq. a las a las esquina
		// inferior derecha.
		g.drawLine(0, 0, ancho, altura);
		g.drawLine(0, 0, ancho, altura);

		// dibuja una linea de la esquina inferior izq. a las esquina superior
		// derecha.
		// d.drawLine (0,altura,ancho,0);
	}
}
