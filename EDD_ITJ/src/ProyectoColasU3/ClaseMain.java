package ProyectoColasU3;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

/**
 * 
 * @author Edgar Daniel Magallon Villanueva / 17420571 - 3°B
 *
 */

public class ClaseMain
{
	//Se pueden agregar los nombre y prioridades desde esta matriz
	//Prioridades:
	// 1 para embarazada
	// 2 para dispacitado 
	//>=3 || <=0 para persona normal
	
	public static Object valores[][] = 
		{
				{"Luis",-3},
				{"Edgar",2},
				{"Juan",2},
				{"Jesus",4},
				{"Lucero",1},
				{"Oton",3},
				{"Daniela",1},
				{"Matt",2},
				{"James",3},
				{"Jorge",3},
				{"Huani",1},
				{"Pepe",2}
		};
	
	public static void mostrarPorConsola(int milisegundos)
	{
		
		//Define el tamaño de la matriz static de tipo Object  'valores'  
		ColaEstudiantes cola = new ColaEstudiantes(valores.length);
		
		//Agrega el nombre del alumno y su defecto acorde a los valores de la matriz		
		for(int i=0; i<valores.length; i++)
		{
			cola.addAlumn(valores[i][0].toString(), (int)valores[i][1]);
			
			try
			{
				Thread.sleep(milisegundos);
			}
			catch(InterruptedException e)
			{
				System.out.println("Hilo interrrumpido");
			}
			
			System.out.println(cola);
			System.out.println("-----------------------------------------------------------\n");
		}
	}
	
	
	public static void mostrarPorFrame()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Registro frame = new Registro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args)
	{
		int opc=0;
		boolean seg=false;
		
		do
		{
			try
			{
				opc = Integer.parseInt(JOptionPane.showInputDialog(null, 
						"1) Mostrar por Consola\n2) Mostrar por Ventana\nEscoga una opcion", 
						"TIPO DE EJECUCION", JOptionPane.QUESTION_MESSAGE));
				seg = false;
			}
			catch(NumberFormatException e)
			{
				seg = true;
				JOptionPane.showMessageDialog(null, "Solo datos numericos","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		while(seg);
		
		if(opc == 1)
			//2000 milisegundos, cada 2 segundos estara mostrando cada nuevo registro que haya
			mostrarPorConsola(2000);
		
		//Muestra animacion de colas
		else
			mostrarPorFrame();
	}
}
