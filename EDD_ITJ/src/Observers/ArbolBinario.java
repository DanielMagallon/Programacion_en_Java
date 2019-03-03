package Observers;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class ArbolBinario
{
	public NodoArbol raiz;
	  
	public ArbolBinario(int datoRaiz)
	{
		raiz = new NodoArbol(datoRaiz);
	}
	
	public ArbolBinario()
	{
		// TODO Auto-generated constructor stub
	}
	
	
	public void insert(int dato)
	{
		NodoArbol nuevo = new NodoArbol(dato);
		
		if(raiz==null)
		{
			raiz = nuevo;
		}
		else
		{
			NodoArbol aux = raiz,padre;
			
			while(true)
			{
				padre = aux;
				
				if(dato<aux.dato)
				{
					aux = aux.hijoIzquierdo;
					
					if(aux == null)
					{
						padre.hijoIzquierdo=nuevo;
						nuevo.padre = padre;
						return;
					}
				}
				else if(dato>aux.dato){
					aux = aux.hijoDerecho;
					
					if(aux==null)
					{
						padre.hijoDerecho = nuevo;
						nuevo.padre = padre;
						return;
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No se pueden agregar repetidos");
					return;
				}
				
			}
		}
	}
	
	LinkedList<NodoArbol> elementosOrdenados = new LinkedList<>();
	//en orden alfabetico
	public /*void*/ArbolBinario inOrden(NodoArbol r, boolean agregar)
	{
		if(r!=null)
		{
			inOrden(r.hijoIzquierdo,agregar);
			//inOrden(r.hijoDerecho); //Orden alafabetico empeando de mayor a menr Z-A
			//System.out.print (r.dato + ", ");
			if(agregar)
				elementosOrdenados.add(r);
				
			else System.out.print(r.dato+", ");
			//inOrden(r.hijoIzquierdo); //Orden alafabetico empeando de mayor a menr Z-A
			inOrden(r.hijoDerecho,agregar);
		}
		
		return this;
	}
	
	public ArbolBinario preOrden(NodoArbol r)
	{
		if(r!=null)
		{
			System.out.print(r.dato + ", ");
//			System.out.print(r.val+", ");
			preOrden(r.hijoIzquierdo);
			preOrden(r.hijoDerecho);
		}
		return this;
	}
	
	public ArbolBinario postOrden(NodoArbol r)
	{
		if(r!=null)
		{
			postOrden(r.hijoIzquierdo);
			postOrden(r.hijoDerecho);
			System.out.print(r.dato + ", ");
//			System.out.print(r.val+", ");
		}
		return this;
		
	}
	
	public void porNivel()
	{
		if(raiz!=null)
		{
			System.out.print("Nivel 1: "+raiz+"\n");
			
			ArrayList<NodoArbol> lista1,lista2 = new ArrayList<>();
			int nivel=2;
			NodoArbol aux = raiz;
			lista1 = getNodes(aux);
			
			if(!lista1.isEmpty())
			{
				System.out.print("Nivel 2: ");
				mostrarHijos(aux);	
				System.out.println();
				
				while(tieneHijos(lista1))
				{
					nivel++;

					System.out.printf("Nivel %d: ",nivel);
					
					for(NodoArbol n : lista1)
					{
						mostrarHijos(n);
						lista2.addAll(getNodes(n));
					}
					System.out.println();
					
					lista1.clear();
					lista1.addAll(lista2);
					lista2.clear();
				}
			}
		}
	}
	
	public boolean tieneHijos(ArrayList<NodoArbol> lista1)
	{
		for(NodoArbol n : lista1)
		{
			if(n.hijoDerecho != null || n.hijoIzquierdo!=null)
				return true;
		}
		
		return false;
	}

	public void mostrarHijos(NodoArbol aux)
	{
		if(aux.hijoIzquierdo!=null)
			System.out.print(" "+aux.hijoIzquierdo);
		
		if(aux.hijoDerecho!=null)
			System.out.print(" "+aux.hijoDerecho);
		
	}

	public ArrayList<NodoArbol> getNodes(NodoArbol aux)
	{
		ArrayList<NodoArbol> hijos = new ArrayList<>();
		
		if(aux.hijoIzquierdo!=null)
			hijos.add(aux.hijoIzquierdo);
		
		if(aux.hijoDerecho!=null)
			hijos.add(aux.hijoDerecho);
		
		return hijos;
	}
	
	public void println()
	{
		System.out.println();
	}
	
	public void eliminar(int dato, boolean cop)
	{
		NodoArbol eliminar = localizar(dato);
		
		if(eliminar!=null)
		{
			if(eliminar.hijoIzquierdo == null && eliminar.hijoDerecho == null)
			{//no tiene hijos
				elimnarSinHijos(eliminar);
			}
			
			else if(tieneUnHijo(eliminar))
			{
				eliminarConUnHijo(eliminar);
			}
			
			else
			{
				if(cop)
					eliminarConDosHijosXCop(eliminar);
				else
					eliminarPorFusion(eliminar);
			}
		}
		else System.out.println("No existe "+dato+" dentro del arbol");
		
	}
	
	private void eliminarPorFusion(NodoArbol elim)
	{
		NodoArbol suc = localizarSucesor(elim);
		
		
		suc.hijoDerecho = elim.hijoDerecho;
		elim.hijoDerecho.padre = suc;
		
		if(elim == raiz)
		{
			raiz = elim.hijoIzquierdo;
			raiz.padre = null;
		}
		else
		{
			NodoArbol antElim = elim.padre;
			
			if(antElim.hijoDerecho == elim)
			{
				antElim.hijoDerecho =  elim.hijoIzquierdo;
				
			}
			else{
				antElim.hijoIzquierdo = elim.hijoIzquierdo;
			}
			
			elim.hijoIzquierdo.padre = antElim;
		}
	}
	
	private void eliminarConDosHijosXCop(NodoArbol elim)
	{
		NodoArbol sucesor = localizarSucesor(elim);
		elim.dato = sucesor.dato;
		//Error
		if(sucesor.hijoIzquierdo != null)
		{
			NodoArbol antSuc = sucesor.padre;
			if(antSuc.hijoDerecho == sucesor)
				antSuc.hijoDerecho = sucesor.hijoIzquierdo;

			else
				antSuc.hijoIzquierdo = sucesor.hijoIzquierdo;
				
			sucesor.hijoIzquierdo.padre = antSuc;
			
			
		}
		else //no tiene hijoIqz
		{
			NodoArbol antSuc = sucesor.padre;
			
			if(antSuc.hijoIzquierdo == sucesor)
			{
				antSuc.hijoIzquierdo = null;
			}
			
			
			else
			{
				antSuc.hijoDerecho = null;
				
			}
			
		}
	}
	
	private NodoArbol localizarSucesor(NodoArbol elim)
	{
		NodoArbol hi = elim.hijoIzquierdo;
		
		while(hi.hijoDerecho!=null)
		{
			hi = hi.hijoDerecho;
		}
		
		
		
		//while( (hi = hi.hijoDerecho) != null);
		
		return hi;
	}
	
	private boolean tieneUnHijo(NodoArbol eliminar)
	{
		return (eliminar.hijoIzquierdo==null && eliminar.hijoDerecho != null) || (eliminar.hijoIzquierdo!=null && eliminar.hijoDerecho == null);
	}
	
	private NodoArbol localizar(int dato)
	{
		NodoArbol rec = raiz;
		
		while(rec!=null)
		{
			if(dato>rec.dato)
			{
				rec = rec.hijoDerecho;
			}
			
			else if(dato<rec.dato)
			{
				rec = rec.hijoIzquierdo;
			}
				
			
			else {
				return rec;
			}
		}
		
		return null;
	}
	
	public void elimnarSinHijos(NodoArbol elim)
	{
		NodoArbol padre = elim.padre;
		
		if(padre == null)
		{
			raiz = null;
		}
		
		else
		{
			if(padre.hijoIzquierdo == elim)
				padre.hijoIzquierdo = null;
		
			else padre.hijoDerecho = null;
		}
	}
	
	public void eliminarConUnHijo(NodoArbol elim)
	{
		NodoArbol padre = elim.padre;
		
		//Raiz
		if(padre==null)
		{
			if(elim.hijoIzquierdo != null)
				raiz = elim.hijoIzquierdo;
			
			else raiz = elim.hijoDerecho;
			
			raiz.padre = null;
		}
		else
		{
			if(padre.hijoIzquierdo == elim)//El elelmento a elimiar esta en la rama izq 
			{
				if(elim.hijoIzquierdo != null)
				{//tiene hijo izq
					padre.hijoIzquierdo = elim.hijoIzquierdo;
					elim.hijoIzquierdo.padre = padre;
				}
				else
				{//tiene hijo der
					padre.hijoIzquierdo = elim.hijoDerecho;
					elim.hijoDerecho.padre = padre;
				}
			}
			else
			{
				if(elim.hijoIzquierdo != null)
				{//tiene hijo izq
					padre.hijoDerecho = elim.hijoIzquierdo;
					elim.hijoIzquierdo.padre = padre;
				}
				else
				{//tiene hijo der
					padre.hijoDerecho = elim.hijoDerecho;
					elim.hijoDerecho.padre = padre;
				}
			}
		}
	}
	
	public void balancear()
	{
		elementosOrdenados.clear();
		
		inOrden(raiz, true);
		raiz = null;
		System.out.println("Ordenados: "+elementosOrdenados+"("+elementosOrdenados.size()+" datos)\n");
		
		balanceo(0, elementosOrdenados.size()-1,elementosOrdenados);
	}
	
	private void balanceo(int min, int max, LinkedList<NodoArbol> list)
	{
		if(min<=max)
		{
			int div = (min+max)/2;
			
			insert(list.get(div).dato);
			
			balanceo(min, div-1, list);
			balanceo(div+1, max, list);
		}
	}

	public void eliminarNodosHoja(NodoArbol r)
	{
		if(r!=null)
		{
			if(r.hijoDerecho==null &&  r.hijoIzquierdo==null)
			{
//				System.out.println("Es un nodo hoja "+r);
				if(r.padre.hijoDerecho!=null && r.padre.hijoDerecho.dato==r.dato)
				{
					r.padre.hijoDerecho=null;
				}
				else{
					r.padre.hijoIzquierdo=null;
				}
					
			}
			else{
				eliminarNodosHoja(r.hijoDerecho);
				eliminarNodosHoja(r.hijoIzquierdo);
			}
		}
	}
	
	public void mostrarNodosDeRamaDerecha()
	{
		System.out.print("Nodos de la rama derecha: ");
		preOrden(raiz.hijoDerecho).println();
	}
	
	/**
	 * Metodo 1 Examen
	 * @param dato
	 */
	
	public void mostrarHijosDeNodo(int dato)
	{
		NodoArbol nodo = localizar(dato);

		if(nodo!=null)
		{
			if(nodo.hijoIzquierdo!=null)
			{
				System.out.printf("Hijo izquierdo del nodo %d: %d\n",dato,nodo.hijoIzquierdo.dato);
			}
			else System.out.printf("El nodo %d no tiene hijo izquierdo\n",dato);
			
			if(nodo.hijoDerecho!=null)
			{
				System.out.printf("Hijo derecho del nodo %d: %d\n",dato,nodo.hijoDerecho.dato);
			}
			else System.out.printf("El nodo %d no tiene hijo derecho\n",dato);
			
			System.out.println();
		}
		else System.out.println("El nodo "+dato+" no se encuetra dentro del arbol");
	}
	
	/**
	 * Metodo 2 Examen
	 */
	
	ArrayList<NodoArbol> nodosHoja = new ArrayList<>();
	
	public int eliminarHojaMasPequena()
	{
		nodosHoja.clear();
		localizarNodosHoja(raiz.hijoDerecho);
		
		if(!nodosHoja.isEmpty())
		{
			NodoArbol elim = nodosHoja.get(0);
			int min = elim.dato;
			
			for(int i=1; i<nodosHoja.size(); i++)
			{
				if(nodosHoja.get(i).dato<min)
				{
					min = nodosHoja.get(i).dato;
					elim = nodosHoja.get(i);
				}
			}
			
			eliminar(elim.dato, true);
			return elim.dato;
		}
		
		return -1;
	}
	
	public void mostrarHijosIzq(NodoArbol nodo)
	{
		if(nodo!=null)
		{
			System.out.print(nodo.dato + ", ");
			mostrarHijosIzq(nodo.hijoIzquierdo);
			
			if(nodo.hijoDerecho!=null)
				mostrarHijosIzq(nodo.hijoDerecho.hijoIzquierdo);
		}
	}
	
	private void localizarNodosHoja(NodoArbol r)
	{
		if(r!=null)
		{
			if(r.hijoDerecho==null &&  r.hijoIzquierdo==null)
			{
				nodosHoja.add(r);
				
			}
			else{
				localizarNodosHoja(r.hijoDerecho);
				localizarNodosHoja(r.hijoIzquierdo);
			}
		}
	}
	
	/**
	 * 
	 * Edgar Magallon
	 */
	static ArbolBinario arbol = new ArbolBinario();
	public static void main(String[] args)
	{
	
		int datos[] = 
		{
			   60,40,80,30,45,42,35,20,70,47,100,38
		};
		
		
		
		for(int c : datos)
			arbol.insert(c);

		arbol.mostrarHijosIzq(arbol.raiz.hijoDerecho);
		
//		arbol.porNivel();
//		System.out.println();
//		arbol.mostrarHijosDeNodo(80);
//		System.out.println();
//		
//		eliminandoHojaPequena();
//		eliminandoHojaPequena();
//		eliminandoHojaPequena();
//		eliminandoHojaPequena();
//		
	}
	
	static void eliminandoHojaPequena()
	{
		int val = arbol.eliminarHojaMasPequena();
		
		System.out.println("\nELiminando hoja mas pequena de la rama derecha... ");
		if(val==-1)
		{
			System.out.println("No es posible eliminar mas hojas");
		}
		else
		{
			
			System.out.printf("Se elimino la hoja: %d\n\n",val);
		}
		System.out.println();
		arbol.porNivel();
	}
}
