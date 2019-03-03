package C7ClasesObjetos;

public class HoraEnSegundos
{
	private int hora;
	private int minuto;
	private int segundo;
	
	// Constructor de Tiempo2 sin argumentos:
	// inicializa cada variable de instancia a cero
	public HoraEnSegundos ()
	{
		this (0,0,0); // invoca al constructor de tiempo2 con 3 argumentos
	}
	
	//Consttructor de tiempo2: se suministra hora,minuto,segundo con valor de 0
	public HoraEnSegundos (int h)
	{
		this (h,0,0); //  invoca al constructor de tiempo2 con 3 argumentos
	}
	
	//Consttructor de tiempo2: se suministra hora y minuto,segundo con valor de 0
	public HoraEnSegundos (int h,int m)
	{
		this (h,m,0); //  invoca al constructor de tiempo2 con 3 argumentos
	}
	
	//Consttructor de tiempo2: se suministra hora,minuto y segundo
	public HoraEnSegundos (int h,int m,int s)
	{
		establecerTiempo(h,m,s); // se llama establecerTiempo para validar tiempo 
	}
	
	public HoraEnSegundos (HoraEnSegundos tiempo)
	{
		//invoca al constructor de Tiempo2 con 3 args
		this(tiempo.obtenerHora(),tiempo.obtenerMinuto(),tiempo.obtenerSegundo());
	}
	
	// Metodos "establecer"
	// establece un nuevo valor de tiempo usando la hora universal
	// valida los datos
	public void establecerTiempo (int h,int m,int s)
	{
		establecerHora(h);
		establecerMinuto (m);
		establecerSegundo (s);
	}
	
	// valida y establece la hora
	public void establecerHora(int h)
	{
		if (h>=0 && h<24)
			hora=h;
		
		else
			throw new IllegalArgumentException("hora debe ser de 0 a 23");
	}
	
	// valida y establece minuto
		public void establecerMinuto(int m)
		{
			if (m>=0 && m<60)
				minuto=m;
			
			else
				throw new IllegalArgumentException("minuto debe ser de 0 a 59");
		}
		
		// valida y establece segundo
		public void establecerSegundo(int s)
		{
			if (s>=0 && s<60)
				segundo=((s>=0 && s<60) ? s : 0);
					
			else
				throw new IllegalArgumentException("segundo debe ser de 0 a 59");
		}
		
		public int obtenerHora ()
		{
			return hora;
		}
		
		public int obtenerMinuto ()
		{
			return minuto;
		}
		
		public int obtenerSegundo ()
		{
			return segundo;
		}
		
		public String aStringUniversal ()
		{
			return String.format("%02d:%02d:%02d",obtenerHora(),obtenerMinuto(),obtenerSegundo());
		}
		
		public String toString ()
		{
			return String.format("%d:%02d:%02d %s",(obtenerHora() == 0 || obtenerHora() == 12) ? 
					12 : obtenerHora() % 12,obtenerMinuto(),obtenerSegundo(),
					(obtenerHora() < 12 ? "AM" : "PM"));
		}
}
