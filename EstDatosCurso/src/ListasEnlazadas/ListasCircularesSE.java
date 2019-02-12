package ListasEnlazadas;

import javax.swing.JOptionPane;

public class ListasCircularesSE
{
	NodoLC ultimo;
	
	public ListasCircularesSE()
	{
		ultimo=null;
	}
	
	//Metodo para saber cuando la lista esta vacia
	public boolean estaVacia()
	{
		return ultimo==null;
	}
	
	//Metodo para insertar Nodos
	public ListasCircularesSE insertarNodo(int elemento)
	{
		NodoLC nuevo =  new NodoLC(elemento);
		
		if(ultimo!=null)
		{
			nuevo.siguiente=ultimo.siguiente;
			ultimo.siguiente=nuevo;
		}
		ultimo=nuevo;
		return this;
	}
	
	//Metodo para eliminar un nodo de la lista ciruclar
	public boolean eliminar(int elemento)
	{
		NodoLC actual;
		boolean encontrada=false;
		actual=ultimo;
		
		while(actual.siguiente!=ultimo && !encontrada)
		{
			encontrada=(actual.siguiente.dato==elemento);
			
			if (!encontrada)
			{
				actual=actual.siguiente;
			}
		}
		encontrada=(actual.siguiente.dato==elemento);
		
		if(encontrada)
		{
			NodoLC auxiliar=actual.siguiente;
			
			if (ultimo==ultimo.siguiente)
			{
				ultimo=null;
			}
			else 
			{
				if(auxiliar==ultimo)
				{
					ultimo=actual;
				}
				actual.siguiente=auxiliar.siguiente;
			}
			
			auxiliar=null;
		}
		
		return encontrada==true;
	}
	
	//Metodo para mostrar la lista
	public void mostrarLista()
	{
		NodoLC aux=ultimo.siguiente;
		String cadena="";
		
		do
		{
			cadena+= "["+aux.dato+"]->";
			aux=aux.siguiente;
		} 
		while (aux!=ultimo.siguiente);
		
		JOptionPane.showMessageDialog(null, cadena, 
				"MOSTRANDO LA LISTA CIRCULAR",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
