package Unidad2;

public class Recursividad
{
	public static long factorial(int num)
	{
		if(num==0 || num==1)
			return 1;
		
		System.out.print(num+"*factorial(");
		
		return num * factorial(num-1);
	}
	
	public static void imprimeSerie(int n)
	{
		if(n!=0)
		{
			//System.out.print(n+" ");// 5 4 3 2 1
			imprimeSerie(n-1);
			System.out.print(n+" ");// 1 2 3 4 5
		}
	}
	
	public static void imprimeMensaje(String msg, int n)
	{
		if(n!=0)
		{
			System.out.println(msg);
			imprimeMensaje(msg, --n);
		}
	}
	
	public static int sumatoria(int n)
	{
		if(n==1)
			return 1;
		
		return n+sumatoria(--n);
	}
	
	public static long potencia(int base, int exp)
	{
		if(exp==0)
			return 1;
		
		return base*potencia(base, exp-1);
	}
	
	public static void fibonaciRecursivo(int s1, int s2, int limite)
	{
		int res = s1 + s2;
		
		if(res<=limite)
		{
			System.out.print(res+" ");
			fibonaciRecursivo(s2, res, limite);
		}
	}
	
	public static void parImpar(int num)
	{
		if(num==0)
		{
			System.out.println("El numero es par");
		}
		
		else if(num==1)
		{
			System.out.println("El numero es impar");
		}
		
		else parImpar(num-2);
	}
	
	public static void tablaMultiplicar(int num, int val)
	{
		if(val==10)
			return;
		
		tablaMultiplicar(num, val+1);
		System.out.printf("%d * %d = %d\n",num,val,num*val);
	}
	
	static int multiplicar(int a, int b)
	{
		
		if(b==0)
			return 0;
		
		else
		{
			return a + multiplicar(a, b-1);
		}
	}
	
	static void serieNum(int num, int i)
	{
		if(i>num)
			return;
		
		imprime(num,i);
		System.out.println();
		serieNum(num, i+1);
		
	}
	
	static void imprime(int num, int i)
	{
		System.out.print(num+" ");
		
		if(num==i)
			return;
		
		imprime(num-1, i);
	}
	
	static void romboAsteriscos(int altura,int nivel, int tamIni)
	{
		if(tamIni == altura+(altura-1))
			return;
		
		imprimeRombo(altura, nivel,tamIni);
		System.out.println();
		romboAsteriscos(altura,nivel+1,tamIni+2);
		imprimeRombo(altura, nivel,tamIni);
		System.out.println();
	}
	
	static void imprimeRombo(int altura,int nivel, int tamIni)
	{
		int i;
		
		for(i=-5; i<altura-nivel; i++)
			System.out.print(" ");
		
		for(i=0; i<tamIni; i++)
			System.out.print("*");
		
	}
	
	static void binario(int num)
	{
		if(num==0)
		{
			System.out.print("0");
			return;
		}
		
		binario(num/2);
		System.out.print(num%2);
	}
	
	//hexadecimal = 128 decimal
	//static int mascara = 0x80;//8 bits
	//mascara = 0x80; -> 128 decimal -> 1<<7
	//0x80-> 0 de 4bits, 8-> de 4 bits
	//mascara de 32 bits-> 1<<31;
	static String binarioMascara(int num, String cad, int nb) //nb para saber para cuantos bits
	{
		if(nb<0)
			return cad;
		
		int mascara = 1<<nb;
		int oper = mascara&num;
		
		if(oper==0)
			cad+="0";
		else
			cad+="1";
		
		return binarioMascara(num, cad, nb-1);
	}
	
	
	static int sumarElementos(int [] arreglo,int ind)
	{
		if (ind==0)
			return arreglo[0];
		
		else
		{
			return arreglo[ind] + sumarElementos(arreglo,ind-1);
		}
	}
	
	static int numeroMayor(int mayor, int vector[], int index)
	{
		if(index==vector.length)
			return mayor;
		
		if(mayor<vector[index])
			mayor = vector[index];
		
		return numeroMayor(mayor, vector, index+1);
	}
	
	static void serieN(int numVeces, int val)
	{
		imprimir(numVeces, 1,val);
		System.out.println();
		if(val == numVeces)
			return;
		serieN(numVeces,val+1);
		
	}
	
	static void imprimir(int veces, int cont, int val)
	{
		if(cont==veces)
		{
			System.out.print(val);
			return;
		}
		
		System.out.print(val);
		imprimir(veces, ++cont, val);
	}
	
	public static void main(String[] args)
	{
//		System.out.println(factorial(4));
//		imprimeSerie(5);
		//imprimeMensaje("Hola", 4);
		//System.out.println(sumatoria(5));
		//System.out.printf ("Potencia de %d^%d = %d\n",2,5,potencia(2, 5));
//		System.out.printf ("Potencia de %d^%d = %d\n ",4,3,potencia(4,3));
//		fibonaciRecursivo(1,1,100);
		//parImpar(10);
		//tablaMultiplicar(8, 1);
		//System.out.println(multiplicar(5, 10));
		serieNum(10, 1);
		//romboAsteriscos(15, 1, 1);
//		binario(78943);
//		String binario = binarioMascara(78943, "", 18);
//		System.out.println();
//		System.out.println(binario + " en decimal: "+Integer.parseInt(binario, 2));
//		
//		int v[] = {111,2,3,14,5,6,12,0x31A,0b110011111010};
//		System.out.println("Suma del arreglo: "+sumarElementos(v, v.length-1));
//		System.out.println("Numero mayor: "+numeroMayor(v[0], v, 1));
//		
//		System.out.println();
//		serieN(2, 2);
//		
//		int matriz[][] = 
//				{
//					{2,3,4,5,6},
//					{6,77,3},
//					{1},
//					{2,3,3,4,5,6,6}
//				};
//		
//		matrizRecursiva(0, 0, matriz);
		
//		System.out.printf("Es palindromo? %b",esPalindromo("anitalavalatinaa"));
	}
	
	static boolean esPalindromo(String cad)
	{
		System.out.println(cad);
		
		if(cad.length()==1)
			return true;
		
		
		return (cad.charAt(0) == cad.charAt(cad.length()-1)) && esPalindromo(cad.substring(1,cad.length()-1));
	}
	
	static void matrizRecursiva(int i, int j, int[][] matriz)
	{
		if(i==matriz.length)
			return;
		
		if(j==matriz[i].length)
		{
			System.out.println();
			matrizRecursiva(++i, 0, matriz);
		}
		
		else 
		{
			System.out.print(matriz[i][j]+"\t");
			matrizRecursiva(i, ++j, matriz);
		}
	}
}
