package Unidad1;

import java.util.Random;

public class AlgoritmoEficencia
{
	public int mayorN(int v[], int x)
	{
		int cont=0;//1
		
		/**
		 * i=0 -> 1
		 * i<v.length-> 2
		 * i++ -> 2
		 */
		for(int i=0; i<v.length; i++)
			/*
			 * v[i] -> 1
			 * v[i]>x -> 1
			 * cont++ -> 2
			 */
			if(v[i]>x)
				cont++;
		
		return cont; //-> 1
	}
	
	//T(n) = peor de los casos
		//todos los numeros del vector son > a x
		// 1+1 + 8n + 2+1
		//5+8n
		
		//T(n)= mejor de los casos
		//ninguno de los elemento es mayor a x
		//1+1+6n + 2+1
		//5+6n
	
	public int mayorN2(int...v)
	{
		int m=v[0];//2

		for(int i=1; i<v.length; i++) // 1 ; 2; 2
			if(v[i]>m) //2
				m=v[i];//2
		
		return m; //-> 1
	}

	//T(n) peor de los casos (si todos los numeros mayores que el ant)
	// 2 + 1 + 8(n-1) + 2(por la ultima cmpracion e mas en v.lengt)  + 1
	//6+ 8(n-1)
	//6 + 8n-8 == 8n - 2
	
	//T(n) mjeor de los casos (ningun elemento es amyor al 1er elemento)
	//2+1 + 6(n-1) + 2+1;
	//6 + 6(n-1);
	//6 + 6n - 6 = 6n
	
	//R1  >=0 y <40
	//R2 >=40 y <70
	//R3 >=70 y <101;
	Random lb = new Random(); // 1
	int v[] = new int[10]; // 10
	
	public int[] Rango()
	{
		int rango[] = new int[3]; // 3
		int i;
		
		
		for(i=0; i<10; i++) //1; 1; 2;
		{
			v[i] = lb.nextInt(101); // 2

			System.out.print(v[i]+" "); // 2
			
			if(v[i]<40)// 2
				rango[0]++; // 4 (r[0] = r[0]+1)
			
			else if(v[i]<70) // 2
				rango[1]++; //
			
			else 
				rango[2]++;//4
		}
		
		return rango;//1
	}
	
	//Sin contar la asginacion random y el system
	//T(n) peor de los casos (cuando tofos los numeros estan en el ultimo rango, entra añ ultimo else)
	// 3 + 1 + 12(n) + 2 + 1;
	// 7 + 12n = n=10(elementos)>>127 unidades de tiempo
	
	//T(n) mejor
	// 3+1 +10n +2+1
	//7+10n -> n=10; 107 unidades t
	public static void main(String[] args)
	{
//		AlgoritmoEficencia al = new AlgoritmoEficencia();
//		
//		//int v[] = {7,19,20,23,56,90,23,55,50,89};
//		//System.out.println("Mayores a 25: "+al.mayorN(v, 25));
//		
//		//System.out.println("Mayor: "+al.mayorN2(25,10,15,20,25,30,35,40,45,50,55));
//		
//		int v[] = al.Rango();
//		String rangos[] = {">=0 && <40",">=40 && <70",">=70 && <100"};
//		
//		System.out.println();
//		for(int i=0; i<v.length; i++)
//		{
//			System.out.println("Numeros en: "+rangos[i]+": "+v[i]);
//		}
//			
	}
}
