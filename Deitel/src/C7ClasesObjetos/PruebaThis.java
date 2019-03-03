package C7ClasesObjetos;

// Uso implicito y explicito de this para hacer referencia a los miembros de un objeto

public class PruebaThis
{
	public static void main(String[] args)
	{
		TiempoSimple ts = new TiempoSimple(15,30,19);
		
		System.out.println(ts.crearString());
	}
}
	//la clase timepo simple demuestra a referencia "this"

	class TiempoSimple
	{
		private int hora;
		private int minuto;
		private int segundo;
		
		// si el constructor utiliza nombres de parametros identicos a 
		// los nombres de las variables de instancia, se requiere la referencia this
		// para diferenciar unos nombres de otros
		
		public TiempoSimple(int hora,int minuto,int segundo)
		{
			this.hora=hora; // establece la hora del objeto this
			this.minuto=minuto;  // establece el minuto del objeto this
			this.segundo=segundo;  // establece los segundos  del objeto this
		}
		
		public String crearString ()
		{
			return String.format("%24s: %s\n%24s: %s","this.aStringUniversal()",
					this.aStringUniversal(),"aStringUniversal()",aStringUniversal());
		}
		
		public String aStringUniversal()
		{
			// this no se requiere aqui para acceder a las variables de instancia 
			// ya que el metodo no tiene variables locales con los mismos 
			// nombres de las variables de instancia
			
			return String.format("%02d:%02d:%02d",this.hora,this.minuto,this.segundo);
		}
		
	}