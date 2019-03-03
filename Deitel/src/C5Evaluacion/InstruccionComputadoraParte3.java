package C5Evaluacion;

import java.util.Random;
import java.util.Scanner;

public class InstruccionComputadoraParte3
{
	public static Scanner lc = new Scanner(System.in);
	public static Random lb =  new Random();
	public static int cont=1;
	public static int contadorCorrectas;
	public static int contadorIncorrectas;
	
	public static void main(String[] args)
	{
		
		System.out.println(" El siguiente programa servira de ayuda para ayudar a\n un alumno de "
				+ "primaria a multiplicar ");
		
		System.out.println(" \n Por cada respuesta correcta apareceran 1 de 4 posibles mensajes.");
		
		System.out.println(" \n Tambien ira calculando cada respuesta correcta e imprimira un mensaje\n"
				+ " y tambien hara lo mismo con cada incorrecta.\n Se tendra en cuenta el %75 de las respuestas"
				+ " para generar tal mensaje");
		
		System.out.println("\n Bueno. Empecemos: ");
		
		tablasMultiplicar();
		mostrarRespuestas();
		
	}
	
	public static void tablasMultiplicar ()
	{
		int numero1 = 1 + lb.nextInt(9);
		int numero2 = 1 + lb.nextInt(9);
		
		int resultado;
		
		
		System.out.printf ("\n %d.- Cuanto es %d x %d",cont,numero1,numero2);
		System.out.print ("\n Escriba aqui su resultado: ");
		resultado=lc.nextInt();
		
		if (resultado==(numero1*numero2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();

			if (cont<=10)
			{
				tablasMultiplicar();
				
			}
		}
		
		else
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				tablasMultiplicar();
				
			}
		}
	}
	
	public static void mensajesAleatoriosCorrecto ()
	{
		int cadena = 1 + lb.nextInt(4);
		
		switch (cadena)
		{
			case 1:
				System.out.println("\n Muy Bien¡");
				break;
				
			case 2:
				System.out.println("\n Excelente¡");
				break;
				
			case 3:
				System.out.println("\n Buen Trabajo¡");
				break;
				
			case 4:
				System.out.println("\n Sigue asi¡");
				break;
		}
	}
	
	public static void tryAgain ()
	{
		char opc;
		
		System.out.print ("\n Falta alguien mas de hacer la prueba?");
		opc = lc.next().charAt(0);
		
		if (opc=='S' || opc == 's')
		{
			cont=1;
			contadorCorrectas=0;
			contadorIncorrectas=0;
			tablasMultiplicar();
		}
		else
			System.exit(0);
	}
	
	public static void mostrarRespuestas ()
	{
		if (contadorCorrectas>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectas);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectas);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
		}
		
		else 
			if (contadorCorrectas<=8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectas);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectas);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
			} 
		
		tryAgain();
		mostrarRespuestas();
	}
}
