package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class IntrovertidoVarPol extends PersonaladidadVarPol
{
	@Override
	public void hablar()
	{
		JOptionPane.showMessageDialog(null, "Hola"
				 ,"Soy introvertido¡",1);
	}
}
