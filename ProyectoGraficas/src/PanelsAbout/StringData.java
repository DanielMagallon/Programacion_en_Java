package PanelsAbout;

public class StringData
{
	public static String pasosCrear[][]=
			{
				{"1.- Para agregar datos, debe dar clic en nueva grafica","new.png"},
				{"2.- Despues debe dar clic en el boton Agregar categoria","table.png"},
				{"3.- Acontinuacion se le mostraran dos tipos de llenados por tabla/por lista",""},
				{"4-. Si usa la opcion por tabla debe añadir el nombre de la categoria,  y el numero"
						+ "de datos que contiene dicha categoria (frecuencias)",""},
				{"4.1.-En caso de que quiera hacerlo por porcentajes debe habilitar "
						+ "la opcion 'Graficar por porcentaje'",""},
				{"5.- Si desea agregalos por lista debe habilitar la opcion por lista",""},
				{"6.- Para agregarlos deben estar separados por un '-' cada categoria ",""},
				{"7.- El numero de categorias iguales que ingrese son la cantidad de datos que hay de esa categoria",
						""},
				{"8.- Se recomienda usar por lista cuando se quiere graficar por pastel","pastel.png"},
				{"9.- Los datos  pueden ser guardados y cargados en formato .table y .list",""},
				{"10.- Por ultimo para graficar presione Aplicar y despues en refrescar","refresh.png"},
			};
			
	public static String pasosCopyPaste[][] = 
		{
			{"1.- Localice el archivo a pegar, ya sea .table, .list o de imagen",""},
			{"2.- Seleccionelo y copielo",""},
			{"3.- Despues en la ventana principal peguelo, ya sea Ctrl+V o en la barra de herrmientas",""},
			{"4-. Y se le abrira una ventana graficando acorde a los datos del archivo",""},
			{"5.- Click aqui para hacer una prueba",""},
		};
	
	public static String [][] pasosPath =
		{
				{"1.- Al ejecutar la aplicacion por primera vez y asignar la ruta de recursos"
			+ "se generara un archivo path en la misma ruta que el jar",""},
				{"2.- Este archivo path contiene la ruta donde se almacenan los recursos, por lo que si se borra este archivo "
						+ "se le pedira asingar de nuevo la ruta",""},
				{"3.-Si el archivo path fuese eliminado procure copiar las carpetas de recursos de nuevo en la ruta donde esta el jar",""},
		};
	
	public static String[][] pasosCmd = 
		{
				{"1.- Si desea abrir un archivo en formato .table,.list o de imagen, sin necesidad de ejecutar la aplicacion haaga lo siguiente:",""},
				{"2.- Vaya al simbolo del sistema y ubiquese en la ruta donde esta el archivo jar (>cd Desktop)",""},
				{"3.- Tecle los comandos 'java -jar nombreDelJar.jar'",""},
				{"4.- Seguido de eso, deje un espacio e introduzca la ruta donde se encuentra el archivo a abrir: ",""},
				{"5.- > java -jar app.jar /home/yo/documentos/Archivos...../nombredelarchivo.table",""},
				{"6.- Ahora da enter y el programa en automatico desplegara la grafica correspondiente al archivo",""}
		};
	
}
