package Colas;

import javax.swing.JOptionPane;

import Pilas.Pila;

public class ColaApp
{
	public static void main(String[] args)
	{
int opcion=0,elemento;
		
		try
		{	
			Cola cola = new Cola();
			
			do
			{
				opcion=Integer.parseInt(
						JOptionPane.showInputDialog(null,
								  "1. Insertar un elemento en la Cola\n"
								 + "2. Quitar un elemento de la Cola\n"
								 + "3. ¿La Cola esta Vacia?\n"
								 + "4. Elemento ubicado al inicio de la Cola\n"
								 + "5. Tamaño de la Cola\n"
								 +"6. Mostrar Cola\n"
								 + "7. Salir\n"
								 + "Que desea hacer?","Menu de Opciones",
								 JOptionPane.INFORMATION_MESSAGE));
				
				switch (opcion)
				{
					case 1:
						elemento=Integer.parseInt(
								JOptionPane.showInputDialog(null,
								"Ingresa el elemento a insertar",
								"Insertando en la Cola",
								JOptionPane.QUESTION_MESSAGE));
						cola.insertar(elemento);
					break;
					
					case 2:
						if(!cola.estaVacia())
						{
							JOptionPane.showMessageDialog(null, 
									"El elemento atendido es: "+cola.quitar(),
									"Quitando Elementos de la Cola",
									JOptionPane.INFORMATION_MESSAGE);
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"La Cola Esta Vacia",
									"Cola Vacia",
									JOptionPane.INFORMATION_MESSAGE);
						}
						
						break;
						
					case 3:
						JOptionPane.showMessageDialog(null,
							String.format("La Cola %s vacia",
									(cola.estaVacia()) ? "está" : "no está"),
									"Mensaje",
									JOptionPane.INFORMATION_MESSAGE);
						break;
						
					case 4:
						if(!cola.estaVacia())
						{
							JOptionPane.showMessageDialog(null, 
									"El elemento ubicado al incio "
									+ "de la Cola es: "+cola.inicioCola(),
									"Quitando Elementos de la Cola",
									JOptionPane.INFORMATION_MESSAGE);
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"La Cola Esta Vacia",
									"Cola Vacia",
									JOptionPane.INFORMATION_MESSAGE);
						}
						break;
						
					case 5:
						JOptionPane.showMessageDialog(null, 
								"Tamaño de la cola: "+cola.sizeQue(),
								"Tamaño Cola",
								JOptionPane.INFORMATION_MESSAGE);
						break;
				
					/*case 6:
						JOptionPane.showMessageDialog(null, 
								cola.mostrarCola());
						break;*/
						
					case 7:
						JOptionPane.showMessageDialog(null,
								"Aplicacion Finalizada","Fiin",
								JOptionPane.INFORMATION_MESSAGE);
						break;
						
					default:
						JOptionPane.showMessageDialog(null,
								"La opcion no está en el Menu","INCORRECTO",
								JOptionPane.ERROR_MESSAGE);
				}
			}
			while(opcion!=7);
		} 
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, 
					"Error "+e.getMessage());
		}
	}
}
