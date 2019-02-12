package Ayuda;

public class Horario
{
	static Materia mater[] = new Materia[10];
	
	public static void crearMaterias()
	{
		mater[0] = new Materia("Graficacion", new boolean[]{true,false,false,false,true}, 
											  new String[]{"1-3","","","","10-12"},"A");
		
	}
	
	public static void main(String[] args)
	{
		
	}
}
