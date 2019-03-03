package C4InstruccionControl2;


// Crea un objeto LibroCalificaciones, introduce las calif, y mustra el reporte 

public class PruebaLibroCalificaciones_switch 
{
	public static void main(String[] args) 
	{
		// crea un objeto LibroCalificaciones llamado lb y pasa el nombre del curso al 
		// constructor.
		
		LibroCalificaciones_switch lb = new LibroCalificaciones_switch(
				" CS101 Introduccion a la programacion en Java");
		
		lb.mostrarMensaje();
		lb.introducirCalif();
		lb.mostrarReporteCalif();
	}
}
