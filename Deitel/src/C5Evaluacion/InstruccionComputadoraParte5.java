package C5Evaluacion;

import java.util.Random;
import java.util.Scanner;

public class InstruccionComputadoraParte5
{
	public static Scanner lc = new Scanner(System.in);
	public static Random lb = new Random();
	public static int contadorCorrectas;
	public static int contadorIncorrectas;
	
	public static int contadorCorrectasSuma1D, contadorIncorrectasSuma1D;
	public static int contadorSuma=1;
	
	public static int contadorCorrectasSuma2D, contadorIncorrectasSuma2D;
	public static int contadorSuma2D=1;
	
	public static int contadorCorrectasSuma3D, contadorIncorrectasSuma3D;
	public static int contadorSuma3D=1;
	
	public static int contadorCorrectasSuma4D, contadorIncorrectasSuma4D;
	public static int contadorSuma4D=1;
	
	public static int contadorCorrectasSuma5D, contadorIncorrectasSuma5D;
	public static int contadorSuma5D=1;
	
	public static int contadorCorrectasSumaNivel6, contadorIncorrectasSumaNivel6;
	public static int contadorSumaNivel6=1;
	
	public static boolean banderaSuma1D,banderaSuma2D,banderaSuma3D,banderaSuma4D,banderaSuma5D,banderaNivelSuma6;
	
	
	public static int contadorCorrectasResta1D, contadorIncorrectasResta1D;
	public static int contadorResta=1;
	
	public static int contadorCorrectasResta2D, contadorIncorrectasResta2D;
	public static int contadorResta2D=1;
	
	public static int contadorCorrectasResta3D, contadorIncorrectasResta3D;
	public static int contadorResta3D=1;
	
	public static int contadorCorrectasResta4D, contadorIncorrectasResta4D;
	public static int contadorResta4D=1;
	
	public static int contadorCorrectasResta5D, contadorIncorrectasResta5D;
	public static int contadorResta5D=1;
	
	public static int contadorCorrectasRestaNivel6, contadorIncorrectasRestaNivel6;
	public static int contadorRestaNivel6=1;
	
	public static boolean banderaResta1D,banderaResta2D,banderaResta3D,banderaResta4D,banderaResta5D,banderaNivelResta6;
	
	
	public static int contadorCorrectasDiv1D, contadorIncorrectasDiv1D;
	public static int contadorDiv=1;
	
	public static int contadorCorrectasDiv2D, contadorIncorrectasDiv2D;
	public static int contadorDiv2D=1;
	
	public static int contadorCorrectasDivNivel6, contadorIncorrectasDivNivel6;
	public static int contadorDivNivel6=1;
	
	public static boolean banderaDiv1D,banderaDiv2D,banderaNivelDiv6;
	
	
	public static int contadorCorrectasMult1D, contadorIncorrectasMult1D;
	public static int contadorMult=1;
	
	public static int contadorCorrectasMult2D, contadorIncorrectasMult2D;
	public static int contadorMult2D=1;
	
	public static int contadorCorrectasMult3D, contadorIncorrectasMult3D;
	public static int contadorMult3D=1;
	
	public static int contadorCorrectasMultNivel6,contadorIncorrectasMultNivel6;
	public static int contadorMultNivel6=1;
	
	public static boolean banderaMult1D,banderaMult2D,banderaMult3D,banderaNivelMult6;
	
	public static String nivel1Sumas="1) Nivel 1 (DESBLOQUEADO)";
	public static String nivel2Sumas="2) Nivel 2 (BLOQUEADO)";
	public static String nivel3Sumas="3) Nivel 3 (BLOQUEADO)";
	public static String nivel4Sumas="4) Nivel 4 (BLOQUEADO)";
	public static String nivel5Sumas="5) Nivel 5 (BLOQUEADO)";
	public static String nivel6Sumas="6) Nivel 6 (BLOQUEADO)";
	
	
	public static String nivel1Restas="1) Nivel 1 (DESBLOQUEADO)";
	public static String nivel2Restas="2) Nivel 2 (BLOQUEADO)";
	public static String nivel3Restas="3) Nivel 3 (BLOQUEADO)";
	public static String nivel4Restas="4) Nivel 4 (BLOQUEADO)";
	public static String nivel5Restas="5) Nivel 5 (BLOQUEADO)";
	public static String nivel6Restas="6) Nivel 6 (BLOQUEADO)";
	
	
	public static String nivel1Mult="1) Nivel 1 (DESBLOQUEADO)";
	public static String nivel2Mult="2) Nivel 2 (BLOQUEADO)";
	public static String nivel3Mult="3) Nivel 3 (BLOQUEADO)";
	public static String nivel6Mult="6) Nivel 6 (BLOQUEADO)";
	
	public static String nivel1Div="1) Nivel 1 (DESBLOQUEADO)";
	public static String nivel2Div="2) Nivel 2 (BLOQUEADO)";
	public static String nivel6Divt="6) Nivel 6 (BLOQUEADO)";
	
	public static int cont=1;
	public static int nivelAritmetico;
	public static int nivelDificultad;

	
	public static String nivel1Arit="1) Sumas",nivel2Arit="2) Restas",
			nivel3Arit="3) Multiplicaciones",nivel4Arit="4) Divisones",nivel5Arit="5) Mezcla Aleatoria (BLOQUEADO)";
	
	
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
		
		System.out.println ("\n Niveles Aritmeticos disponiles: ");
		System.out.printf ("\n %s\n %s\n %s\n %s\n ",nivel1Arit,nivel2Arit,nivel3Arit,nivel4Arit);
		
		if (banderaNivelDiv6==true) //&& banderaNivelMult6==true && banderaNivelResta6==true && banderaNivelSuma6==true)
		{
			nivel5Arit="5) Mezcla Aleatoria (DESBLOQUEADA)";
		}
		
		System.out.printf ("%s\n",nivel5Arit);	
		
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
			if (banderaNivelSuma6==false)
			{
			System.out.println("\n Ha entrado a las operaciones de Suma");
			elgirNivelDificultadSuma();
			}
			else
			{
				System.out.println("\n Ya paso todos los niveles de las Sumas.Regrese al menu principal");
				nivel6Sumas="6) Nivel 6 (LOGRADO)";
				elgirNivelDificultadSuma();
			}
			break;
			
		case 2:
			if (banderaNivelResta6==false)
			{
			System.out.println("\n Ha entrado a las operaciones de Resta");
			elgirNivelDificultadResta();
			}
			
			else
			{
				System.out.println("\n Ya paso todos los niveles de las Restas.Regrese al menu principal");
				nivel6Restas="6) Nivel 6 (LOGRADO)";
				elgirNivelDificultadResta();
			}
			
			break;
			
		case 3:
			if (banderaNivelMult6==false)
			{
			System.out.println("\n Ha entrado a las operaciones de Multiplicacion");
			elgirNivelDificultadMultplicacion();
			}
			else 
			{
				System.out.println("\n Ya paso todos los niveles de las Multiplicaciones.Regrese al menu principal");
				nivel6Mult="6) Nivel 6 (LOGRADO)";
				elgirNivelDificultadMultplicacion();
			}
			break;
			
		case 4:
			if (banderaNivelDiv6==false)
			{
			System.out.println("\n Ha entrado a las operaciones de Division\n\n IMPORTANTE:"
					+ " Escriba como resultado solo el cociente de la division,\n si la operacion generada fuera:"
					+ "\n 4/3 escriba solo 1 y no sus decimales.");
			elgirNivelDificultadDivision();
			}
			else 
			{
				System.out.println("\n Ya paso todos los niveles de las Divisiones.Regrese al menu principal");
				nivel6Divt="6) Nivel 6 (LOGRADO)";
				elgirNivelDificultadDivision();
			}
			break;
			
		case 5:
			if ( banderaNivelDiv6==true && banderaNivelSuma6==true && banderaNivelResta6 == true 
				&& banderaNivelMult6==true )
				
			{
			System.out.println("\n Ha entrado a la mezcla aleatoria de todos los tipos de operaciones\n y digitos variados");
			System.out.println("\n Este nivel no tomara en cuenta las respuestas correctas o incorrectas,solamente"
					+ "\n le pondra un mensaje que le indicara si estuvo bien o mal."
					+ "\n Tambien podra acceder a el las veces que quiera. ");
			System.out.println("\n El numero de veces que se repiten las operaciones varian en cada ejecucion del programa.");
			
			generarOperacionesAletorias();
			Felicitaciones();
			}
			else
			{
				System.out.println("\n No puede acceder a este nivel aún. Para poder hacerlo,\n "
						+ "debe pasar todos los niveles dados anteriormente.\n");
				elegirNivelAritmetico();
			}
			break;
			
		case 0:
			System.exit(0);
			break;
			
		default:
			System.out.println("\n No existe esa opcion. Vuelva a introducirla.\n");
			elegirNivelAritmetico();
			break;
		}
	}
	
	
	public static void elgirNivelDificultadSuma()
	{
		int nivelDificultad;
		
		System.out.println("\n      ----NIVEL SUMAS----");
		
		System.out.println("\n Niveles de dificultad disponibles: ");
		System.out.printf ("\n %s\n %s\n %s\n %s\n %s\n %s\n",nivel1Sumas,nivel2Sumas,nivel3Sumas,nivel4Sumas,nivel5Sumas,nivel6Sumas);
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
		 		if (banderaSuma1D==false)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 1, se mostraran sumas con solo un digito");
		 		generarNumerosSuma1Digito();
		 		}
		 		
		 		else	if (banderaSuma1D == true && banderaSuma2D == true)
	 			{
	 				System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (LOGRADO)";
		 			
		 			elgirNivelDificultadSuma();
	 			}
		 		
		 	
		 		
		 		else if (banderaSuma1D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (DESBLOQUEADO)";
		 			
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 			
		 		break;
		 		
		 	case 2:
		 		
		 		if  (banderaSuma1D == false)
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 		else if (banderaSuma2D==true && banderaSuma3D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (LOGRADO)";
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 		else if (banderaSuma2D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (LOGRADO)";
		 			nivel3Sumas="3) Nivel 3 (DESBLOQUEADO)";
		 			elgirNivelDificultadSuma();
		 		}
		 		 
		 		
		 		 else	if (banderaSuma1D == true )
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 2, se mostraran sumas con dos digitos");
		 		generarNumerosSuma2Digito();
		 			
		 		}
		 		
		 		break;
		 		
		 	case 3:
		 		
		 		if (banderaSuma2D==false) 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 		else if (banderaSuma3D==true && banderaSuma4D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (LOGRADO)";
		 			nivel3Sumas="3) Nivel 3 (LOGRADO)";
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 		else if (banderaSuma3D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (LOGRADO)";
		 			nivel3Sumas="3) Nivel 3 (LOGRADO)";
		 			nivel4Sumas="3) Nivel 4 (DESBLOQUEADO)";
		 			elgirNivelDificultadSuma();
		 		}

		 		else if (banderaSuma2D==true)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 3, se mostraran sumas con tres digitos");
		 		generarNumerosSuma3Digito();
		 		}
		 		
		 		break;
		 		
		 	case 4:
		 		
		 		if (banderaSuma3D==false) 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 			
		 		}
		 		
		 		else	if (banderaSuma4D==true && banderaSuma5D==true )
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (LOGRADO)";
		 			nivel3Sumas="3) Nivel 3 (LOGRADO)";
		 			nivel4Sumas="4) Nivel 4 (LOGRADO)";
		 			elgirNivelDificultadSuma();
		 			
		 		}
		 		else if (banderaSuma4D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (LOGRADO)";
		 			nivel3Sumas="3) Nivel 3 (LOGRADO)";
		 			nivel4Sumas="4) Nivel 4 (LOGRADO)";
		 			nivel5Sumas="5) Nivel 5 (DESBLOQUEADO)";
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 		else if (banderaSuma3D == true)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 4, se mostraran sumas con cuatro digitos");
		 		generarNumerosSuma4Digito();
		 		}
		 		
		 		break;
		 	
		 	case 5:
		 		
		 		if (banderaSuma4D==false) 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 		else	if (banderaSuma5D==true && banderaNivelSuma6==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (LOGRADO)";
		 			nivel3Sumas="3) Nivel 3 (LOGRADO)";
		 			nivel4Sumas="4) Nivel 4 (LOGRADO)";
		 			nivel5Sumas="5) Nivel 5 (LOGRADO)";
		 			elgirNivelDificultadSuma();
		 			
		 		}
		
		 		else	if (banderaSuma5D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Sumas="1) Nivel 1 (LOGRADO)";
		 			nivel2Sumas="2) Nivel 2 (LOGRADO)";
		 			nivel3Sumas="3) Nivel 3 (LOGRADO)";
		 			nivel4Sumas="4) Nivel 4 (LOGRADO)";
		 			nivel5Sumas="5) Nivel 5 (LOGRADO)";
		 			nivel6Sumas="6) Nivel 6 (DESBLOQUEADO)";
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 		else if (banderaSuma4D==true)
		 		{
		 			System.out.println("\n Entro al nivel de dificultad 5, se mostraran sumas con cuatro digitos");
			 		generarNumerosSuma5Digito();
		 		}
		 		break;
		 		
		 	case 6:
		 		
		 		if (banderaSuma5D==false)
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 		else if (banderaNivelSuma6==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			elgirNivelDificultadSuma();
		 		}
		 		
		 		
		 		else	if (banderaSuma5D==true)
		 		{
		 		System.out.println("\n Entro al nivel 6. Se mostraran sumas cond digitos variados");
		 		generarNumerosSumaMezcla();
		 		}
		 		
		 		break;
		 		
		 	default:
		 		System.out.println("\n No existe ese nivel, vuelva a escogerlo");
		 		elgirNivelDificultadSuma();
		}
	}
	
	public static void generarNumerosSuma1Digito ()
	{
		int n1 =  lb.nextInt(9);
		int n2 =  lb.nextInt(9);
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d + %d?",contadorSuma,n1,n2);
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
			if (contadorSuma<=10)
			{
				generarNumerosSuma1Digito();
			}
		}
		
		if (contadorCorrectasSuma1D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma1D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma1D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaSuma1D = true;
			
			nivel1Sumas="1) Nivel 1 (LOGRADO)";
			nivel2Sumas="2) Nivel 2 (DESBLOQUEADO)";
			elgirNivelDificultadSuma();
			
		}
		
		else 
			if (contadorCorrectasSuma1D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma1D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma1D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorSuma=1;
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
		
		System.out.printf ("\n %d.- Cuanto es %d + %d?",contadorSuma2D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectasSuma2D++;
			contadorSuma2D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorSuma2D<=10)
			{
				generarNumerosSuma2Digito();
			}
		}
		
		else 
		{
			contadorIncorrectasSuma2D++;
			contadorSuma2D++;
			if (contadorSuma2D<=10)
			{
				generarNumerosSuma2Digito();
			}
		}
		
		if (contadorCorrectasSuma2D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma2D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma2D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaSuma2D = true;
			
			nivel1Sumas="1) Nivel 1 (LOGRADO)";
			nivel2Sumas="2) Nivel 2 (LOGRADO)";
			nivel3Sumas="3) Nivel 3 (DESBLOQUEADO)";
			elgirNivelDificultadSuma();
		}
		
		else 
			if (contadorCorrectasSuma2D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma2D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma2D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorSuma2D=1;
				contadorIncorrectasSuma2D=0;
				contadorCorrectasSuma2D=0;
				elgirNivelDificultadSuma();
				
			} 
	}
	
	public static void generarNumerosSuma3Digito ()
	{
		int n1 = lb.nextInt(999 - 100 +1)+100;
    	int n2 = lb.nextInt(999 - 100 +1)+100;
	
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d + %d?",contadorSuma3D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectasSuma3D++;
			contadorSuma3D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorSuma3D<=10)
			{
				generarNumerosSuma3Digito();
			}
		}
		
		else 
		{
			contadorIncorrectasSuma3D++;
			contadorSuma3D++;
			if (contadorSuma3D<=10)
			{
				generarNumerosSuma3Digito();
			}
		}
		
		if (contadorCorrectasSuma3D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma3D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma3D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaSuma3D = true;
			
			nivel1Sumas="1) Nivel 1 (LOGRADO)";
			nivel2Sumas="2) Nivel 2 (LOGRADO)";
			nivel3Sumas="3) Nivel 3 (LOGRADO)";
			nivel4Sumas="4) Nivel 4 (DESBLOQUEADO)";
			elgirNivelDificultadSuma();
			
		}
		
		else 
			if (contadorCorrectasSuma3D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma3D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma3D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorSuma3D=1;
				contadorIncorrectasSuma3D=0;
				contadorCorrectasSuma3D=0;
				elgirNivelDificultadSuma();
				
			} 
	}
	
	public static void generarNumerosSuma4Digito ()
	{
		int n1 = lb.nextInt(9999 - 1000 +1)+1000;
		 int n2 = lb.nextInt(9999 - 1000 +1)+1000;
		
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d + %d?",contadorSuma4D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectasSuma4D++;
			contadorSuma4D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorSuma4D<=10)
			{
				generarNumerosSuma4Digito();
			}
		}
		
		else 
		{
			contadorIncorrectasSuma4D++;
			contadorSuma4D++;
			if (contadorSuma4D<=10)
			{
				generarNumerosSuma4Digito();
			}
		}
		
		if (contadorCorrectasSuma4D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma4D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma4D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaSuma4D = true;
			
			nivel1Sumas="1) Nivel 1 (LOGRADO)";
			nivel2Sumas="2) Nivel 2 (LOGRADO)";
			nivel3Sumas="3) Nivel 3 (LOGRADO)";
			nivel4Sumas="3) Nivel 4 (LOGRADO)";
			nivel5Sumas="5) Nivel 5 (DESBLOQUEADO)";
			elgirNivelDificultadSuma();
			
		}
		
		else 
			if (contadorCorrectasSuma4D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma4D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma4D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorSuma4D=1;
				contadorIncorrectasSuma4D=0;
				contadorCorrectasSuma4D=0;
				elgirNivelDificultadSuma();
			} 
	}
	
	public static void generarNumerosSuma5Digito ()
	{
		int n1 = lb.nextInt(99999 - 10000 +1)+10000;
	    int n2 = lb.nextInt(99999 - 10000 +1)+10000;
		
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d + %d?",contadorSuma5D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectasSuma5D++;
			contadorSuma5D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorSuma5D<=10)
			{
				generarNumerosSuma5Digito();
			}
		}
		
		else 
		{
			contadorIncorrectasSuma5D++;
			contadorSuma5D++;
			if (contadorSuma5D<=10)
			{
				generarNumerosSuma5Digito();
			}
		}
		
		
		if (contadorCorrectasSuma5D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma5D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma5D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaSuma5D = true;
			
			nivel1Sumas="1) Nivel 1 (LOGRADO)";
			nivel2Sumas="2) Nivel 2 (LOGRADO)";
			nivel3Sumas="3) Nivel 3 (LOGRADO)";
			nivel4Sumas="4) Nivel 4 (LOGRADO)";
			nivel5Sumas="5) Nivel 5 (LOGRADO)";
			nivel6Sumas="6) Nivel 6 (DESBLOQUEADO)";
			elgirNivelDificultadSuma();
		}
		
		else 
			if (contadorCorrectasSuma5D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSuma5D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSuma5D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorSuma5D=1;
				contadorIncorrectasSuma5D=0;
				contadorCorrectasSuma5D=0;
				elgirNivelDificultadSuma();
				
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
		
		System.out.printf ("\n %d.- Cuanto es %d + %d?",contadorSumaNivel6,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 + n2))
		{
			contadorCorrectasSumaNivel6++;
			contadorSumaNivel6++;
			mensajesAleatoriosCorrecto();
			
			if (contadorSumaNivel6<=10)
			{
				generarNumerosSumaMezcla ();
			}
		}
		
		else 
		{
			contadorIncorrectasSumaNivel6++;
			contadorSumaNivel6++;
			if (contadorSumaNivel6<=10)
			{
				generarNumerosSumaMezcla();
			}
		}
		
		if (contadorCorrectasSumaNivel6>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSumaNivel6);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSumaNivel6);
			
			System.out.println("\n Excelente¡¡ Logro pasar el nivel de las Sumas\n");
			
			banderaNivelSuma6 = true;
			nivel1Arit="1) Sumas (LOGRADO)";

			elegirNivelAritmetico();
		}
		
		else 
			if (contadorCorrectasSumaNivel6<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasSumaNivel6);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasSumaNivel6);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorSumaNivel6=1;
				contadorIncorrectasSumaNivel6=0;
				contadorCorrectasSumaNivel6=0;
				elgirNivelDificultadSuma();
			} 
		
		
	}
	
	public static void elgirNivelDificultadResta()
	{
		int nivelDificultad;
		
		System.out.println("\n      ----NIVEL RESTAS----");
		
		System.out.println("\n Niveles de dificultad disponibles: ");
		System.out.printf ("\n %s\n %s\n %s\n %s\n %s\n %s\n",nivel1Restas,nivel2Restas,nivel3Restas
				,nivel4Restas,nivel5Restas,nivel6Restas);
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
		 		if (banderaResta1D==false)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 1, se mostraran restas con solo un digito");
		 		generarNumerosResta1Digito();
		 		}
		 		
		 		else	if (banderaResta1D == true && banderaResta2D == true)
	 			{
	 				System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (LOGRADO)";
		 			
		 			elgirNivelDificultadResta();
	 			}
	
		 		
		 		else if (banderaResta1D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (DESBLOQUEADO)";
		 			
		 			elgirNivelDificultadResta();
		 		}
		 		
		 			
		 		break;
		 		
		 	case 2:
		 		
		 		if  (banderaResta1D == false)
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadResta();
		 		}
		 		
		 		else if (banderaResta2D==true && banderaResta3D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (LOGRADO)";
		 			elgirNivelDificultadResta();
		 		}
		 		
		 		else if (banderaResta2D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (LOGRADO)";
		 			nivel3Restas="3) Nivel 3 (DESBLOQUEADO)";
		 			elgirNivelDificultadResta();
		 		}
		 		 
		 		
		 		 else	if (banderaResta1D == true )
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 2, se mostraran restas con dos digitos");
		 		generarNumerosResta2Digito();
		 			
		 		}
		 		
		 		break;
		 		
		 	case 3:
		 		
		 		if (banderaResta2D==false) 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadResta();
		 		}
		 		
		 		else if (banderaResta3D==true && banderaResta4D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (LOGRADO)";
		 			nivel3Restas="3) Nivel 3 (LOGRADO)";
		 			elgirNivelDificultadResta();
		 		}
		 		
		 		else if (banderaResta3D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (LOGRADO)";
		 			nivel3Restas="3) Nivel 3 (LOGRADO)";
		 			nivel4Restas="3) Nivel 4 (DESBLOQUEADO)";
		 			elgirNivelDificultadResta();
		 		}

		 		else if (banderaResta2D==true)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 3, se mostraran restas con tres digitos");
		 		generarNumerosResta3Digito();
		 		}
		 		
		 		break;
		 		
		 	case 4:
		 		
		 		if (banderaResta3D==false) 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadResta();
		 			
		 		}
		 		
		 		else	if (banderaResta4D==true && banderaResta5D==true )
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (LOGRADO)";
		 			nivel3Restas="3) Nivel 3 (LOGRADO)";
		 			nivel4Restas="4) Nivel 4 (LOGRADO)";
		 			elgirNivelDificultadResta();
		 			
		 		}
		 		else if (banderaResta4D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (LOGRADO)";
		 			nivel3Restas="3) Nivel 3 (LOGRADO)";
		 			nivel4Restas="4) Nivel 4 (LOGRADO)";
		 			nivel5Restas="5) Nivel 5 (DESBLOQUEADO)";
		 			elgirNivelDificultadResta();
		 		}
		 		
		 		else if (banderaResta3D == true)
		 		{
		 		System.out.println("\n Entro al nivel de dificultad 4, se mostraran restas con cuatro digitos");
		 		generarNumerosResta4Digito();
		 		}
		 		
		 		break;
		 	
		 	case 5:
		 		
		 		if (banderaResta4D==false) 
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadResta();
		 		}
		 		
		 		else	if (banderaResta5D==true && banderaNivelResta6==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (LOGRADO)";
		 			nivel3Restas="3) Nivel 3 (LOGRADO)";
		 			nivel4Restas="4) Nivel 4 (LOGRADO)";
		 			nivel5Restas="5) Nivel 5 (LOGRADO)";
		 			elgirNivelDificultadResta();
		 			
		 		}
		
		 		else	if (banderaResta5D==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			
		 			nivel1Restas="1) Nivel 1 (LOGRADO)";
		 			nivel2Restas="2) Nivel 2 (LOGRADO)";
		 			nivel3Restas="3) Nivel 3 (LOGRADO)";
		 			nivel4Restas="4) Nivel 4 (LOGRADO)";
		 			nivel5Restas="5) Nivel 5 (LOGRADO)";
		 			nivel6Restas="6) Nivel 6 (DESBLOQUEADO)";
		 			elgirNivelDificultadResta();
		 		}
		 		
		 		else if (banderaResta4D==true)
		 		{
		 			System.out.println("\n Entro al nivel de dificultad 5, se mostraran restas con cuatro digitos");
			 		generarNumerosResta5Digito();
		 		}
		 		break;
		 		
		 	case 6:
		 		
		 		if (banderaResta5D==false)
		 		{
		 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
		 			elgirNivelDificultadResta();
		 		}
		 		
		 		else if (banderaNivelResta6==true)
		 		{
		 			System.out.println("\n Ya paso ese nivel.");
		 			elgirNivelDificultadResta();
		 		}
		 		
		 		
		 		else	if (banderaResta5D==true)
		 		{
		 		System.out.println("\n Entro al nivel 6. Se mostraran restas cond digitos variados");
		 		generarNumerosRestaMezcla();
		 		}
		 		
		 		break;
		 		
		 	default:
		 		System.out.println("\n No existe ese nivel, vuelva a escogerlo");
		 		elgirNivelDificultadResta();
		}
	}
	
	public static void generarNumerosResta1Digito ()
	{
		int n1 =  lb.nextInt(9);
		int n2 =  lb.nextInt(9);
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d - %d?",contadorResta,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectasResta1D++;
			contadorResta++;
			mensajesAleatoriosCorrecto();
			
			if (contadorResta<=10)
			{
				generarNumerosResta1Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasResta1D++;
			contadorResta++;
			if (contadorResta<=10)
			{
				generarNumerosResta1Digito ();
			}
		}
		
		if (contadorCorrectasResta1D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta1D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta1D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaResta1D = true;
			
			nivel1Restas="1) Nivel 1 (LOGRADO)";
			nivel2Restas="2) Nivel 2 (DESBLOQUEADO)";
			elgirNivelDificultadResta();
		}
		
		else
			if (contadorCorrectasResta1D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta1D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta1D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorResta=1;
				contadorIncorrectasResta1D=0;
				contadorCorrectasResta1D=0;
				elgirNivelDificultadResta();
			}
		
	}
	
	public static void generarNumerosResta2Digito ()
	{
	    int n1 = lb.nextInt(99 - 10 +1)+10;
		int n2 = lb.nextInt(99 - 10 +1)+10;
		
		
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d - %d?",contadorResta2D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectasResta2D++;
			contadorResta2D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorResta2D<=10)
			{
				generarNumerosResta2Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasResta2D++;
			contadorResta2D++;
			if (contadorResta2D<=10)
			{
				generarNumerosResta2Digito ();
			}
		}
		
		if (contadorCorrectasResta2D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta2D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta2D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaResta2D = true;
			
			nivel1Restas="1) Nivel 1 (LOGRADO)";
			nivel2Restas="2) Nivel 2 (LOGRADO)";
			nivel3Restas="3) Nivel 3 (DESBLOQUEADO)";
			elgirNivelDificultadResta();
		}
		
		else
			if (contadorCorrectasResta2D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta2D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta2D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorResta2D=1;
				contadorIncorrectasResta2D=0;
				contadorCorrectasResta2D=0;
				elgirNivelDificultadResta();
			}
		
	}
	
	public static void generarNumerosResta3Digito ()
	{
		int n1 = lb.nextInt(999 - 100 +1)+100;
		int n2 = lb.nextInt(999 - 100 +1)+100;
		
	
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d - %d?",contadorResta3D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectasResta3D++;
			contadorResta3D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorResta3D<=10)
			{
				generarNumerosResta3Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasResta3D++;
			contadorResta3D++;
			if (contadorResta3D<=10)
			{
				generarNumerosResta3Digito ();
			}
		}
		
		if (contadorCorrectasResta3D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta3D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta3D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaResta3D = true;
			
			nivel1Restas="1) Nivel 1 (LOGRADO)";
			nivel2Restas="2) Nivel 2 (LOGRADO)";
			nivel3Restas="3) Nivel 3 (LOGRADO)";
			nivel4Restas="4) Nivel 4 (DESBLOQUEADO)";
			elgirNivelDificultadResta();
		}
		
		else
			if (contadorCorrectasResta3D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta3D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta3D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorResta3D=1;
				contadorIncorrectasResta3D=0;
				contadorCorrectasResta3D=0;
				elgirNivelDificultadResta();
				
			}
		
	}
	
	public static void generarNumerosResta4Digito ()
	{
		int n1 = lb.nextInt(9999 - 1000 +1)+1000;
	    int n2 = lb.nextInt(9999 - 1000 +1)+1000;
	
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d - %d?",contadorResta4D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectasResta4D++;
			contadorResta4D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorResta4D<=10)
			{
				generarNumerosResta4Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasResta4D++;
			contadorResta4D++;
			if (contadorResta4D<=10)
			{
				generarNumerosResta4Digito ();
			}
		}
		
		if (contadorCorrectasResta4D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta4D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta4D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaResta4D = true;
			
			nivel1Restas="1) Nivel 1 (LOGRADO)";
			nivel2Restas="2) Nivel 2 (LOGRADO)";
			nivel3Restas="3) Nivel 3 (LOGRADO)";
			nivel4Restas="3) Nivel 4 (LOGRADO)";
			nivel5Restas="5) Nivel 5 (DESBLOQUEADO)";
			elgirNivelDificultadResta();
			
		}
		
		else
			if (contadorCorrectasResta4D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta4D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta4D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorResta4D=1;
				contadorIncorrectasResta4D=0;
				contadorCorrectasResta4D=0;
				elgirNivelDificultadResta();
			}
	}
	
	public static void generarNumerosResta5Digito ()
	{
		int n1 = lb.nextInt(99999 - 10000 +1)+10000;
		int n2 = lb.nextInt(99999 - 10000 +1)+10000;
		
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d - %d?",contadorResta5D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectasResta5D++;
			contadorResta5D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorResta5D<=10)
			{
				generarNumerosResta5Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasResta5D++;
			contadorResta5D++;
			if (contadorResta5D<=10)
			{
				generarNumerosResta5Digito ();
			}
		}
		
		if (contadorCorrectasResta5D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta5D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta5D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaResta5D = true;
			
			
			nivel1Restas="1) Nivel 1 (LOGRADO)";
			nivel2Restas="2) Nivel 2 (LOGRADO)";
			nivel3Restas="3) Nivel 3 (LOGRADO)";
			nivel4Restas="4) Nivel 4 (LOGRADO)";
			nivel5Restas="5) Nivel 5 (LOGRADO)";
			nivel6Restas="6) Nivel 6 (DESBLOQUEADO)";
			elgirNivelDificultadResta();
		}
		
		else
			if (contadorCorrectasResta5D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasResta5D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasResta5D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorResta5D=1;
				contadorIncorrectasResta5D=0;
				contadorCorrectasResta5D=0;
				elgirNivelDificultadResta();
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
		
		System.out.printf ("\n %d.- Cuanto es %d - %d?",contadorRestaNivel6,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 - n2))
		{
			contadorCorrectasRestaNivel6++;
			contadorRestaNivel6++;
			mensajesAleatoriosCorrecto();
			
			if (contadorRestaNivel6<=10)
			{
				generarNumerosRestaMezcla ();
			}
		}
		
		else 
		{
			contadorIncorrectasRestaNivel6++;
			contadorRestaNivel6++;
			if (contadorRestaNivel6<=10)
			{
				generarNumerosRestaMezcla ();
			}
		}
		
		if (contadorCorrectasRestaNivel6>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasRestaNivel6);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasRestaNivel6);
			
			System.out.println("\n Excelente¡¡ Logro pasar el nivel de las Restas\n");
			
			banderaNivelResta6 = true;
			
			nivel2Arit="2) RESTAS (LOGRADO)";
			
			elegirNivelAritmetico();
			
		}
		
		else 
			if (contadorCorrectasRestaNivel6<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasRestaNivel6);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasRestaNivel6);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorRestaNivel6=1;
				contadorIncorrectasRestaNivel6=0;
				contadorCorrectasRestaNivel6=0;
				elgirNivelDificultadResta();
			} 
	}
	
	public static void elgirNivelDificultadMultplicacion()
	{

		int nivelDificultad;
		
		System.out.println("\n      ----NIVEL MULTIPLICACIONES----");
		
		System.out.println("\n Niveles de dificultad disponibles: ");
		System.out.printf ("\n %s\n %s\n %s\n %s\n",nivel1Mult,nivel2Mult,nivel3Mult,nivel6Mult);
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
	 		if (banderaMult1D==false)
	 		{
	 		System.out.println("\n Entro al nivel de dificultad 1, se mostraran multiplicaciones con solo un digito");
	 		generarNumerosMultiplicacion1Digito();
	 		}
	 		
	 		else	if (banderaMult1D == true && banderaMult2D == true)
 			{
 				System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Mult="1) Nivel 1 (LOGRADO)";
	 			nivel2Mult="2) Nivel 2 (LOGRADO)";
	 			
	 			elgirNivelDificultadMultplicacion();
 			}
	 		
	 		
	 		else if (banderaMult1D==true)
	 		{
	 			System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Mult="1) Nivel 1 (LOGRADO)";
	 			nivel2Mult="2) Nivel 2 (DESBLOQUEADO)";
	 			
	 			elgirNivelDificultadMultplicacion();
	 		}
	 		
	 			
	 		break;
	 		
	 	case 2:
	 		
	 		if  (banderaMult1D == false)
	 		{
	 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
	 			elgirNivelDificultadMultplicacion();
	 		}
	 		
	 		else if (banderaMult2D==true && banderaMult3D==true)
	 		{
	 			System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Mult="1) Nivel 1 (LOGRADO)";
	 			nivel2Mult="2) Nivel 2 (LOGRADO)";
	 			elgirNivelDificultadMultplicacion();
	 		}
	 		
	 		else if (banderaMult2D==true)
	 		{
	 			System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Mult="1) Nivel 1 (LOGRADO)";
	 			nivel2Mult="2) Nivel 2 (LOGRADO)";
	 			nivel3Mult="3) Nivel 3 (DESBLOQUEADO)";
	 			elgirNivelDificultadMultplicacion();
	 		}
	 		 
	 		
	 		 else	if (banderaMult1D == true )
	 		{
	 		System.out.println("\n Entro al nivel de dificultad 2, se mostraran multiplicaciones con dos digitos");
	 		generarNumerosMultiplicacion2Digito();
	 			
	 		}
	 		
	 		break;
	 		
	 	case 3:
	 		
	 		if (banderaMult2D==false) 
	 		{
	 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
	 			elgirNivelDificultadMultplicacion();
	 		}
	 		
	 		else if (banderaMult3D==true && banderaNivelMult6==true)
	 		{
	 			System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Mult="1) Nivel 1 (LOGRADO)";
	 			nivel2Mult="2) Nivel 2 (LOGRADO)";
	 			nivel3Mult="3) Nivel 3 (LOGRADO)";
	 			elgirNivelDificultadMultplicacion();
	 		}
	 		
	 		else if (banderaMult3D==true)
	 		{
	 			System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Mult="1) Nivel 1 (LOGRADO)";
	 			nivel2Mult="2) Nivel 2 (LOGRADO)";
	 			nivel3Mult="3) Nivel 3 (LOGRADO)";
	 			nivel6Mult="6) Nivel 6 (DESBLOQUEADO)";
	 			elgirNivelDificultadMultplicacion();
	 		}

	 		else if (banderaMult2D==true)
	 		{
	 		System.out.println("\n Entro al nivel de dificultad 3, se mostraran multiplicaciones con tres digitos");
	 		generarNumerosMultiplicacion3Digito();
	 		}
	 		
	 		break;
	 		
	 	case 6:
	 		
	 		if (banderaMult3D==false)
	 		{
	 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
	 			elgirNivelDificultadMultplicacion();
	 		}
	 		
	 		else if (banderaNivelMult6==true)
	 		{
	 			System.out.println("\n Ya paso ese nivel.");
	 			elgirNivelDificultadMultplicacion();
	 		}
	 		
	 		
	 		else	if (banderaMult3D==true)
	 		{
	 		System.out.println("\n Entro al nivel 6. Se mostraran multiplicaciones con digitos variados");
	 		generarNumerosMultplicacionMezcla();
	 		}
	 		
	 		break;
	 		
	 	default:
	 		System.out.println("\n No existe ese nivel, vuelva a escogerlo");
	 		elgirNivelDificultadMultplicacion();
		}
	}
	
	public static void generarNumerosMultiplicacion1Digito ()
	{
		int n1 =  lb.nextInt(9);
		int n2 =  lb.nextInt(9);
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d x %d?",contadorMult,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 * n2))
		{
			contadorCorrectasMult1D++;
			contadorMult++;
			mensajesAleatoriosCorrecto();
			
			if (contadorMult<=10)
			{
				generarNumerosMultiplicacion1Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasMult1D++;
			contadorMult++;
			if (contadorMult<=10)
			{
				generarNumerosMultiplicacion1Digito ();
			}
		}
		
		if (contadorCorrectasMult1D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasMult1D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasMult1D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaMult1D = true;
			
			nivel1Mult="1) Nivel 1 (LOGRADO)";
			nivel2Mult="2) Nivel 2 (DESBLOQUEADO)";
			elgirNivelDificultadMultplicacion();
			
		}
		
		else 
			if (contadorCorrectasMult1D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasMult1D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasMult1D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorMult=1;
				contadorIncorrectasMult1D=0;
				contadorCorrectasMult1D=0;
				elgirNivelDificultadMultplicacion();
			} 
		
	}
	
	public static void generarNumerosMultiplicacion2Digito ()
	{
		int n1 = lb.nextInt(99 - 10 +1)+10;
		int n2 = lb.nextInt(99 - 10 +1)+10;
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d x %d?",contadorMult2D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 * n2))
		{
			contadorCorrectasMult2D++;
			contadorMult2D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorMult2D<=10)
			{
				generarNumerosMultiplicacion2Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasMult2D++;
			contadorMult2D++;
			if (contadorMult2D<=10)
			{
				generarNumerosMultiplicacion2Digito ();
			}
		}
		
		if (contadorCorrectasMult2D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasMult2D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasMult2D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaMult2D = true;
			
			nivel1Mult="1) Nivel 1 (LOGRADO)";
			nivel2Mult="2) Nivel 2 (LOGRADO)";
			nivel3Mult="2) Nivel 3 (DESBLOQUEADO)";
			elgirNivelDificultadMultplicacion();
			
		}
		
		else 
			if (contadorCorrectasMult2D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasMult2D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasMult2D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorMult2D=1;
				contadorIncorrectasMult1D=0;
				contadorCorrectasMult1D=0;
				elgirNivelDificultadMultplicacion();
			} 
	}
	
	public static void generarNumerosMultiplicacion3Digito ()
	{
		int n1 = lb.nextInt(999 - 100 +1)+100;
		int n2 = lb.nextInt(999 - 100 +1)+100;
		
		int result;
		
		System.out.printf ("\n %d.- Cuanto es %d x %d?",contadorMult3D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 * n2))
		{
			contadorCorrectasMult3D++;
			contadorMult3D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorMult3D<=10)
			{
				generarNumerosMultiplicacion3Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasMult3D++;
			contadorMult3D++;
			if (contadorMult3D<=10)
			{
				generarNumerosMultiplicacion3Digito ();
			}
		}
		
		if (contadorCorrectasMult3D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasMult3D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasMult3D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaMult3D = true;
			
			nivel1Mult="1) Nivel 1 (LOGRADO)";
			nivel2Mult="2) Nivel 2 (LOGRADO)";
			nivel3Mult="2) Nivel 3 (LOGRADO)";
			nivel6Mult="2) Nivel 6 (DESBLOQUEADO)";
			elgirNivelDificultadMultplicacion();
			
		}
		
		else 
			if (contadorCorrectasMult3D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasMult3D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasMult3D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorMult3D=1;
				contadorIncorrectasMult3D=0;
				contadorCorrectasMult3D=0;
				elgirNivelDificultadMultplicacion();
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
		
		System.out.printf ("\n %d.- Cuanto es %d x %d?",contadorMultNivel6,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 * n2))
		{
			contadorCorrectasMultNivel6++;
			contadorMultNivel6++;
			mensajesAleatoriosCorrecto();
			
			if (contadorMultNivel6<=10)
			{
				generarNumerosMultplicacionMezcla ();
			}
		}
		
		else 
		{
			contadorIncorrectasMultNivel6++;
			contadorMultNivel6++;
			if (contadorMultNivel6<=10)
			{
				generarNumerosMultplicacionMezcla ();
			}
		}
		
		if (contadorCorrectasMultNivel6>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasMultNivel6);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasMultNivel6);
			
			System.out.println("\n Excelente¡¡ Logro pasar el nivel de las Multiplicaciones\n");
			
			banderaNivelMult6 = true;
			nivel3Arit="3) Multiplicaciones (LOGRADO)";
			
			elegirNivelAritmetico();
			
		}
		
		else 
			if (contadorCorrectasMultNivel6<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasMultNivel6);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasMultNivel6);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorMultNivel6=1;
				contadorIncorrectasMultNivel6=0;
				contadorCorrectasMultNivel6=0;
				elgirNivelDificultadMultplicacion();
				} 
	}
	
	public static void elgirNivelDificultadDivision()
	{
		int nivelDificultad;
		
		System.out.println("\n      ----NIVEL DIVISIONES----");
		
		System.out.println("\n Niveles de dificultad disponibles: ");
		System.out.printf ("\n %s\n %s\n %s\n",nivel1Div,nivel2Div,nivel6Divt);
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
	 		if (banderaDiv1D==false)
	 		{
	 		System.out.println("\n Entro al nivel de dificultad 1, se mostraran divisiones con solo un digito");
	 		generarNumerosDivision1Digito();
	 		}
	 		
	 		else	if (banderaDiv1D == true && banderaDiv2D == true)
 			{
 				System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Div="1) Nivel 1 (LOGRADO)";
	 			nivel2Div="2) Nivel 2 (LOGRADO)";
	 			
	 			elgirNivelDificultadDivision();
 			}
	 	
	 		
	 		else if (banderaDiv1D==true)
	 		{
	 			System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Div="1) Nivel 1 (LOGRADO)";
	 			nivel2Div="2) Nivel 2 (DESBLOQUEADO)";
	 			
	 			elgirNivelDificultadDivision();
	 		}
	 		
	 			
	 		break;
	 		
	 	case 2:
	 		
	 		if  (banderaDiv1D == false)
	 		{
	 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
	 			elgirNivelDificultadDivision();
	 		}
	 		
	 		
	 		else if (banderaDiv2D && banderaNivelDiv6)
	 		{
	 			System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Div="1) Nivel 1 (LOGRADO)";
	 			nivel2Div="2) Nivel 2 (LOGRADO)";
	 			nivel6Divt="6) Nivel 6 (LOGRADO)";
	 			elgirNivelDificultadDivision();
	 		}
	 		
	 		else if (banderaDiv2D==true)
	 		{
	 			System.out.println("\n Ya paso ese nivel.");
	 			
	 			nivel1Div="1) Nivel 1 (LOGRADO)";
	 			nivel2Div="2) Nivel 2 (LOGRADO)";
	 			nivel6Divt="6) Nivel 6 (DESBLOQUEADO)";
	 			elgirNivelDificultadDivision();
	 		}
	 		 
	 		
	 		 else	if (banderaDiv1D == true )
	 		{
	 		System.out.println("\n Entro al nivel de dificultad 2, se mostraran divisiones con dos digitos");
	 		generarNumerosDivision2Digito();
	 			
	 		}
	 		
	 		break;
	 		
	 	case 6:
	 		
	 		if (banderaDiv2D==false)
	 		{
	 			System.out.println("\n No se puede acceder a este nivel. Necesita pasar el anterior");
	 			elgirNivelDificultadDivision();
	 		}
	 		
	 		else if (banderaNivelDiv6==true)
	 		{
	 			System.out.println("\n Ya ese nivel.");
	 			elgirNivelDificultadDivision();
	 		}
	 		
	 		
	 		else	if (banderaDiv2D==true)
	 		{
	 		System.out.println("\n Entro al nivel 6. Se mostraran multiplicaciones con digitos variados");
	 		generarNumerosDivisionMezcla();
	 		}
	 		
	 		break;
	 		
	 	default:
	 		System.out.println("\n No existe ese nivel, vuelva a escogerlo");
	 		elgirNivelDificultadDivision();
		}
		}
	
	
	public static void generarNumerosDivision1Digito ()
	{
		int n1 = 1 + lb.nextInt(9);
		int n2 = 1 +  lb.nextInt(9);
		float result;
		
		System.out.printf ("\n %d.- Cuanto es %d / %d?",contadorDiv,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextFloat();
		
		if (result == (n1/n2))
		{
			contadorCorrectasDiv1D++;
			contadorDiv++;
			mensajesAleatoriosCorrecto();
			
			if (contadorDiv<=10)
			{
				generarNumerosDivision1Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasDiv1D++;
			contadorDiv++;
			if (contadorDiv<=10)
			{
				generarNumerosDivision1Digito ();
			}
		}
		
		if (contadorCorrectasDiv1D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasDiv1D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasDiv1D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaDiv1D = true;
			
			nivel1Div="1) Nivel 1 (LOGRADO)";
			nivel2Div="2) Nivel 2 (DESBLOQUEADO)";
			elgirNivelDificultadDivision();
			
		}
		
		else 
			if (contadorCorrectasDiv1D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasDiv1D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasDiv1D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorDiv=1;
				contadorIncorrectasDiv1D=0;
				contadorCorrectasDiv1D=0;
				elgirNivelDificultadDivision();
			} 
	}
	
	public static void generarNumerosDivision2Digito ()
	{
		
		int n1,n2;
		
		 n1 = lb.nextInt(99 - 10 +1)+10;
		 n2 = lb.nextInt(99 - 10 +1)+10;
		 
		float result;
		
		System.out.printf ("\n %d.- Cuanto es %d / %d?",contadorDiv2D,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextFloat();
		
		if (result == (n1/n2))
		{
			contadorCorrectasDiv2D++;
			contadorDiv2D++;
			mensajesAleatoriosCorrecto();
			
			if (contadorDiv2D<=10)
			{
				generarNumerosDivision2Digito ();
			}
		}
		
		else 
		{
			contadorIncorrectasDiv2D++;
			contadorDiv2D++;
			if (contadorDiv2D<=10)
			{
				generarNumerosDivision2Digito ();
			}
		}
		
		if (contadorCorrectasDiv2D>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasDiv2D);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasDiv2D);
			
			System.out.println("\n Felicidades¡ Esta listo para pasar al siguiente nivel");
			
			banderaDiv2D = true;
			
			nivel1Div="1) Nivel 1 (LOGRADO)";
			nivel2Div="2) Nivel 2 (LOGRADO)";
			nivel6Divt="6) Nivel 6 (DESBLOQUEADO)";
			elgirNivelDificultadDivision();
			
		}
		
		else 
			if (contadorCorrectasDiv2D<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasDiv2D);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasDiv2D);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorDiv2D=1;
				contadorIncorrectasDiv2D=0;
				contadorCorrectasDiv2D=0;
				elgirNivelDificultadDivision();
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
		
		System.out.printf ("\n %d.- Cuanto es %d / %d?",contadorDivNivel6,n1,n2);
		System.out.print ("\n Escriba aqui su resultado: ");
		result=lc.nextInt();
		
		if (result==(n1 / n2))
		{
			contadorCorrectasDivNivel6++;
			contadorDivNivel6++;
			mensajesAleatoriosCorrecto();
			
			if (contadorDivNivel6<=10)
			{
				generarNumerosDivisionMezcla ();
			}
		}
		
		else 
		{
			contadorIncorrectasDivNivel6++;
			contadorDivNivel6++;
			if (contadorDivNivel6<=10)
			{
				generarNumerosDivisionMezcla ();
			}
		}
		
		if (contadorCorrectasDivNivel6>=8)
		{
			System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasDivNivel6);
			System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasDivNivel6);
			
			System.out.println("\n Excelente¡¡ Logro pasar el nivel de las Divisones\n");
			
			banderaNivelDiv6 = true;
			nivel4Arit="4) Divisiones (LOGRADO)";
			
			elegirNivelAritmetico();
			
		}
		
		else 
			if (contadorCorrectasDivNivel6<8)
			{
				System.out.printf ("\n Respuestas correctas: %d",contadorCorrectasDivNivel6);
				System.out.printf ("\n Respuestas incorrectas: %d\n",contadorIncorrectasDivNivel6);
				
				System.out.println("\n Por favor pida ayuda adicional a su instructor");
				contadorDivNivel6=1;
				contadorIncorrectasDivNivel6=0;
				contadorCorrectasDivNivel6=0;
				elgirNivelDificultadDivision();
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
					
					System.out.printf ("\n %d.- Cuanto es %d + %d?",cont,n1,n2);
					System.out.print ("\n Escriba aqui su resultado: ");
					result=lc.nextInt();
					
					if (result == (n1+n2))
					{
						mensajesAleatoriosCorrecto();
					}
					
					else
					{
						mensajesAleatoriosIncorrecto();
					}
					
						cont++;
						
						if (cont<=10)
						{
							generarOperacionesAletorias();
						}
					break;
				
				case 2:
					n1 = lb.nextInt(99 - 10 +1)+10;
					n2 = lb.nextInt(99 - 10 +1)+10;
					
					System.out.printf ("\n %d.- Cuanto es %d + %d?",cont,n1,n2);
					System.out.print ("\n Escriba aqui su resultado: ");
					result=lc.nextInt();
					
					if (result == (n1+n2))
					{
						mensajesAleatoriosCorrecto();
					}
					
					else
					{
						mensajesAleatoriosIncorrecto();
					}
				
						cont++;
						
						if (cont<=10)
						{
							generarOperacionesAletorias();
						}
					
					break;
					
				case 3:
					n1 = lb.nextInt(999 - 100 +1)+100;
					n2 = lb.nextInt(999 - 100 +1)+100;
					
					System.out.printf ("\n %d.- Cuanto es %d + %d?",cont,n1,n2);
					System.out.print ("\n Escriba aqui su resultado: ");
					result=lc.nextInt();

					if (result == (n1+n2))
					{
						mensajesAleatoriosCorrecto();
					}
					
					else
					{
						mensajesAleatoriosIncorrecto();
					}
					
					cont++;
						
						if (cont<=10)
						{
							generarOperacionesAletorias();
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
						
						System.out.printf ("\n %d.- Cuanto es %d - %d?",cont,n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();

						if (result == (n1-n2))
						{
							mensajesAleatoriosCorrecto();
						}
						
						else
						{
							mensajesAleatoriosIncorrecto();
						}
						
						cont++;
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						break;
						
				  case 2: 
					    n1 = lb.nextInt(99 - 10 +1)+10;
						n2 = lb.nextInt(99 - 10 +1)+10;
						
						System.out.printf ("\n %d.- Cuanto es %d - %d?",cont,n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						if (result == (n1-n2))
						{
							mensajesAleatoriosCorrecto();
						}
						
						else
						{
							mensajesAleatoriosIncorrecto();
						}
						
							cont++;
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						
						break;
							
				  case 3: 
					    n1 = lb.nextInt(999 - 100 +1)+100;
						n2 = lb.nextInt(999 - 100 +1)+100;
						
						System.out.printf ("\n %d.- Cuanto es %d - %d?",cont,n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						if (result == (n1-n2))
						{
							mensajesAleatoriosCorrecto();
						}
						
						else
						{
							mensajesAleatoriosIncorrecto();
						}
						
							cont++;
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
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
						
						System.out.printf ("\n %d.- Cuanto es %d x %d?",cont,n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						
						if (result == (n1*n2))
						{
							mensajesAleatoriosCorrecto();
						}
						
						else
						{
							mensajesAleatoriosIncorrecto();
						}
						
							cont++;
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						break;
						
				 	case 2: 
					    n1 = lb.nextInt(99 - 10 +1)+10;
						n2 = lb.nextInt(99 - 10 +1)+10;
						
						System.out.printf ("\n %d.- Cuanto es %d x %d?",cont,n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						

						if (result == (n1*n2))
						{
							mensajesAleatoriosCorrecto();
						}
						
						else
						{
							mensajesAleatoriosIncorrecto();
						}
						
							cont++;
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
							}
						
						break;
						
				 case 3: 
					    n1 = lb.nextInt(999 - 100 +1)+100;
						n2 = lb.nextInt(999 - 100 +1)+100;
						
						System.out.printf ("\n %d.- Cuanto es %d x %d?",cont,n1,n2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();
						

						if (result == (n1*n2))
						{
							mensajesAleatoriosCorrecto();
						}
						
						else
						{
							mensajesAleatoriosIncorrecto();
						}
						
							cont++;
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
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
						
						
						System.out.printf ("\n %d.- Cuanto es %d / %d?",cont,nn1,nn2);
						System.out.print ("\n Escriba aqui su resultado: ");
						result=lc.nextInt();


						if (result == (nn1/nn2))
						{
							mensajesAleatoriosCorrecto();
						}
						
						else
						{
							mensajesAleatoriosIncorrecto();
						}
						
						cont++;
							
							if (cont<=10)
							{
								generarOperacionesAletorias();
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
	
	public static void mensajesAleatoriosIncorrecto ()
	{
		int inccadena = 1 + lb.nextInt(4);
		
		switch (inccadena)
		{
			case 1:
				System.out.println("\n Esta mal.Lo sentimos");
				break;
				
			case 2:
				System.out.println("\n Necesita aprender mas¡");
				break;
				
			case 3:
				System.out.println("\n Esta seguro que sabe?");
				break;
				
			case 4:
				System.out.println("\n Respuesta incorrecta¡");
				break;
		}
	}
	
	public static void Felicitaciones ()
	{
		System.out.println("\n Felicidades por haber llegado hasta aqui¡¡ Esperemos lo haya disfrutado\n "
				+ "Puede volver a intentarlo o bien salirse del sistema.\n");
		cont=1;
		elegirNivelAritmetico();
	}
}
