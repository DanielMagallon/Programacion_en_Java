package TiposDatosAbstractos;

public class EsferaApp {
	
	public static void main(String[] args) 
	{
		Esfera miEsfera = new Esfera(3);
		
		System.out.printf ("Radio: %.2f\n"
						   + "Diametro: %.2f\n"
						   + "Circunferencia: %.2f\n"
						   + "Area: %.2f\n"
						   + "Volumen: %.2f",miEsfera.getRadio(),
						   miEsfera.getDiametro(),miEsfera.getCircunferencia(),
						   miEsfera.getArea(),miEsfera.getVolumen());

	}
}
