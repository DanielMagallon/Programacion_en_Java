package C6ArreglosArrayList;

import java.util.Arrays;

public class ManipulacionesArreglos
{
	public static void main(String[] args)
	{
		// ordena arreglodouble en forma ascendente
		double [] arregloDouble = {8.4,9.3,0.2,7.9,3.4};
		Arrays.sort(arregloDouble);
		System.out.printf ("\narregloDouble: ");
		
		for (double valor : arregloDouble)
			System.out.printf("%.1f ",valor);
		
		// lena arreglo de 10 elemnetos con 7
		int [] arregloIntLleno = new int [10];
		Arrays.fill (arregloIntLleno,7);
		mostrarArreglo (arregloIntLleno,"arregloIntLleno");
		
		// copia el arreglo aregloInt  en el arreglo copiaArergloInt
		int [] arregloInt = {1,2,3,4,5,6};
		int [] copiaaArregloInt =  new int [arregloInt.length];
		System.arraycopy(arregloInt,0,copiaaArregloInt,0,arregloInt.length);
		mostrarArreglo (arregloInt, "arregloInt");
		mostrarArreglo (copiaaArregloInt, "copiaArregloInt");
		
		// compara si arregloInt y copiaArregloInt son iguales
		boolean b = Arrays.equals(arregloInt,copiaaArregloInt);
		System.out.printf ( "\n\narregloInt %s copiaArregloInt\n",(b ? "==" : "!=") );
		
		// compara si arregloInt y arregloIntLleno son iguales
				 b = Arrays.equals(arregloInt,arregloIntLleno);
				System.out.printf ( "\n\narregloInt %s arregloIntLleno\n",(b ? "==" : "!=") );
				
		// busca en arregloInt el valor 5
				int ubicacion = Arrays.binarySearch(arregloInt,5);
				
				if (ubicacion>=0)
					System.out.printf ("Se encontro 5 en el elemento %d de arregloInt\n",ubicacion);
				
				else
					System.out.printf ("No se encontro 5 en el arregloInt");
				
		// busca en arregloInt el valor 8763
				ubicacion = Arrays.binarySearch(arregloInt,8763);
				
				if (ubicacion>=0)
					System.out.printf ("Se encontro 8763 en el elemento %d de arregloInt\n",ubicacion);
				
				else
					System.out.printf ("No se encontro 8763 en el arregloInt");
	}
	
	// imprime los valores en cada arreglo
		public static void mostrarArreglo (int [] arreglo, String descripcion)
		{
			System.out.printf ("\n%s: ",descripcion);
			
			for (int valor : arreglo)
				System.out.printf ("%d ",valor);
		}
}
 