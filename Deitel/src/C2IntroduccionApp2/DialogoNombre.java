package C2IntroduccionApp2;

import javax.swing.JOptionPane;  

public class DialogoNombre 
	{

		public static void main(String[] args) 
			{
			
			//pide el usuario que escriba su nombre
				String nombre = JOptionPane.showInputDialog("Cu�l es su nombre?");
			
			/* 	Utiliza el m�todo showInputDialog de JOptionPane para mostrar un di�logo de 
			 *	entrada que contiene un indicador y un campo (conocido como campo de texto), en donde  el usuario
			 *	puede escribir texto. El argumento del m�todo showInputDialog es el indicador que muestra lo que el 
			 *	usuario debe escribir.
			 */
				
			
			// crea el mensaje
				String mensaje = String.format("Bienvenido %s, a la programacion en Java� ",nombre);
				
			// muestra el mensaje para dar la bienvenida al al Usuario por su nombre
				JOptionPane.showMessageDialog(null,mensaje);
				
			}
	
	}
