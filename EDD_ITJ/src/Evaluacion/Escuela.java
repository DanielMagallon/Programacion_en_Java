package Evaluacion;

public class Escuela
{

	String numeroControl,nombre;
	int numeroMaterias;
	Datos obd = new Datos();
	
	public void leer()
	{
		numeroControl = obd.leerCadena("Numero de control");
		nombre = obd.leerCadena("Nombre");
		do
		{
			numeroMaterias = obd.leerEntero("Numero de materias: ");
			
		}while(numeroMaterias<3 || numeroMaterias>7);
	}
	
	public void mostrar()
	{
		System.out.println("Numero de control: "+numeroControl);
		System.out.println("Nombre: "+nombre);
		System.out.println("Numero de materias: "+numeroMaterias);
	} 
}
