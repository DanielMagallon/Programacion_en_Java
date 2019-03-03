package C1IntroduccionAplicaciones;
// Programa que muestra la suma de dos numeros enrteros
import java.util.Scanner; // El programa usa la clase Scanner

/*
 * Todas las declaraciones import deben iniciarse antes de la clase.
 * Las intrucciones de declaracion terminan con un punto y coma.
 * Un objeto Scanner permite al prograa leer datos.
 * El signo " = " indica que es necesario inicializar la variable -input- tipo Scanner.
 * La palabra clave "new" se usa para crear un objeto Scanner que lea los datos escritos por el usuario.
 * El -objeto de estandar "System.in"- permite a las aplicaciones Java leer la informacion escrita por el usuario.
 * El rango de valores para un  int es de -2,147,483,648 a +2,147,483,647.
 * Hay otros tipos de datos como float  y double,para guardar números reales, y el tipo char,para guardar datos de caracteres.
 * Las variables de tipo char representan caracteres individuales, como una letra en mayúscula (A), un dígito ( 7 ) , 
 * un carácter especial (* o %) o una secuencia de escape (como el carácter de nueva línea, \ n ) .
 * La letra "d (%d)" se refiere a  “entero decimal”.
 * El singo "%" tambien se toma como un operador en Java, el cual es el residuo de una division. (17 % 5 produce 2.)
 */


public class Bienvenido5_Suma 
	{
		public static void main(String[] args) 
		{
			//  crea objeto Scanner para obtener la entrada de la ventana de comandos
			Scanner input=new Scanner (System.in);
			
			int numero1; // primer numero a sumar.		|	int numero1, |_ Se pueden declarar variables del mismo tipo
			int numero2; // segundo numero a sumar.		|	numero2,  	  _>	en una sola declaracion, en donde las
			int suma; // suma de numero1 y numero2.		| 	suma; 		 |  variables se separan con una coma (,).
			
			System.out.println("Escribe el primer numero: "); // indicador
			numero1=input.nextInt(); // lee el primer numero del usuario.
			
			System.out.println("Escribe el segundo numero: "); // indicador
			numero2=input.nextInt(); // lee el segundo numero del usuario.
			
			//System.out.printf("La suma es %d\n", numero1 + numero2 ); // Se puede hacer la suma, sin la necesidad de declarar la variable "suma"
			
			suma = numero1 + numero2; // suma los dos nmeros, despues almacena el total en suma.
			System.out.printf("La suma es %d\n", suma); // muestra la suma.	
			
		}
	}