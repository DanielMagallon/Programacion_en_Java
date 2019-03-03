package SimpleTron;

import java.util.Scanner;

public class Simulador
{
	Scanner lc = new Scanner(System.in);
	int operacion, num;
	int memoria[] = new int[100];
	
	final int LEE = 10;
	final int ESCRIBE = 11;
	
	final int CARGA = 20;
	final int ALMACENA = 21;
	
	final int SUMA = 30;
	final int RESTA = 31;
	final int DIVIDE = 32;
	final int MULTIPLICA = 33;
	
	final int BIFURCA = 40;
	final int BIFURCANEG = 41;
	final int BIFURCACERO = 42;
	final int ALTO = 43;
	private int begin=0;
	private final int CENTINELA=-9999;
	
	public void insert()
	{
		
		System.out.println("*** Bienvenido a Simpletron! ***\n"+
						   "*** Por favor, introduzca en su programa una instruccion ***\n"+
						   "*** (o palabra de datos a la vez). Yo le mostrare   ***\n"+
						   "*** el numero de ubicacion y un signo de (?)  ***\n"+
						   "*** Entonces usted escribira la palabara para esa ubicacion ***\n"+
						   "*** Tecle -9999 para dejar de introducir su programa\n\n");
		
		try
		{
		
			do
			{
					System.out.printf ("%s ?  ",(begin <=9) ? "0"+begin : begin);
					operacion=lc.nextInt();
			
				getCodigo(operacion);
			
				begin++;
			}
			while(operacion!=CENTINELA);
		}
		
		catch (NumberFormatException e)
		{
			
		}
	}
	
	private void getCodigo(int codigo)
	{
		int codigoOp = codigo/100;
		ubicacion = codigo % 100;
		getOperacion(codigoOp);
	}
	
	int ubicacion, resultado, valor;
	String df;
	
	private void getOperacion(int cod)
	{
		switch (cod)
		{
			case LEE:
			System.out.println("\nIntroduzca un valor: ");
			num=lc.nextInt();
			memoria[ubicacion]=num;
			break;
				
			case ESCRIBE:
			System.out.println(memoria[ubicacion]);
			break;
			
			case CARGA:
			valor=memoria[ubicacion];
			break;
			
			case ALMACENA:
				memoria[ubicacion]=resultado;
				
			case SUMA:
				resultado=valor+memoria[ubicacion];
				break;
			
			case RESTA:
				resultado=valor-memoria[ubicacion];
				break;
			
			case DIVIDE:
				resultado=valor / memoria[ubicacion];
				break;
				
			case MULTIPLICA:
				resultado=valor*memoria[ubicacion];
				break;
			
			case ALTO:
				System.out.println("\n*** Se completo la carga del programa ***\n"+
								   "*** Empieza la ejecucion del programa ***\n");
				//execute();
				break;
					
			default:
		}
	}
	
	public static boolean noError()
	{
		boolean error=false;
		
		//error=true;
		
		return !error;
	}

	public static void main(String[] args)
	{
	        new Simulador().insert();
	}
}
