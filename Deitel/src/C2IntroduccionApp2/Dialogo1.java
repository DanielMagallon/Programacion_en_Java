package C2IntroduccionApp2;

// Caso de Estudio de GUI
// Uso de JOptionPane para imprimir varias líneas en un cuadro de dialogo

import javax.swing.JOptionPane; //indica que el programa utiliza la clase JOptionPane del paquete javax.swing.El cual 
//contiene muchas clases que le ayudan a crear interfaces  gráficas de usuario (GUI). 

public class Dialogo1 
	{
	
		public static void main(String[] args) 
			{
			
			// muestra un cuadro de dialogo con un mensaje
				
JOptionPane.showMessageDialog(null, "Bienvenido\na\nJava");//llama al método showMessageDialog de JOptionPane para mostrar un  
															//cuadro de diálogo que contiene un mensaje. 
			}
	
	}

/* Si el primer argumento es null ,
*  el cuadro de diálogo aparece en el centro de la pantal la de la computadora.El segundo argumento es el 
*  objeto String a mostrar en el cuadro de diálogo.
*  
*  El método showMessageDialog de la clase JOptionPane es lo que llamamos un método static .  
*/