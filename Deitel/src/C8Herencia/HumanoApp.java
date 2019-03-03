package C8Herencia;

public class HumanoApp
{
	public static void main(String[] args)
	{
		Humano a=new Humano("Emilio","Rosso");
		Ciudadano b=new Ciudadano("Emilio","Rosso","3052454545");
		
		Humano[] arregloHuamnos=new Humano[2];
		arregloHuamnos[0]=a;
		arregloHuamnos[1]=b;
		identificadorPoliformico(arregloHuamnos);
	}
	
	public static void identificadorPoliformico (Humano [] arrelgoHumano)
	{
		for (int i=0; i<arrelgoHumano.length; i++)
		{
			System.out.println("Identificando: " + arrelgoHumano[i].identificacion());
		}
	}
}
