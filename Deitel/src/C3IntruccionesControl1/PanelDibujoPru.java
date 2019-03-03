package C3IntruccionesControl1;

// Aplicacion que muestra un panel de dibujo

/*
 *  Se debe crear una ventana con un objeto de la clase JFrame, para poder mostar el PanelDibujo en pantalla 
 * 	La linea "31" llama al metodo setDefaultCloseOperation de JFrame con el argumento JFrame.EXIT_ON_CLOSE
 *  para indicar que la aplicacion debe terminar cuando el usuario cierre la ventana.
 *  
 *  La linea "33" utiliza el metodo add de JFrame para adjuntar el objeto PanelDibujo al objeto JFrame 
 *  La liena "34" establece el tamaño del objeto del objeto JFrame; EL metodo setSize recibe dos parametros
 *  que representan la anchura y la altura del objeto JFrame mediante una llamada a su metodo setVisible con 
 *  el argumento true.
 *  
 */

import javax.swing.JFrame;

public class PanelDibujoPru {
	public static void main(String[] args) {
		// crea un panel que contiene nuestro dibujo
		PanelDibujo panel = new PanelDibujo();

		// crea un nuevo marco para contener el Panel
		JFrame aplicacion = new JFrame();

		// establece el marco para salir cuando se cierre
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		aplicacion.add(panel); // agrega el panel al marco
		aplicacion.setSize(250, 250); // establece el tamaño del marco
		aplicacion.setVisible(true); // hace que el marco sea visible
	}
}
