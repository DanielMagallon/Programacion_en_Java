package C10Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionesThrow
{
	public static void main(String[] args)
	{
		int x,y;
		
		try
		{
			x = Integer.parseInt(JOptionPane.showInputDialog
					(null,"Ingresa un numero entero",
						  "Solicitando Datos",3));
			
			y = Integer.parseInt(JOptionPane.showInputDialog
					(null,"Ingresa un numero entero",
						  "Solicitando Datos",3));
			
			// Manejando Excepciones medinate throw 
			
			if (y==0){
				// crando a new Excepcion
				throw new ArithmeticException("ERROR EN EL DENOMINADOR = " + y);
			}
			else
			{
				JOptionPane.showMessageDialog(null, String.format("La division de %d / %d = %d",x,y,(x/y)),
						"Mostrando resultado",3);
			}
		} 
		catch (ArithmeticException ae)
		{
			JOptionPane.showMessageDialog(null,String.format("Excepcion: %s\n%s\n"
					+ "No se puede dividir entre 0","ArithmeticException",ae.getMessage()),"ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
