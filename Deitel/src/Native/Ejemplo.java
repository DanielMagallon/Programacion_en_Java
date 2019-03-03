package Native;

public class Ejemplo
{
	native double f(int i, String s);
	
	public static void main (String args[]) 
	{
		 // Cargar la DLL que implementa la clase

        System.loadLibrary("pkg_nat");
	}
}
