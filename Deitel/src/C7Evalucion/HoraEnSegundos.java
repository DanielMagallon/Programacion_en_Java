package C7Evalucion;

public class HoraEnSegundos
{
	private int hora;
	private int minuto;
	private int segundo;
	private int totalSegundos=0;
	
	public HoraEnSegundos ()
	{
		this (0,0,0);
	}
	
	public HoraEnSegundos (int h)
	{
		this (h,0,0);
	}
	
	public HoraEnSegundos (int h,int m)
	{
		this (h,m,0);
	}
	
	public HoraEnSegundos (int h,int m,int s)
	{
		establecerTiempo (h,m,s);
	}
	
	public HoraEnSegundos (HoraEnSegundos tiempo)
	{
		this(tiempo.obtenerHora(),tiempo.obtenerMinuto(),tiempo.obtenerSegundo());
	}
	
	public void establecerTiempo (int h,int m,int s)
	{
		establecerHora(h);
		establecerMinuto (m);
		establecerSegundo (s);
	}
	
	public void establecerHora (int h)
	{
		if (h>=0 && h<24)
		{
			hora=h;
			totalSegundos += (3600*hora);
		}
		
		else
			throw new IllegalArgumentException("hora debe ser de 0 a 23");
	}
	
	public void establecerMinuto(int m)
	{
		if (m>=0 && m<60)
		{
			minuto=m;
			totalSegundos += (60*minuto);
		}
		
		else
			throw new IllegalArgumentException("minuto debe ser de 0 a 59");
	}
	
	public void establecerSegundo(int s)
	{
		if (s>=0 && s<60)
		{
			segundo=((s>=0 && s<60) ? s : 0);
			totalSegundos += segundo;
		}
				
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
	
	public void mostrarSegundosTranscurridos ()
	{
		System.out.printf ("Total segundos: %d\n",totalSegundos);
	}
}
