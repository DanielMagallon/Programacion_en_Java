package HerenciaPolimorfismo;

public class FigurApp
{
	public static void main(String[] args)
	{
		Figura miF = new Triangulo(4,5);
		System.out.printf ("%s %.2f",miF.toString(),miF.area());
		
		Figura miF2 = new Triangulo(0,0);
		
		miF2.establecerAltura(60);
		miF2.establecerBase(5);

		System.out.printf ("\n%s %.2f",miF2.toString(),miF2.area());
		
		Figura miF3 = new Rectangulo(0,0);
		
		miF3.establecerAltura(60);
		miF3.establecerBase(5);
		
		System.out.printf ("\n%s %.2f",miF3.toString(),miF3.area());
		
		Figura miF4 = new Cuadrado(0);
		
		miF4.establecerLado_Radio_Cuadrado_Circulo(5);
		
		System.out.printf ("\n%s %.2f",miF4.toString(),miF4.area());
		
		Figura miF5 = new Circulo(0);
		
		miF5.establecerLado_Radio_Cuadrado_Circulo(8);
		
		System.out.printf ("\n%s %.2f",miF5.toString(),miF5.area());
		
		FiguraTridimensional miF6 = new Cubo(0, 0, 0);
		
		miF6.establecerLado_Radio_Cuadrado_Circulo(4);
		
		System.out.printf ("\n\n%s %.2f\n%.2f",miF6.toString(),miF6.area(),miF6.volumen());
		
	}
}
