package C7ClasesObjetos;

// Declara un tipo enum con construtor y campos de instancia explicitos , junto 
// con metodos de acceso para stos campos 

public enum LibroEnum
{
	// declara constantes de tipo enum
	JHTP ("Java How to Program","2012"),
	CHTP ("C How to Program","2007"),
	IW3HTP ("Internet & Wold Wide Web How to Program","2008"),
	CPPHTP ("C++ How to Program","2012"),
	VBHTP ("Visual Basic 2010 How to Program","2011"),
	CSHARPHTP ("Visual C# How to Program","2011");
	
	// campos de instancia 
	private final String titulo; // titulo del libro
	private final String anioCopyrihgt; // anio copyrayhgt
	
	// Construcot enum
	LibroEnum(String tituloLibro,String anio)
	{
		titulo=tituloLibro;
		anioCopyrihgt=anio;
	}
	
	// metodo de acceso para el campo titulo
	public String obtenerTitulo ()
	{
		return titulo;
	}
	
	// metodo de acceso para el anio
	public String obtenerAnio()
	{
		return anioCopyrihgt;
	}
	
	
}
