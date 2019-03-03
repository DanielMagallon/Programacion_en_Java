package C3IntruccionesControl1;

public class LibroCalPromedioPr {
	public static void main(String[] args) {
		LibroCalPromedio lc = new LibroCalPromedio(
				"CS101 Introduccion a la programacion en JAVA");

		lc.Mostrarmensaje(); // muestra mensaje bienvenida.
		lc.determinarPromedioClase(); // encuentra el promedio de las 10 calif.
	}
}
