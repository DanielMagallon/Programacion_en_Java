package Simulacion;

import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

public class MyRaddioButton extends JRadioButton
{
	private final int id, id_rest;
	public AbstractCalculo calc;
	public String[] buttons;
	public DefaultTableModel mod;
	
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
