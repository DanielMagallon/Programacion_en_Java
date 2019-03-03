package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class AdministradorOverride extends InformaticosOverride
{
	@Override
	public void sueldo(double pago)
	{
		JOptionPane.showMessageDialog(null, "El pago del administrador es de: $"+pago);
	}
	
	@Override
	public void datos(String name)
	{
		JOptionPane.showMessageDialog(null, "Nombre del admin: " + name);
	}
	
	@Override
	public void labores(String labores)
	{
		JOptionPane.showMessageDialog(null, "Labor del admin: " + labores);
	}
}
