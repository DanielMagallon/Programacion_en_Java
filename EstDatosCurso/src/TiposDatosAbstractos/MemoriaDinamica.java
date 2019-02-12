package TiposDatosAbstractos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemoriaDinamica 
{
	public static void main(String[] args) 
	{
		/*
		 * Metodos del arrayList: 
		 * .- add: Perimite agregar datos a una lista de elemntos
		 * .- get: Obtiene un elemnto de la lista medinate un inidice
		 * .- set: Asignar elemntos a la lista(editar)
		 * .- remove: Para eliminar un elemento de la lista
		 * .- size: Para obtener el tamaño del arreglo
		 */
		
		ArrayList <String> cadenas = new ArrayList<String>();
		String frase,respuesta;
		
		do
		{
			frase=JOptionPane.showInputDialog(null,"Ingresa la frase");
			cadenas.add(frase);
			
			respuesta=JOptionPane.showInputDialog(null, "Desea seguir ingresando?",
					"CONTINUAR??",JOptionPane.QUESTION_MESSAGE);
		}
		while (!respuesta.equalsIgnoreCase("No"));
		
		System.out.println ("\nDatos introducidos:");
		
		System.out.println("Con for mejorado:");
		
		for (String i : cadenas)
		{
			System.out.printf ("%s\n",i);
		}
		
		System.out.println("\nCon for normal:");
		
		for (int i=0; i<cadenas.size(); i++)		
		{
			System.out.printf ("%s\n",cadenas.get(i));
		}
		
		cadenas.set(0,"Modificado");
		System.out.println("\nArreglo modificado de la posicion 1");
		
		for (String i : cadenas)
		{
			System.out.printf ("%s\n",i);
		}
		
		cadenas.remove(0);
		System.out.println("\nBorrando el objeto de la posicion 0");
		
		for (String i : cadenas)
		{
			System.out.printf ("%s\n",i);
		}
	}
}
