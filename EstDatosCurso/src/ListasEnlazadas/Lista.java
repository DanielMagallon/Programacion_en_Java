package ListasEnlazadas;

public class Lista
{
	protected Nodo inicio,fin; // Punteros para saber donde esta el incio y el fin
	
	public Lista ()
	{
		inicio=null;
		fin=null;
	}
	
	
	// Metodo para saber si la lista esta vacia
	public boolean estaVacia()
	{
		if (inicio==null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	// metodo para agregar un nodo al incio de la lista
		public void agregarAlInicio(int elemento)
		{
			// Creando al nodo
			inicio=new Nodo(elemento, inicio);
			
			if (fin==null)
			{
				fin=inicio;
			}
		}
	
	//Metodo para insertar al final de la lista
	public void agregarAlFinal(int elemento)
	{
		if (!estaVacia())
		{
			fin.siguiente=new Nodo(elemento);
			fin=fin.siguiente;
		}
		
		else
		{
			inicio=fin=new Nodo(elemento);
		}
	}

	// meotod para mostrar datos
	public void mostrarLista()
	{
		Nodo recorrer=inicio;
		System.out.println();
		while (recorrer!=null)
		{
			System.out.print ("["+recorrer.dato+"]--->");
			recorrer=recorrer.siguiente;
		}
	}
	
	// Metodo para eliminar un Nodo del incio
	public int borrarInicio()
	{
		int elemento=inicio.dato;
		
		if (inicio==fin)
		{
			inicio=fin=null;
		}
		
		else
		{
			inicio=inicio.siguiente;
		}
		
		return elemento;
	}
	
	// Metodo para elimar un Nodo del final
	public int borrarFinal()
	{
		
		int elemento=fin.dato;
		
	if (!estaVacia())
	{
		if (inicio==fin)
		{
			inicio=fin=null;
		}
		
		else
		{
			Nodo temporal = inicio;
			
			while (temporal.siguiente!=fin)
			{
				temporal=temporal.siguiente;
			}
			
			fin=temporal;
			fin.siguiente=null;
		}	
		
	}
		return elemento;
	}
	
	// Metodo borrar un elemto especifico
	public void eliminar(int elemento)
	{
		if (!estaVacia())
		{
			
			if (inicio==fin && elemento==inicio.dato)
			{
				inicio=fin=null;
			}
			
			else 
				if (elemento==inicio.dato)
			{
				
				inicio=inicio.siguiente;
			}
			else
			{
				Nodo anterior,temporal;
				anterior=inicio;
				temporal=inicio.siguiente;
				
				
				while (temporal!=null && temporal.dato!=elemento)
				{
					anterior=anterior.siguiente;
					temporal=temporal.siguiente;
				}
				
				if (temporal!=null)
				{
					anterior.siguiente=temporal.siguiente;
					
						if (temporal==fin)
						{
							fin=anterior;
						}
				}
			}
		}
	
	}
	
	// Metodo para borrar todos los elementos de la lista
	public void eliminarTodo()
	{
		if (!estaVacia())
		{
			if (inicio==fin)
			{
				inicio=fin=null;
			}
			
			else
			{
				while (inicio != null)// && fin !=null)
				{
					inicio=inicio.siguiente=null;
					fin=fin.siguiente=null;
				}
			}
		}
	}
	
	// metodo para buscar un elemento
	public boolean estaEnLaLista(int elemento)
	{
		Nodo temporal=inicio;
		
		while (temporal != null && temporal.dato != elemento)
		{
			temporal=temporal.siguiente;
		}
		
		return temporal!=null; // si lo es retornara true
	}
	
	public static void main(String[] args) 
	{
		Lista list = new Lista();
	
		list.agregarAlInicio(8);
		list.agregarAlInicio(7);
		list.agregarAlInicio(6);
		list.agregarAlInicio(5);
		
		list.eliminar(8);
		list.mostrarLista();
	}
}
