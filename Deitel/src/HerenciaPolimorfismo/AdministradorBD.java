package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class AdministradorBD extends Informaticos
{
		// Utilizando Polimorfismo Overload
		public void sueldo(double pagoH)
		{
			JOptionPane.showMessageDialog(null,"El pago es: " + pagoH);
		}
		

		public void datos(String nombre)
		{
			JOptionPane.showMessageDialog(null,"Nombre: " + nombre);
		}
		
		public void labores(String lab)
		{
			JOptionPane.showMessageDialog(null,"Soy programador y me dedico a " + lab);
		}
}
