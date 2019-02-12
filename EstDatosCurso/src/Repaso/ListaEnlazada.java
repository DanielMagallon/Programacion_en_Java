package Repaso;

public class ListaEnlazada 
{
	Nodo inicio,fin;
	
	public void nodoAlinicio(int n, String x)
	{
		inicio = new Nodo(n, x,inicio);
		
		if(fin==null)
		{
			fin=inicio;
		}
	}
	
	public void nodoFinal(int n, String x)
	{
		if (!estaVacia())
		{
			fin.next = new Nodo(n,x);
			fin=fin.next;
		}
		
		else
		{
			inicio=fin=new Nodo(n,x);
		}
	}
	
	public void mostrarLista()
	{
		Nodo aux = inicio;
		
		while(aux!=null)
		{
			aux.mostrarDatos();
			aux = aux.next;
		}
	}
	
	public boolean estaVacia()
	{
		return inicio==null;
	}
	
	public static void main(String[] args) {
		
		ListaEnlazada le = new ListaEnlazada();
		
//		le.nodoFinal(-1, "M");
//		le.nodoAlinicio(0, "Edgar");
//		le.nodoAlinicio(1, "Daniel");
//		le.nodoFinal(2, "Marsha");
//		le.nodoFinal(3, "Sebas");
		le.nodoAlinicio(4, "Eds");
		
		le.mostrarLista();
	}
}
