package ArbolesBinarios;

import javax.swing.JOptionPane;

public class ClasePrincipal
{
	public static void main(String[] args)
	{
		int opcion=0, elemento;
		String nombre;
		ArbolBinario arbol = new ArbolBinario();
		
		do{
			try{
				opcion=Integer.parseInt(
						JOptionPane.showInputDialog(
						null,"1. Agregando un Nodo\n"
						   + "2. Recorrer el Arbol InOrden\n"
						   + "3. Recorrer el Arbol en PreOrden\n"
						   + "4. Recorrer el Arbol en PostOrden\n"
						   + "5. Buscar un Nodo en el Arbol\n"
						   + "6. Eliminar un Nodo del Arbol\n"
						   + "7. Salir\n"
						   + " Elige una opcion: ",
						   "Menu Arboles Binarios",
						   JOptionPane.QUESTION_MESSAGE));
				
				switch (opcion)
				{
					case 1:
					 elemento=Integer.parseInt(JOptionPane.
						showInputDialog(null,"Ingresa el Numero Nodo...",
						"Agregando Nodo",JOptionPane.QUESTION_MESSAGE));
					 
					 nombre=JOptionPane.showInputDialog(null,
							 "Ingresa el Nombre del Nodo...",
							 "Agregando Nodo",JOptionPane.QUESTION_MESSAGE);
					 arbol.AgregarNodo(elemento, nombre);
					 
					 break;
					 
					case 2:
						if(!arbol.estaVacio()){
							System.out.println();
							arbol.inOrden(arbol.raiz);
						}else{
							JOptionPane.showMessageDialog(null,"El Arbol esta vacio",
									"Cuidado",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
						
					case 3:
						if(!arbol.estaVacio()){
							System.out.println();
							arbol.preOrden(arbol.raiz);
						}else{
							JOptionPane.showMessageDialog(null,"El Arbol esta vacio",
									"Cuidado",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
						
					case 4:
						if(!arbol.estaVacio()){
							System.out.println();
							arbol.postOrden(arbol.raiz);
						}else{
							JOptionPane.showMessageDialog(null,"El Arbol esta vacio",
									"Cuidado",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
						
					case 5:
						if(!arbol.estaVacio()){
							elemento=Integer.parseInt(JOptionPane.
									showInputDialog(null,"Ingresa el Numero del Nodo Buscado...",
									"Buscando Nodo",JOptionPane.QUESTION_MESSAGE));
							
							if(arbol.BuscarNodo(elemento)==null)
							{
								JOptionPane.showMessageDialog(null,"Nodo no se encuentra en el Arbol",
										"Nodo no Encontrado",JOptionPane.INFORMATION_MESSAGE);
							}else{
								
								System.out.println("Nodo Encontrado, sus datos son: " 
								+arbol.BuscarNodo(elemento));
							}
								
								
						}else{
							JOptionPane.showMessageDialog(null,"El Arbol esta vacio",
									"Cuidado",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					
					case 6:
						if(!arbol.estaVacio()){
							elemento=Integer.parseInt(JOptionPane.
									showInputDialog(null,"Ingresa el Numero del Nodo a Eliminar...",
									"Eliminando Nodo",JOptionPane.QUESTION_MESSAGE));
							
							if(arbol.EliminarNodo(elemento)==false)
							{
								JOptionPane.showMessageDialog(null,"Nodo no se encuentra en el Arbol",
										"Nodo no Encontrado",JOptionPane.INFORMATION_MESSAGE);
							}else{
								
								JOptionPane.showMessageDialog(null, "El Nodo ha Sido Eliminado",
										"Nodo Elimindo¡",JOptionPane.INFORMATION_MESSAGE);
							}
								
								
						}else{
							JOptionPane.showMessageDialog(null,"El Arbol esta vacio",
									"Cuidado",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
						
					case 7:
						JOptionPane.showMessageDialog(null,"Aplicacion Finalizada",
								"Fin",JOptionPane.INFORMATION_MESSAGE);
						break;
						
					default:
						JOptionPane.showMessageDialog(null,"Opcion Incorrecta",
								"Cuidado¡¡",JOptionPane.INFORMATION_MESSAGE);
						break;
						
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
				
			}
		}
		while(opcion!=7);
	}
}
