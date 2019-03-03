package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class AnaliztaOverride extends InformaticosOverride
{
	@Override
	public void sueldo(double pago)
	{
		JOptionPane.showMessageDialog(null, "El pago del analizta es de: $"+pago);
	}
	
	@Override
	public void datos(String name)
	{
		JOptionPane.showMessageDialog(null, "Nombre del analizta: " + name);
	}
	
	@Override
	public void labores(String labores)
	{
		JOptionPane.showMessageDialog(null, "Labor del analizta: " + labores);
	}
}
