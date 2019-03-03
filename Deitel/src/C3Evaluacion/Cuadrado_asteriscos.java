package C3Evaluacion;

import java.util.Scanner;

public class Cuadrado_asteriscos 
{
	
	public static void main(String[] args) 
	{
		
		Scanner lc =new Scanner(System.in);
		int cuadro[][];
		int tamano;
		
		System.out.print ("Dame el tamaño del cuadrado: ");
		tamano=lc.nextInt();
		
		cuadro=new int [tamano][tamano];
		 
		for (int i=0; i<cuadro.length; i++)
		{
			for (int j=0; j<cuadro[i].length; j++)
			{
				if (i==0 || i==tamano-1 || j==0 || j==tamano-1)
				{
					System.out.print ("* ");
				}
				else
				{
					System.out.print ("  ");
				}
			}
			System.out.println();
		}
    } 
}

// Cierra metodo recibe

/*
 * Scanner lc =new Scanner(System.in);
		
		int lado;       // Se recibe el lado del cuadrado
		 System.out.println("\nPor favor introduzca un numero entre 1 y 20 y se imprimira un cuadrado con ese numero de lado:");
		 lado = lc.nextInt();
		 
		 Imprime(lado);
 */


		 ///////////////////////////////////////////////////////////////////////////
		 //METODO IMPRIME
		 //////////////////////////////////////////////////////////////////////////
		 
		/* public static void Imprime( int x)
		 {                 // Abre el metodo Imprime
		 int contadorHorizontal = 1;
		 int contadorVertical = 2;
		 
		 while( contadorHorizontal++ <= x)
		 {    // Abre while
		 System.out.print("* ");
		 }       // Cierra while
		 System.out.print("\n");
		 
		 // Aqui se cambia el valor de contadorHorizontal a 1, indicando que se esta en un nuevo renglon.
		 contadorHorizontal = 1;
		 
		 while ( contadorVertical++ < x) // LOs limites van de 2( valor inicial) a
		 // x-1, ya que enla primera y ultima linea se imprimen asteriscos
		 
		 
		 {          // Abre while que controla columnas
		 
		 while ( x >= contadorHorizontal)  // Aqui se imprime el renglon
		 {              // Abre while anidado
		 if ((1 == contadorHorizontal) || (x == contadorHorizontal))
		 System.out.print("* ");
		 else
		 System.out.print("  ");
		 
		 contadorHorizontal++;
		 }               // Cierra while anidado
		 
		 System.out.print("\n");  // con esto se cambia de renglon
		 contadorHorizontal = 1;
		 }             // Cierra while 
		 
		 contadorHorizontal = 1;
		 while ( contadorHorizontal++ <= x)
		 { // ABre while
		 System.out.print("* ");
		 }         // Cierra while
		 
		 System.out.println("\n");
		 
	} */




/*
 *lado=n*n;
		
		while (hor<lado)
		{
			
			System.out.print("* ");
			
			if (hor==n*num)
			{
				System.out.println();
				num++;
				
			}
			hor++;
		}
			System.out.print("*");
		}
 */