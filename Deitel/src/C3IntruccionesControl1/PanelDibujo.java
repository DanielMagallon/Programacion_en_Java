package C3IntruccionesControl1;

import java.awt.Graphics;
import javax.swing.JPanel;

// Uso de drawLine para conectar las esquinas de un panel.
/*
 *  La línea 30 utiliza la palabra clave extends para indicar que la clase Panel Dibujo es un tipo mejorado de 
 *  JPanel. 
 *  La palabra clave extends representa algo que se denomina relacion de herencia en la cual nuestra nueva clase
 *  clase PanelDibujo empieza con los miembros existentes (datos y metodos) de la clase JPanel.
 *  A JPanel se le conoce como superclase y Panel dibujo es la subclase.
 *  
 *   El Metodo "paintComponent"; todo JPanel, incluyendo nuestro PanelDibujo tiene un metodo "paintComponent"
 *   El metodo paintComponent como se muestra en la linea 21 (public void paintComponent (Graphics g))
 *   El metodo paintComponent requiere un argumento, un obejto Graphics 
 *   La primera instruccion en cualquier metodo paitnComponent deber ser siempre:
 *   		super.paintComponent (g); la cual asegura que el panel se despliugue de manera apropiada
 *   en la pantalla, antes de empezar a dibujar en él.
 *   A continucacion las lineas 38,39, llaman a los metodos que la clase PanelDibujo herede de la clase JPanel.
 *   Los metodos getWidth y getHeight devuelven la anchura y la altura del objeto JPanel.
 *   Por ultimo las lineas 42 y 45 utilizan la variable g de la clase Graphics para llamar al metodo drawLine, y q' dibuje 
 *   las dos lineas. 
 *   El metodo drawLine dibuja una linea entre dos puntos representados por sus cuatro argumentos; los primeros dos
 *   son las cordenadas "x" y "y" para uno de los puntos finales de la linea, y los ultimos dos son las coordenadas 
 *   para el otro punto final.
 *   
 */

public class PanelDibujo extends JPanel {
	// dibuja una x desde las esquinas del panel
	public void paintComponent(Graphics g) {
		// llama al paintComponent para asegurar que el Panel se muestre
		// correctamente
		super.paintComponent(g);

		int ancho = getWidth(); // anchura total
		int alto = getHeight(); // altura total

		// dibuja una linea de la esquina superior izq. a las a las esquina
		// inferior derecha.
		g.drawLine(0, 0, ancho, alto);

		// dibuja una linea de la esquina inferior izq. a las esquina superior
		// derecha.
		g.drawLine(0, alto, ancho, 0);
	}
}
