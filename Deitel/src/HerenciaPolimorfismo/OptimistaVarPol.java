package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class OptimistaVarPol extends PersonaladidadVarPol
{
	@Override
	public void hablar()
	{
		JOptionPane.showMessageDialog(null, "Seguro que hoy tendre un excelente dia"
				 ,"Que optimista soy¡",1);
	}
}
