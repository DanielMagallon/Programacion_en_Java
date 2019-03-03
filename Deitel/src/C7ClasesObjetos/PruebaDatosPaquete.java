package C7ClasesObjetos;

public class PruebaDatosPaquete
{
	public static void main(String[] args)
	{
		DatosPaquete datosPaquete = new DatosPaquete();
		
		// imprime la representacion String de Datos Paquete
		System.out.printf ("Despues de instanciar: \n%s\n",datosPaquete);
		
		// modifica los datos con acceso a nivel de de paquete en le objeto datPaquete
		datosPaquete.numero=77;
		datosPaquete.cadena="Adios";
		
		// imrpime la representacion String datosPaquete
		System.out.printf ("Despues de modificar valores: \n%s\n",datosPaquete);
	}
	
	static class DatosPaquete
	{
		int numero; //variable de instancia con acceso a nivel de paquete
		String cadena; // "                                            "
		
		public DatosPaquete ()
		{
			numero=0;
			cadena="Hola";
		}
		
		// devueve la representacion Stringdel objeto datosPaquete
		public String toString ()
		{
			return String.format("numero: %d; cadena: %s",numero,cadena);
		}
	}
}
