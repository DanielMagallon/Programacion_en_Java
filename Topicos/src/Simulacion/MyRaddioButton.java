package Simulacion;

import javax.swing.JRadioButton;

public class MyRaddioButton extends JRadioButton
{
	private final int id, id_rest;
	public AbstractCalculo calc;
	public String[] buttons;
	
	public MyRaddioButton(String txt,int v, int rest,AbstractCalculo r, String...b) 
	{
		super(txt);
		buttons = b;
		calc = r;
		id = v;
		id_rest = rest;
	}
	
	public int getID()
	{
		return id;
	}
	
	public int getIDRestriction()
	{
		return id_rest;
	}
}
