package C6ArreglosArrayList;

public class LibroCalificacionesArreglos
{
	private String nombreDelCurso; // nombre del curso que representa este LibroCali f i caci ones
	
	 private int [] calificaciones; // arreglo de calificaciones de estudiantes
	
	 // el constructor de dos argumentos inicializa nombreDelCurso y el arreglo calificaciones
	 
	 public LibroCalificacionesArreglos (String nombre, int [] arregloCalif )
	 {
		 nombreDelCurso = nombre; // inicializa nombreDelCurso
	    calificaciones = arregloCalif; // almacena la s c a lific a c io n e s
	    
	 }
	 
	 // método para establecer el nombre del curso
	 
	 public void establecerNombreDelCurso( String nombre )
	 {
		 nombreDelCurso = nombre; // almacena el nombre del curso
	 } 
	 
	 // método para obtener el nombre del curso
	  public String obtenerNombreDelCurso ()
	  {
	  return nombreDelCurso;
	  } 
	 
	  // muestra un mensaje de bienvenida a l usuario de LibroCalificacions
	  
	  public void mostrarMensaje ()
	  {
		  // obtenerNombreDelCurso obtiene el nombre del curso
		  System.out.printf ( "Bienvenido al libro de calificaciones para\n%s!\n\n" ,
				  obtenerNombreDelCurso() ) ;
	  } 
	 
	  // realiza varias operaciones sobre los datos
	  public void procesarCalificaciones ()
	  {
		  // imprime el a rreglo de calificaciones
		  imprimirCalificaciones () ;
	 
	  // llama al método obtenerPromedio para calcular la calificación promedio
	  System.out.printf ("\nEl promedio de la clase es %.2f\n" , obtenerPromedio() ) ;
	 
	  // llama a los métodos obtenerMinima y obtenerMaxima
	  System.out.printf ("La calificación mas baja es %d\nLa calificación mas alta es %d\n\n",
	  obtenerMinima(), obtenerMaxima() ) ;
	 
	  // llama a imprimirGraficoBarras para imprimir
	  
	  imprimirGraficoBarras() ;
	  
	  } 
	 
	  // busca la calificación más baja
	  public int obtenerMinima ()
	  {
	  int califBaja = calificaciones [0] ; // asume que calificaciones[0] es la más baja
	 
	  // itera a través del arreglo de calificaciones
	  for ( int calificacion : calificaciones )
	  {
	  // si calificación es menor que califBaja, se asigna a califBaja
	  if ( calificacion < califBaja )
	  califBaja = calificacion ; 
	  } 
	  
	  return califBaja ; 
	  } 
	 
	  // busca la calificación más alta
	  public int obtenerMaxima ()
	  {
		  int califAlta = calificaciones [0] ; // asume que calificaciones[0] es la más baja
	 
	  // itera a través del arreglo de calificaciones
	  for ( int calificacion : calificaciones )
	  {
		  
	  // si calificación es mayor que califBaja, se asigna a califBaja
	  if ( calificacion > califAlta )
	  califAlta = calificacion ;
	  
	  } 
	  
	  return califAlta; 
	  }
	  
	   //determina la calificación promedio de la prueba
	   public double obtenerPromedio ()
	   {
	   int total = 0 ; 
	  
	   for ( int calificacion : calificaciones )
		   total += calificacion;
	  
	   return (double) total/calificaciones.length;
	   } 
	   
	   
	   // imprime g rá fic o de b arras que muestra la d istrib u c ió n de la s c a lific a c io n e s
	    public void imprimirGraficoBarras()
	    {
	    System.out.println ("Distribución  de calificaciones:" ) ;
	   
	    // almacena la frecuencia de las calificaciones en cada rango de 10 calificaciones
	    int[] frecuencia = new int[11] ;
	   
	    // para cada calificación , incrementa la frecuencia apropiada
	    for ( int calificacion : calificaciones )
	     ++frecuencia[calificacion / 10] ;
	   
	    // para cada frecuencia de calificación, imprime una barra en el gráfico
	    for ( int cuenta = 0 ; cuenta < frecuencia.length; cuenta++ )
	    {
	   
	    	if ( cuenta == 10 )
	    		System.out.printf ( "%5d: " ,100 ) ;
	    
	    	else
	    		System.out.printf ( "%02d-%02d: " ,
	    				cuenta * 10, cuenta * 10 + 9 );
	   
	    // imprime barra de asteriscos
	    	for ( int estrellas = 0; estrellas < frecuencia [cuenta]; estrellas++ )
	    		System.out.print ( "*" ) ;
	   
	    System.out.println (); 
	    }
	    
	    } 
	
	    
	    // imprime el contenido del arreglo de calificaciones
	     public void imprimirCalificaciones ()
	     {
	    	 System.out.println ("Las calificaciones son:\n" );
	    
	     // imprime la calificación de cada estudiante
	    	 for (int estudiante = 0; estudiante < calificaciones.length; estudiante++ )
	    		 System.out.printf ("Estudiante %2d: %3d\n" , estudiante + 1, calificaciones[estudiante]);
	     } 
}
