package Colas;

public class Cola
{
	NodoCola inicio,fin;
	int tama;
	
	public Cola()
	{
		inicio=fin=null;
		tama=0;
	}
	
	public boolean estaVacia()
	{
		return inicio==null;
	}
	
	public void insertar(int ele)
	{
		NodoCola nuevo=new NodoCola(ele);
		
		if(estaVacia())
			inicio=nuevo;
		
		else
		   fin.siguiente=nuevo;
		
		fin=nuevo;
		tama++;
	}
	
	public int quitar()
	{
		int auxiliar=inicio.dato;
		inicio=inicio.siguiente;
		tama--;
		
		return auxiliar;
	}
	
	public int inicioCola()
	{
		return inicio.dato;
	}
	
	public int sizeQue()
	{
		return tama;
	}
	
	/*public String mostrarCola()
	{
		NodoCola recorrer=fin;
		String cola="";
		
		while(recorrer!=null)
		{
			cola+=recorrer.dato;
			recorrer=recorrer.siguiente;
		}
		
		
		return cola;
	}*/
}
