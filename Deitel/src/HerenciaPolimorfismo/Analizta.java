package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class Analizta extends Informaticos
{
		// Utilizando Polimorfismo Overload
		public void sueldo(int horas,double pagoH,double incen)
		{
			JOptionPane.showMessageDialog(null,"El pago es: " + (horas*pagoH) + incen);
		}
		

		public void datos(String nombre,String ape,String direccion)
		{
			JOptionPane.showMessageDialog(null,"Nombre: " + nombre + 
					"\nApellidos: " + ape + "\nDireccion: " + direccion);
		}
		
		public void labores(String lab,int horas)
		{
			JOptionPane.showMessageDialog(null,"Soy programador y me dedico a " 
										  + lab + " " + horas + " horas");
		}
}
