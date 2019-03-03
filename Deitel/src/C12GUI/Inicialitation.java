package C12GUI;

import javax.swing.JFrame;

public class Inicialitation
{

	public Inicialitation(JFrame obj,int width, int height, 
			int defaultCloseOperation)
	{
		
		obj.setSize(width,height);
		obj.setDefaultCloseOperation(defaultCloseOperation);
		obj.setVisible(true);
	}
}
