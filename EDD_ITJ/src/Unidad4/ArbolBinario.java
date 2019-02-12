package Unidad4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ArbolBinario
{
	/**
	 * Nodo hoja-> no tienen hijos
	 *  Nodos intermedios-> tiene hijos(1,2hijos)
	 */
	
	/**
	 * Eiminacion:
	 * Proceso por copiado: 
	 *  1) Localizar el sucesor del nodo a eliminar
	 *       El sucesor siempre es, del hijo izq el nodo mas a la derecha
	 *  2) e.dato = s.dato; (si tiene hijo izq, mover el hijo izq a la pos del nodo a remplazoo)
	 *  
	 *  Proceso por fusion:
	 *  1) Localizar al sucesr
	 *  -El sucewsor va a tomar la rama derecha del elemento a eliminar como hijoder
	 *  
	 *  }}-si el nodoa eleiminar es la rai entonces la raiz va a sr el hijo izq
	 */
	
	public NodoArbol raiz;
	
	
	//50 70 30 25 45 85 90 60 55 17 9 33 71
	
	/*
	 * a) Dar el grado del Nodo con el valor de 17 = 1; (Numero maximo de hijos que tiene->Grado)
	 * b) Altura del arbol = 5 (niveles);
	 * c) Peso del nodo 85 = 2 (numero de nodos que soporta el nodo) y del Arbol = 12;
	 * d) Esta equilibado el arbol? True: 4 - 3 = 1 | 1<=1; (altura de la rama dere-altura ramaizq);
	 * e) El arbol esa completo? Faalse 
	 * 		Si no, cuantos nodo les faltan = 2^5 - 1 = 31; 31-13(numero de nodos) = 18;
	 * 			Le faltan 18 para estar completo
	 */
	//Tabla de transicciones
	  
	public ArbolBinario(String datoRaiz, int v)
	{
		raiz = new NodoArbol(datoRaiz);
	}
	
	public ArbolBinario()
	{
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<ArrayList<NodoArbol>> list = new ArrayList<>();
	public void porNivel2()
	{
		if(raiz!=null)
		{
			ArrayList<NodoArbol> lista1,lista2 = new ArrayList<>();
			NodoArbol aux = raiz;
			lista1 = new ArrayList<>();
			lista1.add(aux);
			list.add(lista1);
			
			lista1 = getNodes(aux);
			list.add((ArrayList<NodoArbol>) lista1.clone());
			int ind=2;
			if(!lista1.isEmpty())
			{
				while(tieneHijos(lista1))
				{
					
					for(NodoArbol n : lista1)
					{
						lista2.addAll(getNodes(n));
						
					}
					
					list.add((ArrayList<NodoArbol>) lista2.clone());
					
					lista1.clear();
					lista1.addAll(lista2);
					lista2.clear();
				}
			}
		}
	}
	
	public void insert(String dato)
	{
		NodoArbol nuevo = new NodoArbol(dato);
		
		if(raiz==null)
		{
			raiz = nuevo;
		}
		else
		{
			NodoArbol aux = raiz,padre;
			int val;
			
			while(true)
			{
				padre = aux;
				val = dato.compareToIgnoreCase(aux.dato);
//				int x = Integer.parseInt(dato);
				
//				if(x<Integer.parseInt(aux.dato))
				if(val<0)
				{
					aux = aux.hijoIzquierdo;
					
					if(aux == null)
					{
						padre.hijoIzquierdo=nuevo;
						nuevo.padre = padre;
						return;
					}
				}
//				else if(x>Integer.parseInt(aux.dato)){
				else if(val>0){
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
			preOrden(r.hijoIzquierdo);
			preOrden(r.hijoDerecho);
		}
		return this;
	}
	
	public void eliminarNodosHoja(NodoArbol r)
	{
		if(r!=null)
		{
			if(r.hijoDerecho==null &&  r.hijoIzquierdo==null)
			{
//				System.out.println("Es un nodo hoja "+r);
				if(r.padre.hijoDerecho!=null && r.padre.hijoDerecho.dato.equals(r.dato))
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
	
	public void postOrden(NodoArbol r)
	{
		if(r!=null)
		{
			postOrden(r.hijoIzquierdo);
			postOrden(r.hijoDerecho);
			
			
				System.out.print(r.dato + ", ");
//			System.out.print(r.val+", ");
		}
		
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
	
	public void eliminar(String nombre, boolean cop)
	{
		NodoArbol eliminar = localizar(nombre);
		
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
		else System.out.println("No existe "+nombre+" dentro del arbol");
		
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
	
	private NodoArbol localizar(String nombre)
	{
		NodoArbol rec = raiz;
		int val;
		
		while(rec!=null)
		{
			val = nombre.compareToIgnoreCase(rec.dato);
			if(val>0)
			{
				rec = rec.hijoDerecho;
			}
			
			else if(val<0)
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
	
	NodoArbol nodo;
	public void hojaPequeña()
	{
		if(raiz!=null)
		{
			datoMenor="";
			x=0;
			nodo = raiz;
			recorrido(raiz);
			elimnarSinHijos(nodo);
			System.out.println("SE elimino el el nodo hoja: "+nodo);
			hojaPequeña();
		}
		else{
			System.out.println("Ya no hay mas hojass que eliminar, raiz nula");
		}
	}
	
	String datoMenor="";
	int x;
	public void recorrido(NodoArbol r)
	{
		if(r!=null)
		{
			recorrido(r.hijoIzquierdo);
			recorrido(r.hijoDerecho);
			
			
			if(r.hijoDerecho==null && r.hijoIzquierdo==null)
			{
				if(x==0)
				{
					datoMenor = r.dato;
					nodo = r;
				}
				
				else
				{
				if(r.dato.compareTo(datoMenor)<0)
				{
					nodo = r;
					datoMenor = r.dato;
				}
				}
				
				x++;
			}
				
		}
		
	}
	
	public static void main(String[] args)
	{
		ArbolBinario arbol = new ArbolBinario();
		
		String datos[] = 
		{
//				"50", "70", "30", "25", "45", "85", "90", "60", "55", "17", "09", "32","71","47","33","35"
//				"D","G","I","Z","A","L","K","C","B","N","Y","R","H"
//				"h","o","f","t","d","m","b","e","w","g","n",/*"eg"*/ //"i"
				//"50","40","60","10","45","57","65","30","42","46","20","44","48","15","47","49","43"
//				"70","40","45","35","36","25","17","80"
//				"08","03","10","01","06","14","04","07","13"
//				"n","g","p","r","e","a","d","o","s","b"}
//				"70","50","100","32","40","55","52","80","86","84","90","10","02"
//				"Othoniel","Gerardo","Ricardo","Fernando","Daniel","Teresa","Emmanuel",
//				"Benito","Armando","David","Jesus","Manuel","Hector"
		};
		
		
		for(String c : datos)
			arbol.insert(c);

		arbol.porNivel();
		arbol.preOrden(arbol.raiz);
	}
}


