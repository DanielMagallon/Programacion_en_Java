package C10Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionesAyuda
{
	public static void main(String[] args)
	{
		int x,y,tamaniArrelgo;
		
		int arreglo [] = {1,4,6,3,2};

		boolean errores=false;
		
		try
		{
			x = Integer.parseInt(JOptionPane.showInputDialog
					(null,"Ingresa un numero entero",
						  "Solicitando Datos",3));
			
			y = Integer.parseInt(JOptionPane.showInputDialog
					(null,"Ingresa un numero entero",
						  "Solicitando Datos",3));
			
			tamaniArrelgo = Integer.parseInt(
					JOptionPane.showInputDialog("Dado el siguiente arreglo: arreglo [] = {1,4,6,3,2}"
							+ "\nIntroduzca su tamaño: "
							)
					);
			
			JOptionPane.showMessageDialog(null, String.format("La division de %d / %d = %d",x,y,(x/y)),
					"Mostrando resultado",3);
			
			for (int i=0; i<=tamaniArrelgo; i++)
			{
				JOptionPane.showMessageDialog(null, String.format("Arreglo[%d] = %d\n",i,arreglo[i]));
			}
		}
		catch (NumberFormatException n)
		{
			errores=true;
			JOptionPane.showMessageDialog(null,String.format("Excepcion: %s\n%s\n"
					+ "Debe introducir valores numericos","NumberFormatException",n.getMessage()),"ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		
		catch (ArithmeticException a)
		{
			errores=true;
			JOptionPane.showMessageDialog(null,String.format("Excepcion: %s\n%s\n"
					+ "No se puede dividir entre 0","ArithmeticException",a.getMessage()),"ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		
		catch (ArrayIndexOutOfBoundsException ar)
		{
			errores=true;
			JOptionPane.showMessageDialog(null,String.format("Excepcion: %s\nTamaño que se introdujo: %s\n"
					+ "El tamaño especificado es incorrecto al tamanio del arreglo dado","ArrayIndexOutOfBoundsException",ar.getMessage()),"ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			if (errores==false)
			{
				JOptionPane.showMessageDialog(null, "Todo concluyo correctamente");
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Algo salio mal durante la ejecucion del programa");
			}
		}
	}
}
