package ListasEnlazadas;

import javax.swing.JOptionPane;

public class ClasePrincipalLista
{
	public static void main(String[] args)
	{
		int opcion=0,el;
		Lista lista = new Lista();

		do
		{
			try
			{
				opcion=Integer.parseInt(
						JOptionPane.showInputDialog(null,
						"1.- Agregar un elemento al incio de la lista\n"
					   +"2.- Agregar un elemento al final de la lista\n"
					   +"3.- Mostrar los datos de la lista\n"
					   +"4.- Eliminar un elemento al incio de la lista\n"
					   +"5.- Eliminar un elemento al final de la lista\n"
					   +"6.- Eliminar un elemento en especifico\n"
					   +"7.- Eliminar todo\n"
					   +"8.- Buscar elemento\n"
					   +"9.- Salir","Menu de Opciones",3));
				
				switch (opcion)
				{
					case 1:
						try
						{
							el=Integer.parseInt(JOptionPane.showInputDialog(null,
												"Ingresa el elemento:","Insertando al incio",3));
							
							// Agregando al nodo
							lista.agregarAlInicio(el);
							
						} 
						catch (NumberFormatException n)
						{
							JOptionPane.showMessageDialog(null,"Error " + n.getMessage(),
							"Valido numeros enteros",JOptionPane.ERROR_MESSAGE);
						}
						break;
						
					case 2:
						
						try
						{
							el=Integer.parseInt(JOptionPane.showInputDialog(null,
												"Ingresa el elemento:","Insertando al final",3));
							
							// Agregando al nodo
							lista.agregarAlFinal(el);
							
						} 
						catch (NumberFormatException n)
						{
							JOptionPane.showMessageDialog(null,"Error " + n.getMessage(),
							"Valido numeros enteros",JOptionPane.ERROR_MESSAGE);
						}
						
						break;
						
					case 3:
						lista.mostrarLista();
						break;
						
					case 4:
						el=lista.borrarInicio();
						JOptionPane.showMessageDialog(null, "El elemento eliminado es: "+el,
								"Eliminando nodo del inicio",JOptionPane.INFORMATION_MESSAGE);
						break;
						
					case 5:
						 el=lista.borrarFinal();

						JOptionPane.showMessageDialog(null, "El elemento eliminado es: "+el,
								"Eliminando nodo del final",JOptionPane.INFORMATION_MESSAGE);
						break;
					
					case 6:
						el=Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el elemento a eliminar...","Eliminando Nodos en Especifico",
								JOptionPane.INFORMATION_MESSAGE));
						
						if (lista.estaEnLaLista(el))
						{
						lista.eliminar(el);
						JOptionPane.showMessageDialog(null, "El elemento eliminado es: "+el,
								"Eliminando nodo en especifico",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No se ha encontrado el elemento: "+el,
									"Eliminando nodo en especifico",JOptionPane.ERROR_MESSAGE);
						}
						break;
					
					case 7:
						lista.eliminarTodo();
						JOptionPane.showMessageDialog(null, "Se ha eliminado todo");
						break;
						
					case 8:
						el=Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el elemento a buscar...","Buscando Nodos en la Lista",
								JOptionPane.INFORMATION_MESSAGE));
						
						if (lista.estaEnLaLista(el))
						{
							JOptionPane.showMessageDialog(null, "El elemento " + el + " si esta en la lista",
									"Nodo Encontrado",JOptionPane.INFORMATION_MESSAGE);
						}
						
						else{
							JOptionPane.showMessageDialog(null, "El elemento " + el + " no esta en la lista",
									"Nodo no Encontrado",JOptionPane.ERROR_MESSAGE);
						}
						break;
						
					case 9:
						JOptionPane.showMessageDialog(null, "Programa finalizado");
						break;
						
					default:
						JOptionPane.showMessageDialog(null,"Opcion incorrecta","ERROR",
								JOptionPane.ERROR_MESSAGE);
						break;
				}
			} 
			catch (Exception e)
			{
				if (e.getMessage() == null)
				{
				JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),
						"No hay algun elemento que eliminar",JOptionPane.ERROR_MESSAGE);
				}
				
				else
					JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),
							"Sucedio un error ",JOptionPane.ERROR_MESSAGE);
			}
		}
		while(opcion!=9);
	}
}
