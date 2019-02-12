package TiposDatosAbstractos;

public class Punto 
{
	/*
	 * Un tipo de dato abstracto es aquel que es definido por el usuario:
	 * Punto <-- Es un tipo de dato abstracto
	 * Punto x; <-- En este caso x, es una variable de tipo Puntos
	 * .- La clase punto tiene atributo abstractos, que a la vez pueden contener atributos primitivos:
	 * String,int...
	 */
	
	/**
	 * Los tipos de datos abstarctos se define por lo genral mediante
	 * Interfaz Publica: Lo que se le muestra al usuario, el como funciona tal programa
	 * Implemnetacion: Es todo el codigo donde se desarrolo el programa 
	 */
	
	/**
	 * Especificacion de TAD:
	 * 1.- Descripcion matematica del conjunto de datos
	 * 2.- La descrpicion de las operaciones definidas en cietros elemntos de ese conjunto de dstos
	 */
	
	/*
	 * Usos de los TDA:
	 * Grafos
	 * Arboles binarios
	 * Pilas
	 * Colas
	 * Listas enlazadas
	 * Conjuntos
	 */
	
	private int x,y,z;
	String dimension;
	
	public Punto(int coorX,int coorY)
	{
		x=coorX;
		y=coorY;
	}
	
	public Punto(int coorX,int coorY,int coorZ)
	{
		x=coorX;
		y=coorY;
		z=coorZ;
	}
	
	void setX(int x)
	{
		this.x=x;
	}
	
	void setY(int y)
	{
		this.y=y;
	}
	
	void setZ(int z)
	{
		this.z=z;
	}
	
	void dimension(String d)
	{
		dimension=d;
	}
	
	int getX()
	{
		return x;
	}
	
	int getY()
	{
		return y;
	}
	
	int getZ()
	{
		return z;
	}
	
	String getDimen()
	{
		return dimension;
	}
	
	public static void main(String[] args) 
	{
		
	}
}
