package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class ProgramadorOverride extends InformaticosOverride
{
	@Override
	public void sueldo(double pago)
	{
		JOptionPane.showMessageDialog(null, "El pago del programador es de: $"+pago);
	}
	
	@Override
	public void datos(String name)
	{
		JOptionPane.showMessageDialog(null, "Nombre del programdor: " + name);
	}
	
	@Override
	public void labores(String labores)
	{
		JOptionPane.showMessageDialog(null, "Labor del programador: " + labores);
	}
}
