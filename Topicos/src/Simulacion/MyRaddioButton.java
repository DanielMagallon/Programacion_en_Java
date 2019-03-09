package Simulacion;

import javax.swing.JRadioButton;

public class MyRaddioButton extends JRadioButton
{
	private final int id;
	public AbstractCalculo calc;
	public String[] buttons;
	
	public MyRaddioButton(String txt,int v, AbstractCalculo r, String...b) 
	{
		super(txt);
		buttons = b;
		calc = r;
		id = v;
	}
	
	public int getID()
	{
		return id;
	}
	
}
