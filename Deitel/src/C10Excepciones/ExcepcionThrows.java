package C10Excepciones;

import javax.swing.JOptionPane;

public class ExcepcionThrows
{
	static int x;
	static int y;
	
	public static void main(String[] args)
	{
		try
		{
			sumar();
			dividir(x, y);
		} 
		catch (NumberFormatException ar)
		{
			JOptionPane.showMessageDialog(null,String.format("Excepcion: %s\n%s\n"
					+ "Debe introducir valores numericos","NumberFormatException",ar.getMessage()),"ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		catch (ArithmeticException ae)
		{
			JOptionPane.showMessageDialog(null,String.format("Excepcion: %s\n%s\n"
					,"ArithmeticException",ae.getMessage()),"ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static void sumar() throws NumberFormatException
	{
		
		x = Integer.parseInt(JOptionPane.showInputDialog(
				null,"Ingresa x:","Solicitando Datos",3));
		y = Integer.parseInt(JOptionPane.showInputDialog(
				null,"Ingresa y:","Solicitando Datos",3));
		
		JOptionPane.showMessageDialog(null, String.format("Suma: %d / %d = %d",x,y,(x+y)),
				"Mostrando resultado",3);
	}
	
	static void dividir (int x,int y) throws ArithmeticException
	{
		if (y==0){
			throw new ArithmeticException("Error, no se puede dividir entre cero");
		}
		
		else
		{
		
		JOptionPane.showMessageDialog(null, String.format("Division: %d / %d = %d",x,y,(x/y)),
				"Mostrando resultado",3);
		}
	}
	
	
}
