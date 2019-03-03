package C7ClasesObjetos;

public class Fecha
{
	private int mes;
	private int dia;
	private int anio;
	
	private static final int[] diasPorMes =
		{0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	// constructor: llama comprobarMes para confirmar el valor apropiado para el mes;
	// llama a comprobarDia para confirmar el valor apropiado
	public Fecha (int elMes,int elDia,int elAnio)
	{
		mes=comprobarMes(elMes);
		anio=elAnio;
		dia=comprobarDia(elDia);
		
		System.out.printf ("Constructor de objeto Fecha para la fecha: %s\n",this);
	}
	
	// metodo utilitario para confirmar el valor apropiado del mes
	private int comprobarMes(int mesPrueba)
	{
		if (mesPrueba > 0 && mesPrueba <= 12)
			return mesPrueba;
		else
			throw new IllegalArgumentException("El mes debe de ser de 1-12");
	}
	
	// metodo utilitario para confirmar el valor apropiado del dia, con base en el mes y el año
	private int comprobarDia(int diaPrueba)
	{
		
			// comprueba si el dia esta dentro del rango para el mes
			if (diaPrueba > 0 && diaPrueba <= diasPorMes[mes])
				return diaPrueba;
			
			// comprueba si el año es bisiesto
			if (mes==2 && diaPrueba == 29 && (anio%400 == 0 || (anio%4==0 && anio%100 != 0)))
				return diaPrueba;

			throw new IllegalArgumentException("dia fuera de rango para mes y anio especificados");
	}
	
	public String toString ()
	{
		return String.format("%d/%d/%d",dia,mes,anio);
	}
}
