package C3Evaluacion;

import java.util.Scanner;

//1.- Para sacar la raiz cuadrada en JAVA se usa la funcion Math.sqrt (valor o variable de la que se sacara su raiz)
//2.- Para sacar la potencia en JAVA se usa la funcion Math.pow (valor del numero que se sacara,valor de la potencia por la que se sacara el valor dado.)

public class Triangulorectangulo 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner (System.in);

		int catetoa,catetob,hipotenusa,hipotenusa1;

		System.out.print (" ---Introduce los lados para determinar si\n se puede construir un triangulo rectangulo--- ");
		System.out.println();
		System.out.println();
		System.out.println(" Nota: Solo introduzca valores enteros, la hipotenusa no tomara en cuenta los decimales");
		System.out.println();



		System.out.print (" Cateto a: ");
		catetoa=input.nextInt();

		System.out.println();

		System.out.print (" Cateto b: ");
		catetob=input.nextInt();

		System.out.println();

		System.out.print (" Hipotenusa: ");
		hipotenusa=input.nextInt();
		System.out.println();
		   
		hipotenusa1=(int) Math.sqrt((Math.pow (catetoa,2)) + Math.pow (catetob,2));

		System.out.printf (" El valor de la hipotenusa debe ser: %d\n", hipotenusa1);
		System.out.println();
		System.out.println();

		if (hipotenusa == hipotenusa1)

			System.out.println(" Los valores introducidos son capaces de construir un triangulo rectangulo\n");

			

		else
			System.out.print (" Los valores introducidos no son capaces de construir un triangulo rectangulo");
		}
}
