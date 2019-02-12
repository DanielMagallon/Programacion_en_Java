package ListasEnlazadas;

import javax.swing.JOptionPane;

public class ListaDoble 
{
	private NodoDoble inicio,fin;
	
	public ListaDoble()
	{
		inicio=fin=null;
	}
	
	// Metodo para saber si la lista esta vacia
	public boolean estaVacia()
	{
		return inicio==null;
	}
	
	// Metodo para agregar nodos al final
	public void agregarAlFinal(int el)
	{
		if (!estaVacia())
		{
			fin=new NodoDoble(el,null,fin);
			fin.anterior.siguiente=fin;
		}
		else
			inicio=fin=new NodoDoble(el);
	}
	
	//Metodo para agregar al incio
	public void agregarAlIncio(int el)
	{
		if (!estaVacia())
		{
			inicio=new NodoDoble(el,inicio,null);
			inicio.siguiente.anterior=inicio;
		}
		else
			inicio=fin=new NodoDoble(el);
	}
	
	//Metodo para mostrar la Lista de incio a fin
	public void mostrarListaInicioFin()
	{
		if (!estaVacia())
		{
			String datos="<=>";
			NodoDoble aux=inicio;
			
			while (aux != null)
			{
				datos += "["+aux.dato+"]<=>";
				aux=aux.siguiente;
			}
			JOptionPane.showMessageDialog(null,datos,
					"Mostrando Lista de Incio a Fin",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo para mostrar de fin a incio
	public void mostrarListaFinInicio()
	{
		if (!estaVacia())
		{
			String datos="<=>";
			NodoDoble aux=fin;
			
			while (aux != null)
			{
				datos += "["+aux.dato+"]<=>";
				aux=aux.anterior;
			}
			JOptionPane.showMessageDialog(null,datos,
					"Mostrando Lista de Incio a Fin",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo para delete start
	public int elminarDelInicio()
	{
		int elemento=inicio.dato;
		
		if(inicio==fin)
		{
			inicio=fin=null;
		}
		else
		{
			inicio=inicio.siguiente;
			inicio.anterior=null;
		}
			
		return elemento;
	}
	
	//Metodopara eliminar del final
	public int eliminarDelFinal()
	{
		int elemento=fin.dato;
		
		if(inicio==fin)
		{
			inicio=fin=null;
		}
		else
		{
			fin=fin.anterior;
			fin.siguiente=null;
		}
			
		return elemento;
	}
}
