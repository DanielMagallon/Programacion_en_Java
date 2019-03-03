package HelpClass;

import java.util.Random;
import java.util.Scanner;

public class IACP5Modificada 
{
	public static Scanner lc = new Scanner(System.in);
	public static Random lb = new Random();
	public static int contadorCorrectas;
	public static int contadorIncorrectas;
	
	public static int contadorCorrectasSuma1D, contadorIncorrectasSuma1D;
	public static int contadorSuma=0;
	
	public static int cont=1;
	public static int nivelAritmetico;
	public static int nivelDificultad;
	public static boolean banderaSuma1D,banderaSuma2D,banderaSuma3D,banderaSuma4D,banderaSuma5D;
	
	public static void main(String[] args)
	{
		
		
		System.out.println(" El siguiente programa tiene distintas opciones a elegir.\n"
				+ " Se podra escoger si quiere operacions de suma,resta, etc.. y\n el nivel de dificultad");
		
		System.out.println("\n NOTA: La operacion tambien puede generar resultados negativos.");
		
		System.out.println ("\n Le deseamos SUERTE¡¡\n ");
		
		elegirNivelAritmetico();
	}
	
	public static void elegirNivelAritmetico ()
	{
		int nivelAritmetico;
		
		System.out.println (" Niveles disponiles: ");
		System.out.println("\n 1) Sumas");
		System.out.println(" 2) Restas");
		System.out.println(" 3) Multiplicacion");
		System.out.println(" 4) Division");
		System.out.println(" 5) Mezcla Aleatoria de todos (Bloqueado)");
		System.out.println(" 0) Salir del sistema");
		
		System.out.print ("\n Eliga el nivel que desee ejecutar: ");
		nivelAritmetico = lc.nextInt();
		nivelesAritmeticos(nivelAritmetico);
		
	}
	
	public static void nivelesAritmeticos (int nivelAritmetico)
	{
		switch (nivelAritmetico)
		{
		case 1:
			System.out.println("\n Ha entrado a las operaciones de Suma");
			elgirNivelDificultadSuma();
			break;
			
		case 2:
			System.out.println("\n Ha entrado a las operaciones de Resta");
			elgirNivelDificultadResta();
			break;
			
		case 3:
			System.out.println("\n Ha entrado a las operaciones de Multiplicacion");
			elgirNivelDificultadMultplicacion();
			break;
			
		case 4:
			System.out.println("\n Ha entrado a las operaciones de Division");
			elgirNivelDificultadDivision();
			break;
			
		case 5:
			System.out.println("\n Ha entrado a la mezcla aleatoria de todos los tipos de operaciones\n y digitos variados");
			generarOperacionesAletorias();
			break;
			
		case 0:
			break;
		}
	}
	
	
	public static void elgirNivelDificultadSuma()
	{
		int nivelDificultad;
		
		
		System.out.println("\n Niveles de dificultad disponibles: ");
		System.out.println("\n 1) Suma de numeros con un digito");
		System.out.println(" 2) Suma de numeros con dos digitos (Bloqueado)");
		System.out.println(" 3) Suma de numeros con tres digitos (Bloqueado)");
		System.out.println(" 4) Suma de numeros con cuatro digitos (Bloqueado)");
		System.out.println(" 5) Suma de numeros con cinco digitos (Bloqueado)");
		System.out.println(" 6) Suma de numeros con digitos variados (Bloqueado)");
		System.out.println(" 0) Regresar al menu principal");
		
		System.out.print("\n Eliga la opcion que desee: ");
		nivelDificultad=lc.nextInt();
		nivelesDificultadSuma(nivelDificultad);
		
	}
	
	public static void nivelesDificultadSuma (int nivelDificultad) 
	{
		switch (nivelDificultad)
		{
			case 0:
				elegirNivelAritmetico();
				break;
		
		 	case 1:
		 		System.out.println("\n Entro al nivel de dificultad 1, se mostraran sumas con solo un digito");
		 		generarNumerosSuma1Digito();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 2:
		 		if (banderaSuma1D == true)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 2, se mostraran sumas con dos digitos");
		 		generarNumerosSuma2Digito();
		 		mostrarRespuestas();
		 		}
		 		else 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 		}
		 		break;
		 		
		 	case 3:
		 		if (banderaSuma2D==true)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 3, se mostraran sumas con tres digitos");
		 		generarNumerosSuma3Digito();
		 		mostrarRespuestas();
		 		}
		 		else 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 		}
		 		break;
		 		
		 	case 4:
		 		if (banderaSuma3D == true)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 4, se mostraran sumas con cuatro digitos");
		 		generarNumerosSuma4Digito();
		 		mostrarRespuestas();
		 		}
		 		else 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 		}
		 		break;
		 	
		 	case 5:
		 		if (banderaSuma4D==true)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 5, se mostraran sumas con cinco digitos");
		 		generarNumerosSuma5Digito();
		 		mostrarRespuestas();
		 		}
		 		else 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 		}
		 		break;
		 		
		 	case 6:
		 		if (banderaSuma5D==true)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 6, se mostraran sumas con digitos variados");
		 		generarNumerosSumaMezcla();
		 		mostrarRespuestas();
		 		}
		 		else 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 		}
		 		break;
		}
	}
	
	public static void generarNumerosSuma1Digito ()
	{
		int n1 =  lb.nextInt(9);
		int n2 =  lb.nextInt(9);
		
		int result;
		
		System.out.printf ("\n Cuanto es %d + %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectasSuma1D++;
			contadorSuma++;
			mensajesAleatoriosCorrecto();

			
			if (contadorSuma<=10)
			{
				generarNumerosSuma1Digito();
			}
		}
		
		else 
		{
			contadorIncorrectasSuma1D++;
			contadorSuma++;
			if (contadorSuma<10)
			{
				generarNumerosSuma1Digito();
			}
		}
		
		if (contadorCorrectasSuma1D>8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma1D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma1D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaSuma1D = true;
			elgirNivelDificultadSuma();
		}
		
		else 
			if (contadorCorrectasSuma1D<=8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma1D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma1D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorSuma=0;
				contadorIncorrectasSuma1D=0;
				contadorCorrectasSuma1D=0;
				elgirNivelDificultadSuma();
			} 
	}
	
	public static void generarNumerosSuma2Digito ()
	{
		int n1 = lb.nextInt(99 - 10 +1)+10;
		int n2 = lb.nextInt(99 - 10 +1)+10;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d + %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosSuma2Digito();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosSuma2Digito();
			}
		}
	}
	
	public static void generarNumerosSuma3Digito ()
	{
		int n1 = lb.nextInt(999 - 100 +1)+100;
		int n2 = lb.nextInt(999 - 100 +1)+100;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d + %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosSuma3Digito();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosSuma3Digito();
			}
		}
	}
	
	public static void generarNumerosSuma4Digito ()
	{
		int n1 = lb.nextInt(9999 - 1000 +1)+1000;
		int n2 = lb.nextInt(9999 - 1000 +1)+1000;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d + %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosSuma4Digito();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosSuma4Digito();
			}
		}
	}
	
	public static void generarNumerosSuma5Digito ()
	{
		int n1 = lb.nextInt(99999 - 10000 +1)+1;
		int n2 = lb.nextInt(99999 - 10000 +1)+1;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d + %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosSuma5Digito();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosSuma5Digito();
			}
		}
	}
	
	public static void generarNumerosSumaMezcla ()
	{
		int aleatorio = 1 + lb.nextInt(5);
		int aleatorio2 = 1 + lb.nextInt(5);
		
		int n1=0,n2=0;
		
		switch (aleatorio)
		{
			case 1: 
				n1 = lb.nextInt(9)+1;
				break;
				
			case 2: 
				n1 = lb.nextInt(99 - 10 +1)+10;
				break;
				
			case 3: 
				n1 = lb.nextInt(999 - 100 +1)+100;
				break;
		
			case 4:
				n1 = lb.nextInt(9999 - 1000 +1)+1000;
				break;
				
			case 5: 
				n1 = lb.nextInt(99999 - 10000 +1)+1;
				break;
		}
		
		switch (aleatorio2)
		{
			case 1: 
				n2 = lb.nextInt(9)+1;
				break;
				
			case 2: 
				n2 = lb.nextInt(99 - 10 +1)+10;
				break;
				
			case 3: 
				n2 = lb.nextInt(999 - 100 +1)+100;
				break;
		
			case 4:
				n2 = lb.nextInt(9999 - 1000 +1)+1000;
				break;
				
			case 5: 
				n2 = lb.nextInt(99999 - 10000 +1)+1;
				break;
		}
		
		int result;
		
		System.out.printf ("\n Cuanto es %d + %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosSumaMezcla ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosSumaMezcla();
			}
		}
	}
	
	public static void elgirNivelDificultadResta()
	{
		int nivelDificultad;
		
		
		System.out.println("\n Niveles de dificultad disponibles: ");
		System.out.println("\n 1) Resta de numeros con un digito");
		System.out.println(" 2) Resta de numeros con dos digitos (Bloqueado)");
		System.out.println(" 3) Resta de numeros con tres digitos (Bloqueado)");
		System.out.println(" 4) Resta de numeros con cuatro digitos (Bloqueado)");
		System.out.println(" 5) Resta de numeros con cinco digitos (Bloqueado)");
		System.out.println(" 6) Resta de numeros con digitos variados (Bloqueado)");
		System.out.println(" 0) Regresar al menu principal");
		
		System.out.print("\n Eliga la opcion que desee: ");
		nivelDificultad=lc.nextInt();
		nivelesDificultadResta(nivelDificultad);
		
	}
	
	public static void nivelesDificultadResta (int nivelDificultad) 
	{
		switch (nivelDificultad)
		{
			case 0:
				elegirNivelAritmetico();
				break;
		
		 	case 1:
		 		System.out.println("\n Entro al nivel de dificultad 1, se mostraran restas con solo un digito");
		 		generarNumerosResta1Digito();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 2:
		 		System.out.println("\n Entro al nivel de dificultad 2, se mostraran restas con dos digitos");
		 		generarNumerosResta2Digito ();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 3:
		 		System.out.println("\n Entro al nivel de dificultad 3, se mostraran restas con tres digitos");
		 		generarNumerosResta3Digito ();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 4:
		 		System.out.println("\n Entro al nivel de dificultad 4, se mostraran restas con cuatro digitos");
		 		generarNumerosResta4Digito ();
		 		mostrarRespuestas();
		 		break;
		 	
		 	case 5:
		 		System.out.println("\n Entro al nivel de dificultad 5, se mostraran restas con cinco digitos");
		 		generarNumerosResta5Digito ();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 6:
		 		System.out.println("\n Entro al nivel de dificultad 6, se mostraran restas con digitos variados");
		 		generarNumerosRestaMezcla ();
		 		mostrarRespuestas();
		 		break;
		}
	}
	
	public static void generarNumerosResta1Digito ()
	{
		int n1 =  lb.nextInt(9);
		int n2 =  lb.nextInt(9);
		
		int result;
		
		System.out.printf ("\n Cuanto es %d - %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosResta1Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosResta1Digito ();
			}
		}
	}
	
	public static void generarNumerosResta2Digito ()
	{
		int n1 = lb.nextInt(99 - 10 +1)+10;
		int n2 = lb.nextInt(99 - 10 +1)+10;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d - %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosResta2Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosResta2Digito ();
			}
		}
	}
	
	public static void generarNumerosResta3Digito ()
	{
		int n1 = lb.nextInt(999 - 100 +1)+100;
		int n2 = lb.nextInt(999 - 100 +1)+100;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d - %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosResta3Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosResta3Digito ();
			}
		}
	}
	
	public static void generarNumerosResta4Digito ()
	{
		int n1 = lb.nextInt(9999 - 1000 +1)+1000;
		int n2 = lb.nextInt(9999 - 1000 +1)+1000;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d - %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosResta4Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosResta4Digito ();
			}
		}
	}
	
	public static void generarNumerosResta5Digito ()
	{
		int n1 = lb.nextInt(99999 - 10000 +1)+10000;
		int n2 = lb.nextInt(99999 - 10000 +1)+10000;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d - %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosResta5Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosResta5Digito ();
			}
		}
	}
	
	public static void generarNumerosRestaMezcla ()
	{
		int aleatorio = 1 + lb.nextInt(5);
		int aleatorio2 = 1 + lb.nextInt(5);
		
		int n1=0,n2=0;
		
		switch (aleatorio)
		{
			case 1: 
				n1 = lb.nextInt(9)+1;
				break;
				
			case 2: 
				n1 = lb.nextInt(99 - 10 +1)+10;
				break;
				
			case 3: 
				n1 = lb.nextInt(999 - 100 +1)+100;
				break;
		
			case 4:
				n1 = lb.nextInt(9999 - 1000 +1)+1000;
				break;
				
			case 5: 
				n1 = lb.nextInt(99999 - 10000 +1)+1;
				break;
		}
		
		switch (aleatorio2)
		{
			case 1: 
				n2 = lb.nextInt(9)+1;
				break;
				
			case 2: 
				n2 = lb.nextInt(99 - 10 +1)+10;
				break;
				
			case 3: 
				n2 = lb.nextInt(999 - 100 +1)+100;
				break;
		
			case 4:
				n2 = lb.nextInt(9999 - 1000 +1)+1000;
				break;
				
			case 5: 
				n2 = lb.nextInt(99999 - 10000 +1)+1;
				break;
		}
		
		int result;
		
		System.out.printf ("\n Cuanto es %d - %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosRestaMezcla ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosRestaMezcla ();
			}
		}
	}
	
	public static void elgirNivelDificultadMultplicacion()
	{
		int nivelDificultad;
		
		System.out.println("\n Niveles de dificultad disponibles: ");
		System.out.println("\n 1) Producto de numeros con un digito");
		System.out.println(" 2) Producto de numeros con dos digitos (Bloqueado)");
		System.out.println(" 3) Producto de numeros con tres digitos (Bloqueado)");
		System.out.println(" 6) Producto de numeros con digitos variados (Bloqueado)");
		System.out.println(" 0) Regresar al menu principal");
		
		System.out.print("\n Eliga la opcion que desee: ");
		nivelDificultad=lc.nextInt();
		nivelesDificultadMultiplicacion(nivelDificultad);
		
	}
	
	public static void nivelesDificultadMultiplicacion (int nivelDificultad) 
	{
		switch (nivelDificultad)
		{
			case 0:
				elegirNivelAritmetico();
				break;
		
		 	case 1:
		 		System.out.println("\n Entro al nivel de dificultad 1, se mostraran multiplicaciones con solo un digito");
		 		generarNumerosMultiplicacion1Digito();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 2:
		 		System.out.println("\n Entro al nivel de dificultad 2, se mostraran multiplicaciones con dos digitos");
		 		generarNumerosMultiplicacion2Digito ();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 3:
		 		System.out.println("\n Entro al nivel de dificultad 3, se mostraran multiplicaciones con tres digitos");
		 		generarNumerosMultiplicacion3Digito ();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 6:
		 		System.out.println("\n Entro al nivel de dificultad 6, se mostraran multiplicacionescon digitos variados");
		 		generarNumerosMultplicacionMezcla ();
		 		mostrarRespuestas();
		 		break;
		}
	}
	
	public static void generarNumerosMultiplicacion1Digito ()
	{
		int n1 =  lb.nextInt(9);
		int n2 =  lb.nextInt(9);
		
		int result;
		
		System.out.printf ("\n Cuanto es %d x %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 * n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosMultiplicacion1Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosMultiplicacion1Digito ();
			}
		}
	}
	
	public static void generarNumerosMultiplicacion2Digito ()
	{
		int n1 = lb.nextInt(99 - 10 +1)+10;
		int n2 = lb.nextInt(99 - 10 +1)+10;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d x %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 * n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosMultiplicacion2Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosMultiplicacion2Digito ();
			}
		}
	}
	
	public static void generarNumerosMultiplicacion3Digito ()
	{
		int n1 = lb.nextInt(999 - 100 +1)+100;
		int n2 = lb.nextInt(999 - 100 +1)+100;
		
		int result;
		
		System.out.printf ("\n Cuanto es %d x %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 * n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosMultiplicacion3Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosMultiplicacion3Digito ();
			}
		}
	}
	
	public static void generarNumerosMultplicacionMezcla ()
	{
		int aleatorio = 1 + lb.nextInt(4);
		int aleatorio2 = 1 + lb.nextInt(4);
		
		int n1=0,n2=0;
		
		switch (aleatorio)
		{
			case 1: 
				n1 = lb.nextInt(9)+1;
				break;
				
			case 2: 
				n1 = lb.nextInt(99 - 10 +1)+10;
				break;
				
			case 3: 
				n1 = lb.nextInt(999 - 100 +1)+100;
				break;
		
			case 4:
				n1 = lb.nextInt(9999 - 1000 +1)+1000;
				break;
		
		}
		
		switch (aleatorio2)
		{
			case 1: 
				n2 = lb.nextInt(9)+1;
				break;
				
			case 2: 
				n2 = lb.nextInt(99 - 10 +1)+10;
				break;
				
			case 3: 
				n2 = lb.nextInt(999 - 100 +1)+100;
				break;
		
			case 4:
				n2 = lb.nextInt(9999 - 1000 +1)+1000;
				break;
		}
		
		int result;
		
		System.out.printf ("\n Cuanto es %d x %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 * n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosMultplicacionMezcla ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosMultplicacionMezcla ();
			}
		}
	}
	
	public static void elgirNivelDificultadDivision()
	{
		int nivelDificultad;
		
		System.out.println("\n Niveles de dificultad disponibles: ");
		System.out.println("\n 1) Cociente de numeros con un digito ");
		System.out.println(" 2) Cociente de numeros con dos digitos (Bloqueado)");
		System.out.println(" 6) Cociente de numeros con digitos variados (Bloqueado)");
		System.out.println(" 0) Regresar al menu principal");
		
		System.out.print("\n Eliga la opcion que desee: ");
		nivelDificultad=lc.nextInt();
		nivelesDificultadDivision(nivelDificultad);
		
	}
	
	public static void nivelesDificultadDivision (int nivelDificultad) 
	{
		switch (nivelDificultad)
		{
			case 0:
				elegirNivelAritmetico();
				break;
		
		 	case 1:
		 		System.out.println("\n Entro al nivel de dificultad 1, se mostraran divisones con solo un digito");
		 		System.out.println("\n IMPORTANTE: Solo escriba el cociente de la divison mostrda, osea si\n"
		 				+ " el programa muestra 4/5 solo ponga su cociente que es: 0 ");
		 		
		 		System.out.println("\n Por que esto?\n Bueno esto se debe a que hay valores que son infinitos "
		 				+ "como 4/3 que\n seria igual 1.33... y por lo tanto al introducir como resultado 1.333 el\n"
		 				+ " programa tomara el resultado como mal");
		 		generarNumerosDivision1Digito();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 2:
		 		System.out.println("\n Entro al nivel de dificultad 2, se mostraran divisones con dos digitos");
		 		System.out.println("\n IMPORTANTE: Solo escriba el cociente de la divison mostrda, osea si\n"
		 				+ " el programa muestra 4/5 solo ponga su cociente que es: 0 ");
		 		
		 		System.out.println("\n Por que esto?\n Bueno esto se debe a que hay valores que son infinitos "
		 				+ "como 4/3 que\n seria igual 1.33... y por lo tanto al introducir como resultado 1.333 el\n"
		 				+ " programa tomara el resultado como mal");
		 		generarNumerosDivision2Digito();
		 		mostrarRespuestas();
		 		break;
		 		
		 	case 6:
		 		System.out.println("\n Entro al nivel de dificultad 6, se mostraran divisones con digitos variados");
		 		System.out.println("\n IMPORTANTE: Solo escriba el cociente de la divison mostrda, osea si\n"
		 				+ " el programa muestra 4/5 solo ponga su cociente que es: 0 ");
		 		
		 		System.out.println("\n Por que esto?\n Bueno esto se debe a que hay valores que son infinitos "
		 				+ "como 4/3 que\n seria igual 1.33... y por lo tanto al introducir como resultado 1.333 el\n"
		 				+ " programa tomara el resultado como mal");
		 		generarNumerosDivisionMezcla ();
		 		mostrarRespuestas();
		 		break;
		}
	}
	
	public static void generarNumerosDivision1Digito ()
	{
		int n1 = 1 + lb.nextInt(9);
		int n2 = 1 +  lb.nextInt(9);
		float result;
		
		System.out.printf ("\n Cuanto es %d / %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextFloat();
		
		if (result == (n1/n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosDivision1Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosDivision1Digito ();
			}
		}
	}
	
	public static void generarNumerosDivision2Digito ()
	{
		
		int n1,n2;
		
		 n1 = lb.nextInt(99 - 10 +1)+10;
		 n2 = lb.nextInt(99 - 10 +1)+10;
		 
		float result;
		
		System.out.printf ("\n Cuanto es %d / %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextFloat();
		
		if (result == (n1/n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosDivision2Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosDivision2Digito ();
			}
		}
	}
	
	public static void generarNumerosDivisionMezcla ()
	{
		int aleatorio = 1 + lb.nextInt(2);
		int aleatorio2 = 1 + lb.nextInt(2);
		
		int n1=0,n2=0;
		
		switch (aleatorio)
		{
			case 1: 
				n1 = lb.nextInt(999 - 100 +1)+100;
				break;
				
			case 2: 
				n1 = lb.nextInt(99 - 10 +1)+10;
				break;
		}
		
		switch (aleatorio2)
		{
			case 1: 
				n2 = lb.nextInt(9)+1;
				break;
				
			case 2: 
				n2 = lb.nextInt(99 - 10 +1)+10;
				break;
		}
		
		int result;
		
		System.out.printf ("\n Cuanto es %d / %d?",n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 / n2))
		{
			contadorCorrectas++;
			cont++;
			mensajesAleatoriosCorrecto();
			
			if (cont<=10)
			{
				generarNumerosDivisionMezcla ();
			}
		}
		
		else 
		{
			contadorIncorrectas++;
			cont++;
			if (cont<=10)
			{
				generarNumerosDivisionMezcla ();
			}
		}
	}
	
	public static void generarOperacionesAletorias ()
	{
		int operaciones = 1 + lb.nextInt(3);
		int suma,resta,multiplicacion,div;
		int result;
		int n1,n2;
		
		switch (operaciones)
		{
		case 1:
			suma = 1 + lb.nextInt(4);
				switch (suma)
				{
				case 1:
					n1 = 1 + lb.nextInt(9);
					n2 = 1 +  lb.nextInt(9);
					
					System.out.printf ("\n Cuanto es %d + %d?",n1,n2);
					System.out.print ("\n Escriba aqui su resultado: ");
					result=lc.nextInt();
					
					if (result == (n1 + n2))
					{
						contadorCorrectas++;
						cont++;
						mensajesAleatoriosCorrecto();
						
						if (cont<=10)
						{
							generarOperacionesAletorias();
						}
					}
					
					else 
					{
						contadorIncorrectas++;
						cont++;
						if (cont<=10)
						{
							generarOperacionesAletorias();
						}
					}
					break;
				
				case 2:
					n1 = lb.nextInt(99 - 10 +1)+10;
					n2 = lb.nextInt(99 - 10 +1)+10;
					
					System.out.printf ("\n Cuanto es %d + %d?",n1,n2);
					System.out.print ("\n Escriba aqui su resultado: ");
					result=lc.nextInt();
					
					
					if (result == (n1 + n2))
					{
						contadorCorrectas++;
						cont++;
						mensajesAleatoriosCorrecto();
						
						if (cont<=10)
						{
							generarOperacionesAletorias();
						}
					}
					
					else 
					{
						contadorIncorrectas++;
						cont++;
						if (cont<=10)
						{
							generarOperacionesAletorias();
						}
					}
					break;
					
				case 3:
					n1 = lb.nextInt(999 - 100 +1)+100;
					n2 = lb.nextInt(999 - 100 +1)+100;
					
					System.out.printf ("\n Cuanto es %d + %d?",n1,n2);
					System.out.print ("\n Escriba aqui su resultado: ");
					result=lc.nextInt();
					
					if (result == (n1 + n2))
					{
						contadorCorrectas++;
						cont++;
						mensajesAleatoriosCorrecto();
						
						if (cont<=10)
						{
							generarOperacionesAletorias();
						}
					}
					
					else 
					{
						contadorIncorrectas++;
						cont++;
						if (cont<=10)
						{
							generarOperacionesAletorias();
						}
					}
					break;
				}
			
		case 2:
			resta = 1 + lb.nextInt(3);
				switch (resta)
				{
					case 1: 
						n1 = 1 + lb.nextInt(9);
						n2 = 1 +  lb.nextInt(9);
						
						System.out.printf ("\n Cuanto es %d - %d?",n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						if (result == (n1 - n2))
						{
							contadorCorrectas++;
							cont++;
							mensajesAleatoriosCorrecto();
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						
						else 
						{
							contadorIncorrectas++;
							cont++;
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						break;
						
				  case 2: 
					    n1 = lb.nextInt(99 - 10 +1)+10;
						n2 = lb.nextInt(99 - 10 +1)+10;
						
						System.out.printf ("\n Cuanto es %d - %d?",n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						
						if (result == (n1 - n2))
						{
							contadorCorrectas++;
							cont++;
							mensajesAleatoriosCorrecto();
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						
						else 
						{
							contadorIncorrectas++;
							cont++;
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						break;
							
				  case 3: 
					    n1 = lb.nextInt(999 - 100 +1)+100;
						n2 = lb.nextInt(999 - 100 +1)+100;
						
						System.out.printf ("\n Cuanto es %d - %d?",n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						
						if (result == (n1 - n2))
						{
							contadorCorrectas++;
							cont++;
							mensajesAleatoriosCorrecto();
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						
						else 
						{
							contadorIncorrectas++;
							cont++;
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						break;
					
				}
			
		case 3:
			multiplicacion = 1 + lb.nextInt(3);
				switch (multiplicacion)
				{
				 	case 1: 
				 		n1 = 1 + lb.nextInt(9);
						n2 = 1 +  lb.nextInt(9);
						
						System.out.printf ("\n Cuanto es %d x %d?",n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						if (result == (n1 * n2))
						{
							contadorCorrectas++;
							cont++;
							mensajesAleatoriosCorrecto();
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						
						else 
						{
							contadorIncorrectas++;
							cont++;
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						break;
						
				 	case 2: 
					    n1 = lb.nextInt(99 - 10 +1)+10;
						n2 = lb.nextInt(99 - 10 +1)+10;
						
						System.out.printf ("\n Cuanto es %d x %d?",n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						
						if (result == (n1 * n2))
						{
							contadorCorrectas++;
							cont++;
							mensajesAleatoriosCorrecto();
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						
						else 
						{
							contadorIncorrectas++;
							cont++;
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						break;
						
				 case 3: 
					    n1 = lb.nextInt(999 - 100 +1)+100;
						n2 = lb.nextInt(999 - 100 +1)+100;
						
						System.out.printf ("\n Cuanto es %d x %d?",n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						
						if (result == (n1 * n2))
						{
							contadorCorrectas++;
							cont++;
							mensajesAleatoriosCorrecto();
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						
						else 
						{
							contadorIncorrectas++;
							cont++;
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
				}
				
			case 4:
				div = 1 + lb.nextInt(1);
				
				switch (div)
					{
					case 1:
						
						int aleatorio = 1 + lb.nextInt(2);
						int aleatorio2 = 1 + lb.nextInt(2);
						
						int nn1=0;
						int nn2=0;
						
						switch (aleatorio)
						{
							case 1: 
								nn1 = lb.nextInt(999 - 100 +1)+100;
								break;
								
							case 2: 
								nn1 = lb.nextInt(99 - 10 +1)+10;
								break;
						}
						
						switch (aleatorio2)
						{
							case 1: 
								nn2 = lb.nextInt(9)+1;
								break;
								
							case 2: 
								nn2 = lb.nextInt(99 - 10 +1)+10;
								break;
						}
						
						
						System.out.printf ("\n Cuanto es %d / %d?",nn1,nn2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						if (result==(nn1 / nn2))
						{
							contadorCorrectas++;
							cont++;
							mensajesAleatoriosCorrecto();
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						
						else 
						{
							contadorIncorrectas++;
							cont++;
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						}
						break;
					}
			break;
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
	
	public static void mostrarRespuestas ()
	{
		if (contadorCorrectas>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectas);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectas);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			elgirNivelDificultadSuma();
		}
		
		else 
			if (contadorCorrectas<=8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectas);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectas);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				elgirNivelDificultadSuma();
			} 
	}
}
