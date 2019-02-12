package Pilas;

import javax.swing.JOptionPane;

public class PilaEstaticaApp
{
	public static void main(String[] args)
	{
		int opcion=0,elemento,tamanio;
		
		try
		{
			tamanio=Integer.parseInt(
					JOptionPane.showInputDialog(null,
							"De que tamaño quieres la pila?",
							"Solicitando el Tamaño",
							JOptionPane.INFORMATION_MESSAGE));
			
			PilaEstatica pila = new PilaEstatica(tamanio);
			
			do
			{
				opcion=Integer.parseInt(
						JOptionPane.showInputDialog(null,
								"1. Empujar un elemento en la Pila\n"
								+ "2. Sacar un elemento de la Pila\n"
								 + "3. ¿La Pila esta Vacia?\n"
								 + "4. ¿La Pila esta Llena?\n"
								 + "5. ¿Que elemento esta en la Cima?\n"
								 + "6. Tamaño de la Pila\n"
								 + "7. Mostrar Elementos de la Pila\n"
								 + "8. Limpiar Pila\n"
								 + "9. Salir\n"
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
						if(!pila.estaLlena())
						{
							pila.push(elemento);
						}
						else
						{
							JOptionPane.showMessageDialog(null,
									"La Pila Esta Llena",
									"Pila Llena",
									JOptionPane.INFORMATION_MESSAGE);
						}
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

						JOptionPane.showMessageDialog(null,
								String.format("La Pila %s llena",
										(pila.estaLlena()) ? "está" : "no está"),
										 "Mensaje",
										 JOptionPane.INFORMATION_MESSAGE);
						break;
						
					case 5:
						if(!pila.estaVacia())
						{
						JOptionPane.showMessageDialog(null, 
								"El elemento "+pila.cimaPila() + " está en la cima",
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
						
					case 6:
						JOptionPane.showMessageDialog(null, 
								"Tamaño de la pila: "+pila.tamanioPila(),
								"Tamaño",
								JOptionPane.INFORMATION_MESSAGE);
						break;
						
					case 7:
						if(!pila.estaVacia())
						{
						JOptionPane.showMessageDialog(null, pila.mostrarPila(),
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
						
					case 8:
						if(!pila.estaVacia())
						{
						pila.limpiarPila();
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
						
					case 9:
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
			while(opcion!=9);
		} 
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, 
					"Error "+e.getMessage());
		}
	}
}
