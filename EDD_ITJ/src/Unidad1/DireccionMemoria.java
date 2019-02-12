package Unidad1;

import java.util.Random;

public class DireccionMemoria
{
	static int tamañoBytes, direccionMemoria, dirIni;
	
	static char vecC[];
	static double vecDo[];
	
	static final int BYTE = 1;
	static final int CHAR = 2;
	static final int SHORT = 2;
	static final int INT = 4;
	static final int FLOAT = 4;
	static final int LONG = 8;
	static final int DOUBLE = 8;
	

	static final int TYPE_BYTE = 0, TYPE_CHAR=1, TYPE_SHORT=2, TYPE_INT=3, TYPE_FLOAT=4,
					 TYPE_LONG=5, TYPE_DOUBLE=6;
	
	static boolean esDecimal;
	
	static Random lb = new Random();
	 
	public static void vector(int tipo, int tamaño, int direccionIni)
	{
		dirIni = direccionIni;
		
		switch(tipo)
		{
			case TYPE_BYTE:
				esDecimal=false;
				tamañoBytes = BYTE;
				vecDo = new double[tamaño];
				break;
				
			case TYPE_CHAR:
				tamañoBytes = CHAR;
				vecC = new char[tamaño];
				break;
				
			case TYPE_SHORT:
				esDecimal=false;
				tamañoBytes = SHORT;
				vecDo = new double[tamaño];
				break;
				
			case TYPE_INT:
				esDecimal=false;
				tamañoBytes = INT;
				vecDo = new double[tamaño];
				break;
				
			case TYPE_FLOAT:
				esDecimal=true;
				tamañoBytes = FLOAT;
				vecDo = new double[tamaño];
				break;
				
			case TYPE_LONG:
				esDecimal=false;
				tamañoBytes = LONG;
				vecDo = new double[tamaño];
				break;
			
			case TYPE_DOUBLE:
				esDecimal=true;
				tamañoBytes = DOUBLE;
				vecDo = new double[tamaño];
		}
		
		llenarAleatorio();
	}
	
	static double matrizDouble[][];
	static char matrizChar[][];
	
	public static void matriz(int tipo, int filas,int columnas, int direccionIni)
	{
		switch(tipo)
		{
			case TYPE_BYTE:
				esDecimal=false;
				tamañoBytes = BYTE;
				matrizDouble = new double[filas][columnas];
				break;
				
			case TYPE_CHAR:
				tamañoBytes = CHAR;
				matrizChar = new char[filas][columnas];
				break;
				
			case TYPE_SHORT:
				esDecimal=false;
				tamañoBytes = SHORT;
				matrizDouble = new double[filas][columnas];
				break;
				
			case TYPE_INT:
				esDecimal=false;
				tamañoBytes = INT;
				matrizDouble = new double[filas][columnas];
				break;
				
			case TYPE_FLOAT:
				esDecimal=true;
				tamañoBytes = FLOAT;
				matrizDouble = new double[filas][columnas];
				break;
				
			case TYPE_LONG:
				esDecimal=false;
				tamañoBytes = LONG;
				matrizDouble = new double[filas][columnas];
				break;
			
			case TYPE_DOUBLE:
				esDecimal=true;
				tamañoBytes = DOUBLE;
				matrizDouble = new double[filas][columnas];
		}
		
		matrizAleatoria();
	}
	
	private static void matrizAleatoria()
	{
		int i,j;
		
		if(matrizChar!=null)
		{
			for(i=0; i<matrizChar.length; i++)
			{
				for(j=0; j<matrizChar[0].length; j++)
				{
					matrizChar[i][j] = (char) lb.nextInt(255);
				}
			}
		}
		else
		{
			for(i=0; i<matrizDouble.length; i++)
			{
				for(j=0; j<matrizDouble[0].length; j++)
				{
					matrizDouble[i][j] = lb.nextInt(101);
					
					if(esDecimal)
						matrizDouble[i][j] = matrizDouble[i][j]+lb.nextDouble();
				}
			}
		}
	}
	
	private static void llenarAleatorio()
	{
		int i;
		
		if(vecC != null)
		{
			for(i=0; i<vecC.length; i++) 
			{
				vecC[i] =  (char) lb.nextInt(255);
			}
		}
		else
		{
			for(i=0; i<vecDo.length; i++)
			{
				vecDo[i] =  lb.nextInt(31);
				
				if(esDecimal)
					vecDo[i] = vecDo[i] + lb.nextDouble();
			}
		}
	}

	static void mostrarVector()
	{
		System.out.println("Elementos del arreglo: ");
		if(vecC!=null)
		{
			for(char c : vecC)
				System.out.print(c+"\t");
		}
		else
		{
			for(double c : vecDo)
				System.out.printf("%.2f\t",c);
		}
	}
	
	static void mostrarMatriz()
	{
		System.out.println("Elementos de la matriz: ");
		if(matrizChar!=null)
		{
			for(char c[]: matrizChar)
			{
				for(char x : c)
					System.out.print(x+"\t");
				
				System.out.println();
			}
		}
		else
		{
			for(double c[]: matrizDouble)
			{
				for(double x : c)
					System.out.printf("%.2f\t",x);
				
				System.out.println();
			}
		}
	}
	
	static void determinarDirMemoriaCadaElemento()
	{
		System.out.println("\nLa direccion de memoria inicial es: "+dirIni);
		
		if(vecC!=null)
		for(int i=0; i<vecC.length; i++)
		{
			direccionMemoria = dirIni + i * tamañoBytes;
			System.out.printf ("Direccion memoria del elemento %c en posicion[%d] = %d\n",
								vecC[i],i,direccionMemoria);
		}
		
		else
		{
			for(int i=0; i<vecDo.length; i++)
			{
				direccionMemoria = dirIni + i * tamañoBytes;
				System.out.printf ("Direccion memoria del elemento %.2f en posicion[%d] = %d\n",
									vecDo[i],i,direccionMemoria);
			}
		}
	}


	static void direccionMemoriaPorColumna()
	{
		System.out.println("Direccion Memoria x columna: ");
		int i,j;
		
		if(matrizChar!=null)
		{
			for(i=0; i<matrizChar.length; i++)
				for(j=0; j<matrizChar[i].length; j++)
				{
					//dirInicial + (numero de rengons array*posIndCol+posIndRen)*tamañoBytes-
					calcularDirMemBidi(matrizChar.length, j, i);
					System.out.printf("[%d][%d]-> %c = Direccion Memoria: %d\n",i,j,
										matrizChar[i][j],direccionMemoria);
				}
		}
		else
		{
			for(i=0; i<matrizDouble.length; i++)
				for(j=0; j<matrizDouble[i].length; j++)
				{
					//dirInicial + (numero de rengons array*posIndCol+posIndRen)*tamañoBytes-
					calcularDirMemBidi(matrizDouble.length, j, i);
					System.out.printf("[%d][%d]-> %.2f = Direccion Memoria: %d\n",i,j,
										matrizDouble[i][j],direccionMemoria);
				}
		}
	}
	
	static void direccionMemoriaPorRenglon()
	{
		System.out.println("Direccion Memoria x renglon: ");
		int i,j;
		
		if(matrizChar!=null)
		{
			for(i=0; i<matrizChar.length; i++)
				for(j=0; j<matrizChar[i].length; j++)
				{
					//dirInicial + (numero de columnas array*posIndRenglon+posIndCol)*tamañoBytes-
					calcularDirMemBidi(matrizChar[i].length, i, j);
					System.out.printf("[%d][%d]-> %c = Direccion Memoria: %d\n",i,j,
										matrizChar[i][j],direccionMemoria);
				}
		}
		else
		{
			for(i=0; i<matrizDouble.length; i++)
				for(j=0; j<matrizDouble[i].length; j++)
				{
					//dirInicial + (numero de columnas array*posIndRenglon+posIndCol)*tamañoBytes-
					calcularDirMemBidi(matrizDouble[i].length, i, j);
					System.out.printf("[%d][%d]-> %.2f = Direccion Memoria: %d\n",i,j,
										matrizDouble[i][j],direccionMemoria);
				}
		}
	}
	
	private static void calcularDirMemBidi(int n_columnas, int posIndRenglon, int posIndCol)
	{
		direccionMemoria = dirIni + (n_columnas*posIndRenglon+posIndCol) * tamañoBytes;
	}
	
	//1er elemento -> 8 + 1 return i; (9)
	//2do elemento -> 8 + 2(i++) + 2(i<...) + 2 (if) = 14 + 1 del return (15);
	//3er elemento -> 14 + 2(i++) + 2(i<...) + 2 (if) =  20 + 1 return (21);
	//4to elemento -> 20 + 2(i++) + 2(i<...) + 2 (if) = 26 + 1  return (27); 

	// 1 + 2 + 1 + 2 + 2 + 1 = 9;
	// 6([i+1]) + 3;
	//i=0 -> 9, i=1 -> 15, i=2 -> 21, i=3 -> 27;
	//Mejor de los casos i=0;
	//Peor de los casos i=n;
	
	
	public static int indexValorEnVector(String element)
	{
		if(vecC!=null) // 1
		{
			char car = element.charAt(0); // 2 (1 asignacion + 1 del charAt(0))
			
			for(int i=0; i<vecC.length; i++) // 1; 2; 2;
			{
				if(car == vecC[i]) // 2
					return i; //1
			}
			
			return -1; //1
		}
		else
		{
			try
			{
				double val = Double.parseDouble(element); //2 (1 por asignacion + 1 por convertir valor)
				
				for(int i=0; i<vecDo.length; i++) // 1; 2; 2;
				{
					if(val == vecDo[i]) //2
						return i; //1
				}
				
				return -1; //1
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				return -1;//1
			}
		}
				
	}
	
	/**Eficencia del algoritmo indexValor.... 
	 * 	  Mejor de los casos (que el vecC == null, y que ocurra la excepcion) = 4
	 *		-> 1 + 2 + 1; (1 por la comparcion vecC!=null + 2 por la asginacion + 1 por el return -1 dentro del catch)
	 *	       
	 * Peor de los casos:
	 *  1) Caso peor  -> que el elemento a buscar nunca se encuentre en el vector: 
	 *    				1 + 2 + 1 + 6(n) + 2 + 1 = 7 + 6(n);
	 *    
	 *  2) Caso mejor -> Que el elemento este en el vector:
	 *  		Formula: 6([i+1]) + 3; donde i representa la posicion en la que se quedo el for
	 *  			
	 *  			Mejor de los casos: Que el elemento este en la primera posicion vector
	 *  					6([0+1])+3 = 6 * 1 + 3 = 9
	 *  			
	 *  			Peor de los casos: Que este en la ultima posicion del vector
	 *  					6(n) + 3; 
	 *  			 
	 */
	
	public static void main(String[] args)
	{
		//Si quieres calcular la direccion de memoria de un vector usar estos tres metodos 
		// en el metodo vector(...); recibe tres paraetros:
		
		// El 1ro es saber para que tipo de valores almancenara el vector, entre ellos esta:
		// TYPE_BYTE = 0, TYPE_CHAR=1, TYPE_SHORT=2, TYPE_INT=3, TYPE_FLOAT=4,TYPE_LONG=5, TYPE_DOUBLE=6;
		//estas variables eestan declaradas en la misma clases, de manera estatica (static)
		
		//El 2 parametri es para darle el tamaño al vector
		
		//El tercer parametro es para darle la direccion de memoria Inicial, con la cual hara los calculos
		
		vector(TYPE_CHAR, 5,1200);
		mostrarVector();
		determinarDirMemoriaCadaElemento();
		//Este metodo de indexValor... se debe llamar si se mando a llamara los metodoa anteriores 
		//(vector(....), mostrarVector()...);
		String valorBuscar  = "c";
		System.out.printf("\nIndex del valor: %s = %d\n",valorBuscar,indexValorEnVector(valorBuscar));
		
		//Si quieres calcular la direccion de memoria de una matriz usar estos metodos
		//El primer parametro del metodo matriz es el tipo que almanacenara
		//El segundo son las filas que tendra la matriz, mientras que el tercer parametro son las columnas
		//Y el cuarto es la direccion Inicial de memoria
		
//		matriz(TYPE_DOUBLE, 5, 4, 3400);
//		mostrarMatriz();
		//Este metodo determina la posicion de todos los elementos, calculados por renglon
//		direccionMemoriaPorColumna();
		
		//Este metodo determina la posicion de todos los elementos, calculados por columna
//		direccionMemoriaPorRenglon();
		
	}
}
