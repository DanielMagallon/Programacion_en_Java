package HelpClass;


//Clase que contiene los tipos de madera que usa la empresa , su color y su peso especifico
public enum TipoDeMadera
{
	
	ROBLE ("Castaño verdoso",800), //  Separamos con comas
	CAOBA ("Marron oscuro",770),
	NOGAL ("Marron rojizo",820),
	CEREZO ("Marron cereza",790),
	BOJ  ("Marron negruzco",675);
	
	// Campos tipo constante
	
	private final String color; // color de la madera
	private final int pesoEspecifico; // peso de la amdera
	
	
	/**

     * Constructor. Al asignarle uno de los valores posibles a una variable del tipo enumerado el constructor asigna 

        automáticamente valores de los campos

     */ 
	
	TipoDeMadera (String color, int pesoEspecifico)
	{
		this.color = color;
		this.pesoEspecifico = pesoEspecifico;
	}
	
	// Metodos de la clase tipo enum
	
	public String getColor () {return color;}
	public int getPesoEspecifico () {return pesoEspecifico;}
	
}
