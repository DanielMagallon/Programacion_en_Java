package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class PesimistaVarPol extends PersonaladidadVarPol
{
	@Override
	public void hablar()
	{
		JOptionPane.showMessageDialog(null, "Seguro que hoy tendre un pesimo dia"
				 ,"Que pesimista soy¡",1);
	}
}
