package Recursividad;

public class TorreHanoi 
{
	public static void main(String[] args) 
	{
		torresHanoi(7, 1, 3, 2);
		System.out.println("Juego Completado");
	}

	static void torresHanoi(int discos,int torre1,int torre2,int torre3)
	{
		if (discos==1)
		{
			System.out.printf ("Mover Disco de Torre %d a Torre %d\n",torre1,torre3);
		}
		
		else
		{
			torresHanoi(discos-1,torre1,torre3,torre2);
			System.out.printf ("Mover Disco de Torre %d a Torre %d\n",torre1,torre3);
			torresHanoi(discos-1, torre2, torre1, torre3);
		}
	}
}
