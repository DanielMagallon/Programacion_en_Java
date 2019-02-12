package ListasEnlazadas;

import javax.swing.JOptionPane;

public class ClasePrincipalListaDoble
{
	public static void main(String[] args)
	{
		ListaDoble ld = new ListaDoble();
		int opcion=0,elemento;
		
		do
		{
			try
			{
				opcion=Integer.parseInt
						(JOptionPane.showInputDialog(null,
						"1. Agregar un Nodo al Inicio\n"
						+ "2. Agregar un Nodo al Final\n"
						 + "3. Mostrar la Lista de Inicio a Fin\n"
						  + "4. Mostrar la Lista de Fin a Incio\n"
						   +"5. Eliminar un Elemento del Inicio\n"
						    +"6. Eliminar un Elemento del Final\n"
						     + "7. Salir\n"
						      + "Que deseas hacer?","Menu de Opciones",
						    JOptionPane.INFORMATION_MESSAGE));
				
				switch (opcion)
				{
					case 1:
						elemento=Integer.parseInt(JOptionPane.showInputDialog
								(null,"Ingrese el elemento del Nodo",
								"Agregando Nodo al Incio",
								JOptionPane.INFORMATION_MESSAGE));
						ld.agregarAlIncio(elemento);
						break;
					
					case 2:
						elemento=Integer.parseInt(JOptionPane.showInputDialog
								(null,"Ingrese el elemento del Nodo",
								"Agregando Nodo al Final",
								JOptionPane.INFORMATION_MESSAGE));
						ld.agregarAlFinal(elemento);
						break;
					
					case 3:
						if (!ld.estaVacia())
						{
							ld.mostrarListaInicioFin();
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"No hay nodos aun","LISTA VACIA",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
						
					case 4:
						if (!ld.estaVacia())
						{
							ld.mostrarListaFinInicio();
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"No hay nodos aun","LISTA VACIA",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
						
					case 5:
						if (!ld.estaVacia())
						{
							elemento=ld.elminarDelInicio();
							JOptionPane.showMessageDialog(null,
									"El elemento eliminado es " 
									+elemento,
									"ELIMINANDO NODO DEL INICIO",
									JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"No hay nodos aun","LISTA VACIA",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
						
					case 6:
						if (!ld.estaVacia())
						{
							elemento=ld.eliminarDelFinal();
							JOptionPane.showMessageDialog(null,
									"El elemento eliminado es " 
									+elemento,
									"ELIMINANDO NODO DEL FINAL",
									JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"No hay nodos aun","LISTA VACIA",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
						
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
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Error "+ e.getMessage());
			}
		}
		while (opcion != 7);
	}
}
