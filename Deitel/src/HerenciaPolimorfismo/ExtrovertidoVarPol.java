package HerenciaPolimorfismo;

import javax.swing.JOptionPane;

public class ExtrovertidoVarPol extends PersonaladidadVarPol
{
	@Override
	public void hablar()
	{
		JOptionPane.showMessageDialog(null, "Hola¡ que gusto verte\nYa te extrañaba, me ha ido muy bien..."
				 ,"Que extrovertista soy¡",1);
	}

}
