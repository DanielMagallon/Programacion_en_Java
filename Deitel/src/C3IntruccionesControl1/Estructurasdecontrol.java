package C3IntruccionesControl1;

import java.util.Scanner;

/* Java cuenta con el operador condicional(? : ) , que en ocasiones puede utilizarse en lugar de una 
 * instrucción i f  . . . e l s e .  
 * El primer operando  (a la izquierda del ?) es una expresión  booleana (boolean) (es decir, una  condición que se 
 * evalua a un valor boolean:true o false).
 * El segundo operando ( entre el ? y : )  es el valor de la expresión condicional si la expresión 
 * booleana es verdadera.
 * Y el tercer operando (a la derecha del : ) es el valor de la expresión condicional 
 * si la expresión booleana se evalúa como false.  
 */

public class Estructurasdecontrol {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int c1, c2, c3, c4, c5;

		System.out.println("Calificacion 1: ");
		c1 = input.nextInt();

		System.out.println("Calificacion 1: ");
		c2 = input.nextInt();

		System.out.println("Calificacion 1: ");
		c3 = input.nextInt();

		System.out.println("Calificacion 1: ");
		c4 = input.nextInt();

		System.out.println("Calificacion 1: ");
		c5 = input.nextInt();

		int cal = c1 + c2 + c3 + c4 + c5;

		/*
		 * if (cal>=60)System.out.println("Aprobado");
		 * 
		 * else System.out.println("Reprobado");
		 */
		System.out.println(cal >= 60 ? "Aprobado" : "Reprobado"); // Es lo mismo
																	// usar el ?
																	// : que
																	// usar un
																	// if...else.

	}

}
