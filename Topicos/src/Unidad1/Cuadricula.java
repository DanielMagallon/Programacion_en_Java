package Unidad1;

import java.applet.Applet;
import java.awt.Button;
import java.awt.GridLayout;

public class Cuadricula extends Applet
{

////
	Button b[] = new Button[64];
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setLayout(new GridLayout(8, 8));
		for(int i=0; i<b.length; i++)
		{
			add(b[i] = new Button((i+1)+""));
		}
		
		
	}

}
