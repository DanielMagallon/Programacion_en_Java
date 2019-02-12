package Unidad1;

import java.applet.Applet;
import java.awt.Button;

public class Absoluto extends Applet
{

	Button b1,b2;
	
	@Override
	public void init() {
		// TODO Auto-generate;d method stub
		b1 = new Button("B1");
		b2 = new Button("B2");
		setSize(500,500);
		
		setLayout(null);
		b1.setBounds(30, 30, 150, 20);
		add(b1);
		b2.setBounds(250, 30, 150, 20);
		
		add(b2);
	}

}
