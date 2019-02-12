package Pilas;

import javax.swing.JOptionPane;

public class PilaApp
{
	public static void main(String[] args)
	{
		int opcion=0,elemento;
		
		try
		{	
			Pila pila = new Pila();
			
			do
			{
				opcion=Integer.parseInt(
						JOptionPane.showInputDialog(null,
								"1. Empujar un elemento en la Pila\n"
								+ "2. Sacar un elemento de la Pila\n"
								 + "3. ¿La Pila esta Vacia?\n"
								 + "4. ¿Que elemento esta en la Cima?\n"
								 + "5. Tamaño de la Pila\n"
								 + "6. Mostrar Elementos de la Pila\n"
								 + "7. Limpiar Pila\n"
								 + "8. Salir\n"
								 + "Que desea hacer?","Menu de Opciones",
								 JOptionPane.INFORMATION_MESSAGE));
				
				switch (opcion)
				{
					case 1:
						
						elemento=Integer.parseInt(
								JOptionPane.showInputDialog(null,
								"Ingrese el elemento",
								"Empjunado Elemento",
								JOptionPane.INFORMATION_MESSAGE));
						pila.push(elemento);
						
					break;
					
					case 2:
						if(!pila.estaVacia())
						{
							JOptionPane.showMessageDialog(null, 
									"El elemento sacado de la pila es: "+pila.pop(),
									"Sacando Elemento",
									JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"La Pila Esta Vacia",
									"Pila Vacia",
									JOptionPane.INFORMATION_MESSAGE);
						}
						break;
						
					case 3:
						JOptionPane.showMessageDialog(null,
								String.format("La Pila %s vacia",
										(pila.estaVacia()) ? "está" : "no está"),
										 "Mensaje",
										 JOptionPane.INFORMATION_MESSAGE);
						break;
						
					case 4:
						if(!pila.estaVacia())
						{
						JOptionPane.showMessageDialog(null, 
								"El elemento "+pila.cima() + " está en la cima",
								"Cima",
								JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"La Pila Esta Vacia",
									"Pila Vacia",
									JOptionPane.INFORMATION_MESSAGE);
						}
						break;
						
					case 5:
						JOptionPane.showMessageDialog(null, 
								"Tamaño de la pila: "+pila.size(),
								"Tamaño",
								JOptionPane.INFORMATION_MESSAGE);
						break;
						
					case 6:
						if(!pila.estaVacia())
						{
						JOptionPane.showMessageDialog(null, pila.displayAll(),
								"Elementos de la Pila",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"La Pila Esta Vacia",
									"Pila Vacia",
									JOptionPane.INFORMATION_MESSAGE);
						}
						break;
						
					case 7:
						if(!pila.estaVacia())
						{
						pila.clean();
						JOptionPane.showMessageDialog(null, "Se han eliminado completamente "
								+ "los elementos de la Pila","Limpiando Pila",
								JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"La Pila Esta Vacia",
									"Pila Vacia",
									JOptionPane.INFORMATION_MESSAGE);
						}
						break;
						
					case 8:
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
			while(opcion!=8);
		} 
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, 
					"Error "+e.getMessage());
		}
	}
	
}
