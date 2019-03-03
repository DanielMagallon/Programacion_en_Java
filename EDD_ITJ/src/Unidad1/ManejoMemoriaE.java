package Unidad1;

import java.util.Random;

class DefineVector
{
	int tamanioBytes, direccionMemoria, dirIni;
	int arreglo[] = new int[10];
//	static final int BYTE = 1;
//	static final int CHAR = 2;
//	static final int SHORT = 2;
//	static final int INT = 4;
//	static final int FLOAT = 4;
//	static final int LONG = 8;
//	static final int DOUBLE = 8;
	
	
	
	public DefineVector(int direccIni) 
	{
		tamanioBytes = 4;
		dirIni = direccIni;
		random();
		determinarDirecciones();
	}
	
	Random rnd = new Random();
	
	private void random()
	{
		for(int i=0; i<arreglo.length; i++)
		{
			arreglo[i] = rnd.nextInt(100);
		}
		
		System.out.println("Elementos del arreglo: ");
		
		for(int x : arreglo)
		{
			System.out.print (x + " ");
		}
		
		System.out.println();
	}

	public void determinarDirecciones()
	{
		for(int i=1; i<arreglo.length; i+=2)
		{
			direccionMemoria = dirIni + i * tamanioBytes;
			System.out.printf ("Direccion memoria del # %d = %d\n",arreglo[i],direccionMemoria);
		}
	}
}

public class ManejoMemoriaE {

	public static void main(String[] args) 
	{
		//new DefineVector(new int[]{34,55,67,78,80,5,0,100,23,12}, 1900);
		new DefineVector(2273);
	}
}
