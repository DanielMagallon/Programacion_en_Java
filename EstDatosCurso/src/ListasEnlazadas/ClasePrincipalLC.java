package ListasEnlazadas;

import javax.swing.JOptionPane;

public class ClasePrincipalLC
{
	public static void main(String[] args)
	{
		ListasCircularesSE ld = new ListasCircularesSE();
		int opcion=0,elemento;
		boolean eliminado=false;
		
		do
		{
			try
			{
				opcion=Integer.parseInt
						(JOptionPane.showInputDialog(null,
						"1. Agregar un Nodo a la Lista Circular\n"
						+ "2. Eliminar un Nodo de la Lista Circular\n"
						 + "3. Mostrar los Datos de la Lista Circular\n"
						     + "4. Salir\n"
						      + "Que deseas hacer?","Menu de Opciones",
						    JOptionPane.INFORMATION_MESSAGE));
				
				switch (opcion)
				{
					case 1:
						elemento=Integer.parseInt(JOptionPane.showInputDialog
								(null,"Ingrese el elemento del Nodo",
								"Agregando Nodo a la Lista Circular",
								JOptionPane.INFORMATION_MESSAGE));
						ld.insertarNodo(elemento);
						break;
					
					case 2:
						if(!ld.estaVacia())
						{
						elemento=Integer.parseInt(JOptionPane.showInputDialog
								(null,"Ingrese el elemento a eliminar",
								"Eliminando Nodo a la Lista Circular",
								JOptionPane.INFORMATION_MESSAGE));
						eliminado=ld.eliminar(elemento);
						if(eliminado)
						{
							JOptionPane.showMessageDialog(null,
									"El elemento eliminado es "+elemento,
									"Nodo Eliminado",
									JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"No se ha encontrado tal elemento",
									"Error: NotFoundNodo",
									JOptionPane.ERROR_MESSAGE);
						}
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"Aun no hay nodos","LISTA VACIA",
									JOptionPane.ERROR_MESSAGE);
						}
						
						break;
					
					case 3:
						if(!ld.estaVacia())
							ld.mostrarLista();
						
						else
							JOptionPane.showMessageDialog(null,
									"Aun no hay nodos","LISTA VACIA",
									JOptionPane.ERROR_MESSAGE);
						break;

					case 4:
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
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Error "+ e.getMessage());
			}
		}
		while (opcion != 4);
	}
	}

