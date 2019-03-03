package C5Evaluacion;

import java.util.Scanner;

public class Volumen_esfera 
{
	public static void main(String[] args) 
	{
		Scanner vol =  new Scanner(System.in);
		
		double radio;
		
		System.out.print (" Introduzca el radio de la esfera: ");
		radio = vol.nextDouble();
		
		double volumen = volumenEsfera(radio);
		
		System.out.printf (" El volumen de la esfera es de: %f\n",volumen);
	}
	
	public static double volumenEsfera (double rad)
	{
		double vol = (4.0/3.0) * Math.PI * Math.pow(rad, 3);
		return vol;
	}
}
