package SalidaConFormato;

import java.util.Formatter;

import javax.swing.JOptionPane;

public class PruebaFormatter
{
	public static void main(String[] args)
	{
		Formatter formater = new Formatter();
		formater.format("%d = %#o = %#X",10,10,10);
		
		JOptionPane.showMessageDialog(null,formater.toString());
	}
}
