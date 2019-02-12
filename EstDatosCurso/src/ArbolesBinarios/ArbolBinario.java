package ArbolesBinarios;

public class ArbolBinario
{
	NodoArbol raiz;
	
	public ArbolBinario()
	{
		raiz=null;
	}
	
	//Insertar nodos en el arbol
	public void AgregarNodo(int d, String nom)
	{
		NodoArbol nuevo = new NodoArbol(d,nom);
		
		if(raiz==null)
		{
			raiz=nuevo;
		}
		else
		{
			NodoArbol auxiliar=raiz;
			NodoArbol padre;
			
			while(true)
			{
				padre=auxiliar;
				
				if(d<auxiliar.dato)
				{
					auxiliar=auxiliar.hijoIzquierdo;
					if(auxiliar==null)
					{
						padre.hijoIzquierdo=nuevo;
						return;
					}
				}
				
				else
				{
					auxiliar=auxiliar.hijoDerecho;
					if(auxiliar==null)
					{
						padre.hijoDerecho=nuevo;
						return;
					}
				}
			}
		}
	}
	
	//Esta vacio
	public boolean estaVacio()
	{
		return raiz==null;
	}
	
	//Metodo para recorrer el Arbol InOrden
	public void inOrden(NodoArbol r)
	{
		if(r!=null)
		{
			inOrden(r.hijoIzquierdo);
			System.out.print (r.dato + ", ");
			inOrden(r.hijoDerecho);
		}
	}
	
	//Recorrer en PreOrden
	public void preOrden(NodoArbol r)
	{
		if(r!=null)
		{
			System.out.print(r.dato + ", ");
			preOrden(r.hijoIzquierdo);
			preOrden(r.hijoDerecho);
		}
	}
	
	//Recorrer en PostOrden
	public void postOrden(NodoArbol r)
	{
		if(r!=null)
		{
			postOrden(r.hijoIzquierdo);
			postOrden(r.hijoDerecho);
			System.out.print(r.dato + ", ");
		}
	}
	
	//Buscar un Nodo en Arbol
	public NodoArbol BuscarNodo(int d)
	{
		NodoArbol aux=raiz;
		
		while(aux.dato!=d)
		{
			if(d<aux.dato)
				aux=aux.hijoIzquierdo;
			else
				aux=aux.hijoDerecho;
			
			if(aux==null)
				return null;
		}
		
		return aux;
	}
	
	public boolean EliminarNodo(int d)
	{
		NodoArbol aux=raiz;
		NodoArbol padre=raiz;
		
		boolean esHijoIzq=true;
		
		while(aux.dato!=d)
		{
			padre=aux;
			
			if(d<aux.dato)
			{
				esHijoIzq=true;
				aux=aux.hijoIzquierdo;
			}
			else
			{
				esHijoIzq=false;
				aux=aux.hijoDerecho;
			}
			if(aux==null){
				return false;
			}
		} //Fin del while
		
		if(aux.hijoIzquierdo==null && aux.hijoDerecho==null)
		{
			if(aux==raiz)
				raiz=null;
			
			else if(esHijoIzq)
				padre.hijoIzquierdo=null;
			
			else
				padre.hijoDerecho=null;
		}
		else if(aux.hijoDerecho==null)
		{
			if(aux==raiz)
				raiz=aux.hijoIzquierdo;
			
			else if(esHijoIzq)
				padre.hijoIzquierdo=aux.hijoIzquierdo;
			
			else
				padre.hijoDerecho=aux.hijoIzquierdo;
		}
		else if(aux.hijoIzquierdo==null)
		{
			if(aux==raiz)
				raiz=aux.hijoDerecho;
			
			else if(esHijoIzq)
				padre.hijoIzquierdo=aux.hijoDerecho;
			
			else
				padre.hijoDerecho=aux.hijoIzquierdo;
		}
		else
		{
			NodoArbol remplazo=obtenerNodoReemplazo(aux);
			
			if(aux==raiz)
				raiz=remplazo;
			else if (esHijoIzq)
				padre.hijoIzquierdo=remplazo;
			else
				padre.hijoDerecho=remplazo;
				
			remplazo.hijoIzquierdo=aux.hijoIzquierdo;
		}
		return true;
	}
	
	//Metodo para devolver el NodoReemplazo
	public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReem)
	{
		NodoArbol remplazarPadre=nodoReem;
		NodoArbol remplazo=nodoReem;
		NodoArbol aux=nodoReem.hijoDerecho;
		
		while(aux!=null)
		{
			remplazarPadre=remplazo;
			remplazo=aux;
			aux=aux.hijoIzquierdo;
		}
		
		if(remplazo!=nodoReem.hijoDerecho)
		{
			remplazarPadre.hijoIzquierdo=remplazo.hijoDerecho;
			remplazo.hijoDerecho=nodoReem.hijoDerecho;
		}
		System.out.println("El Nodo Remplazo es: "+remplazo);
		return remplazo;
	}
}
