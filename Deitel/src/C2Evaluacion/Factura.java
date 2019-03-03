package C2Evaluacion;

public class Factura 
	
	{

			private String numpz,despz; 
			private int cantidadpz;
			private double precioxpz;
			private double factura;
			
		public Factura (String npieza, String descrpz, int cant, double precio)
		
		{

			numpz = npieza;
			despz = descrpz;
			cantidadpz = cant;
			precioxpz = precio;
			
		}
		
		public void Establecernumpiz (String npieza)
		
		{
			
			numpz = npieza;
		}
		
		public String Obtenernumpiz ()
		
		{
			
			return numpz;
			
		}
		
		
		public void Establecerdespz (String descrpz)
		
		{
			
			despz = descrpz;
		}
		
		public String Obtenerdescpz ()
		
		{
			
			return despz;
			
		}
		
		
		public void Establecercant (int cant )
		
		{
			if (cant>0.0)
			cantidadpz = cant;
		}
		
		public int Obtenercant ()
		
		{
			
			return cantidadpz;
			
		}
		
		public void Establecer$ (double precio )
		
		{
			if (precio>0.0)
			precioxpz = precio;
		}
		
		public double Obtener$ ()
		
		{
			
			return precioxpz;
			
		}
		
		public double Obtenermontofactura ()
		
		{
			
			factura = precioxpz*cantidadpz;
			return factura;
			
		}
		
		
	
	}
