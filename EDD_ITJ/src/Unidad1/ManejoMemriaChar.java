package Unidad1;

import java.util.Random;

public class ManejoMemriaChar 
{
	
	//char letras[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w',
		//	'x','y','z'};
	char arregloLetras[] = new char[10];
	
	Random lb = new Random();
	
	int direccionIni = 1353, dirMem;
	
	public ManejoMemriaChar() {
		
		char x;
		
		System.out.println("Letras generadas: ");
		
		for(int i=0; i<10; i++)
		{
			x =(char)(97+lb.nextInt(26));
			
			arregloLetras[i]=x;
			System.out.print(x+" ");
		}
		
		System.out.println();
		calcular();
	}

	
	public void calcular()
	{
		System.out.println("\nDireccion memoria vocales: ");
		
		for(int i=0; i<arregloLetras.length; i++)
		{
			if(esVocal(i))
			{
				dirMem = direccionIni + i * 2;
				System.out.printf ("Direccion memoria del # %c = %d\n",arregloLetras[i],dirMem);
			}
		}
	}
	
	private char vocales[] = {'a','e','i','o','u'};
	int cont=0;
	
	private boolean esVocal(int i)
	{
		if(cont==5)
		{
			cont=0;
			return false;
		}
		
		if(arregloLetras[i]==vocales[cont])
		{
			cont=0;
			return true;
		}
		
		else 
		{
			cont++;
			return esVocal(i);
		}
	}
	
	public static void main(String[] args) {
		
		new ManejoMemriaChar();
	}
}
