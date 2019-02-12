package Unidad5;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;

public class OrdenamientoInterno
{
	/*
	 * Burbuja,quickSort,shellSort -> Intercambio
	 * Radix -> Asignacion
	 */
	
	private int rango;
	private int vec[];
	private int pasada;
	private String vecS[];
	
	public OrdenamientoInterno(int tamVec, int rnd)
	{
		Random lb = new Random();
		
		vec = new int[tamVec];
		
		for(int i=0; i<vec.length; i++)
			vec[i] = lb.nextInt(rnd);
		
		rango = rnd-1;
		
	}

	/**
	 * 
	 * @param v: Enviamos un vector de numeros, que son los que ordenara
	 * 
	 */
	public void setVector(int v[])
	{
		//Encuentra el elemento mayor para asignarlo como "rango" 
		rango = v[0];
			
		for(int i=1; i<v.length; i++)
		{
			if(v[i]>rango)
				rango = v[i];
		}
		
		vec = v;
	}
	
	public  void burbuja()
	{
		int temp;
		 pasada=0;
		
		for(int i=0; i<vec.length; i++)
		{
			for(int j=0; j<vec.length-(i+1); j++)
			{
				if(vec[j]>vec[j+1])
				{
					temp = vec[j];
					vec[j] = vec[j+1];
					vec[j+1] = temp;
				}
			}
			 
			pasada++;
			mostrar("\nPasada: "+pasada);
		}
	}
	
	public void qSort()
	{
		pasada=0;
		quickSort(0, vec.length-1);
	}

	private  void quickSort(int ini, int fin)
	{
		
		
		int posPivote = (ini+fin)/2;
		int pivote = vec[posPivote];
		int izq = ini; int der = fin;
		
		
		while(izq<=der)
		{
			//Menor a mayor,<,> (signos >,< invertidos da = forma asecendente)
			while(vec[izq]<pivote)izq++;
			
			while(vec[der]>pivote) der--;
			
			
			if(izq<=der)
			{
				int temp = vec[izq];
				vec[izq] = vec[der];
				vec[der] = temp;
				
				izq++; der--;
			}
		}
		
		pasada++;
		mostrar("\nPasada: "+pasada);
		
		if(ini<der)
			quickSort(ini, der);
		
		if(izq<fin)
			quickSort(izq, fin);
		
	}

	public  void radix()
	{
		int noPasadas = (rango+"").length();
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer> C[] = new LinkedList[10];
		
		for(int i=0; i<C.length; i++)
			C[i] = new LinkedList<Integer>();
		
		int factor=1;
		int num,res,dig, pos;
		pasada=0;
		
		for(int i=0; i<noPasadas; i++)
		{
			pos = 0;
			
			for(int j=0; j<vec.length; j++)
			{
				num = vec[j];
				res = num/factor;
				dig = res%10;
				
				C[dig].add(num);
			}
			
			
			//for (int m=C.length-1; m>=0; m--) Ordena de mayor a menor los numeros
			for(int m=0; m<C.length; m++)
			{
				while(!C[m].isEmpty())
				{
					vec[pos] = C[m].removeFirst();
					pos++;
				}
			}
			
			pasada++;
			mostrar("\nPasada: "+pasada);
			factor*=10;
		}
	} 
	
	
/*
 * intervalo = tamaño del vector  / 2;
 * Comparar el intervalo con la primera, la segunda con la pos despues de intervalo y asi sucesivamente
 * Si la posicion ini con la del intervalo es mayor intercambiar valores.
 * Se acaba cuando interval llega al fin
 *  Si en el intervalo hubo cambios, hacer cambios con el mismo intervalo si no 
 *  se sacara de nuevo el ibtervalo: intervalo = intervalo / 2;
 * 	
 */
	public  void shellSort()
	{
		int intervalo, ini = 0;
		intervalo = vec.length;
		int temp;
		boolean otraVez=true;
		pasada=0;
		
		do
		{
			intervalo /= 2;
			
			while(otraVez)
			{
				otraVez = false;
				ini=0;
				
				while(ini+intervalo<vec.length)
				{
					if(vec[ini]>vec[intervalo+ini])
					{
						temp = vec[ini];
						vec[ini] = vec[intervalo+ini];
						vec[intervalo+ini] = temp;
						otraVez=true;
					}
					
					ini++;
				}
				mostrar("\nPasos: ");
				
			}
			
			pasada++;
			mostrar("\nPasada: "+pasada);
			
			otraVez=true;
		}
		while(intervalo!=1);
		
	}
	
	public  void mostrar(String msg)
	{
		System.out.println(msg);
		
		int j=0;  
		for(int i=0; i<vec.length; i++)
		{
			j++;
			
			System.out.printf("%2d ",vec[i]);
			
			if(j%30 == 0)
				System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		OrdenamientoInterno oi = new OrdenamientoInterno(20, 101);
		
		int v[] = 
			{    
					33,13,75,25,47,37,48,73,21,22
			};		
			
				
		
		oi.setVector(v);
		
		oi.mostrar("Vector desordenado:");
//		Calendar tIn = Calendar.getInstance(); 
//		oi.burbuja();
		oi.shellSort();
//		oi.qSort();
//		oi.radix();
//		Calendar tFin = Calendar.getInstance();
//		long t = tFin.getTimeInMillis()-tIn.getTimeInMillis();
		oi.mostrar("\n\nVector ordenado:");
//		mostrarT("Se tardo: ", t);
		
	}
	
	static void mostrarT(String msg,long t)
	{
		System.out.println("\n"+msg);
		
		long min = t/60000;
		long res = t%60000;
		long seg = res/1000;
		long mil = res%1000;
		
		System.out.printf("%d:%d:%d",min,seg,mil);
	}
	
	
}
