package Evaluacion3;

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
	
	NodoArbol nodo;
	public void l()
	{
		nodo = raiz;
		
	}
	
	public ArbolBinario preOrden(NodoArbol r)
	{
		if(r!=null)
		{
//			if(r.v)
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
			if(dato>0)
			{
				rec = rec.hijoDerecho;
			}
			
			else if(dato<0)
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
	
	/**
	 * 
	 * Metodo 1-Evalucacion
	 */
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
	
	/**
	 * Metodo 2-Evaluacion
	 */
	
	public void mostrarNodosDeRamaDerecha()
	{
		System.out.print("Nodos de la rama derecha: ");
		preOrden(raiz.hijoDerecho).println();
	}
	
	/**
	 * 
	 * Edgar Magallon
	 */
	public static void main(String[] args)
	{
		
		ArbolBinario arbol = new ArbolBinario();
	
		int datos[] = 
		{
			   60,40,120,30,50,90,150,45,80,95,97,145,160
		};
		
		
		for(int c : datos)
			arbol.insert(c);
		
		arbol.porNivel();
		System.out.println("----");
		arbol.mostrarNodosDeRamaDerecha();
		
		System.out.println("\nArbol sin los  nodos hoja:\n");
		arbol.eliminarNodosHoja(arbol.raiz);
		
		arbol.porNivel();
	}
}
