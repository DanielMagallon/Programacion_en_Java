package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class Programador extends Informaticos
{
	// Utilizando Polimorfismo Overload
	public void sueldo(int horas,double pagoH)
	{
		JOptionPane.showMessageDialog(null,"El pago es: " + (horas*pagoH));
	}
	

	public void datos(String nombre,String ape)
	{
		JOptionPane.showMessageDialog(null,"Nombre: " + nombre + 
				"\nApellidos: " + ape);
	}
	
	public void labores(String lab)
	{
		JOptionPane.showMessageDialog(null,"Soy programador y me dedico a " + lab);
	}
}
