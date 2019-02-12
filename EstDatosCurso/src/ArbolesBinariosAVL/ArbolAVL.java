package ArbolesBinariosAVL;

public class ArbolAVL
{
	private NodoArbolAVL raiz;
	
	public ArbolAVL()
	{
		raiz=null;
	}
	
	public NodoArbolAVL getRaiz()
	{
		return raiz;
	}
	
	public NodoArbolAVL buscarNodo(int d, NodoArbolAVL r)
	{
		if(raiz==null)
			return null;
		
		else if (r.dato==d)
			return r;
		
		else if (r.dato<d)
			return buscarNodo(d,r.hijoDerecho);
		
		else
			return buscarNodo(d,r.hijoIzquierdo);
	}
	
	//Obtener factor equilibrio 
	public int obtenerFE(NodoArbolAVL x)
	{
		if(x==null)
			return -1;
		
		else
			return x.fe;
	}
	
	//Rotacion simple izq
	public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c)
	{
		NodoArbolAVL aux=c.hijoIzquierdo;
		c.hijoIzquierdo=aux.hijoDerecho;
		aux.hijoDerecho=c;
		
		c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
		aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo), obtenerFE(aux.hijoDerecho))+1;
		
		return aux;
	}
	
	//Rotacion simple derecha
	public NodoArbolAVL rotacionDerecha (NodoArbolAVL c)
	{
		NodoArbolAVL aux=c.hijoDerecho;
		c.hijoDerecho=aux.hijoIzquierdo;
		aux.hijoIzquierdo=c;
		
		c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
		aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo), obtenerFE(aux.hijoDerecho))+1;
		
		return aux;
	}
	
	//rotacion doble dere
	public NodoArbolAVL rotacionDobleIzq(NodoArbolAVL c)
	{
		NodoArbolAVL temporal;
		c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
		temporal=rotacionIzquierda(c);
		return temporal;
	}

	//Rot,d,derecha
	public NodoArbolAVL rotacionDobleDer(NodoArbolAVL c)
	{
		NodoArbolAVL temporal;
		c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
		temporal=rotacionDerecha(c);
		return temporal;
	}
	
	//Insertar
	private NodoArbolAVL insertarAVL(NodoArbolAVL nuevo,NodoArbolAVL subAr)
	{
		NodoArbolAVL nuevoPadre=subAr;
		
		if(nuevo.dato<subAr.dato)
		{
			if (subAr.hijoIzquierdo==null)
			{
				subAr.hijoIzquierdo=nuevo;
			}
			else
			{
				subAr.hijoIzquierdo=insertarAVL(nuevo, subAr.hijoIzquierdo);
				
				if((obtenerFE(subAr.hijoIzquierdo)) - (obtenerFE(subAr.hijoDerecho))==2)
				{
					if (nuevo.dato<subAr.hijoIzquierdo.dato)
					{
						nuevoPadre=rotacionIzquierda(subAr);
					}
					else
					{
						nuevoPadre=rotacionDobleIzq(subAr);
					}
				}
			}
		}
		
		else if (nuevo.dato>subAr.dato)
		{
			if (subAr.hijoDerecho==null)
			{
				subAr.hijoDerecho=nuevo;
			}
			else
			{
				subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
				
				if((obtenerFE(subAr.hijoDerecho) - (obtenerFE(subAr.hijoIzquierdo))==2))
				{
					if (nuevo.dato>subAr.hijoDerecho.dato)
					{
						nuevoPadre=rotacionDerecha(subAr);
					}
					else
					{
						nuevoPadre=rotacionDobleDer(subAr);
					}
				}
			}
		}
		
		else
		{
			System.out.println("Nodo Duplicado");
		}
		
		//Actualizando la altura
		
		if (subAr.hijoIzquierdo==null && subAr.hijoDerecho!=null)
		{
			subAr.fe=subAr.hijoDerecho.fe+1;
		}
		else if (subAr.hijoDerecho ==null && subAr.hijoIzquierdo != null)
		{
			subAr.fe=subAr.hijoIzquierdo.fe+1;
		}
		else
		{
			subAr.fe=Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho))+1;
		}
		
		return nuevoPadre;
	}
	
	public void insertarNodo(int d)
	{
		NodoArbolAVL nuevo =  new NodoArbolAVL (d);
		
		if(raiz==null)
			raiz=nuevo;
		
		else
			raiz=insertarAVL(nuevo, raiz);
	}
	
	//Recorridos
	//Metodo para recorrer el Arbol InOrden
		public void inOrden(NodoArbolAVL r)
		{
			if(r!=null)
			{
				inOrden(r.hijoIzquierdo);
				System.out.print (r.dato + ", ");
				inOrden(r.hijoDerecho);
			}
		}
		
		//Recorrer en PreOrden
		public void preOrden(NodoArbolAVL r)
		{
			if(r!=null)
			{
				System.out.print(r.dato + ", ");
				preOrden(r.hijoIzquierdo);
				preOrden(r.hijoDerecho);
			}
		}
		
		//Recorrer en PostOrden
		public void postOrden(NodoArbolAVL r)
		{
			if(r!=null)
			{
				preOrden(r.hijoIzquierdo);
				preOrden(r.hijoDerecho);
				System.out.print(r.dato + ", ");
			}
		}
}
