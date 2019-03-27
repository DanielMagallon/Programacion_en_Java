package Simulacion;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class MyRaddioButton extends JRadioButtonMenuItem
{
	private static final long serialVersionUID = 2370530101138772341L;
	
	private final int id;
	public AbstractCalculo calc;
	public String[] buttons;
	boolean vals[];
	public DefaultTableModel mod;
	
	public MyRaddioButton(String txt,int v, int rest,AbstractCalculo r, boolean valores[],String...b) 
	{
		super(txt);
		buttons = b;
		vals = valores;
		calc = r;
		id = v;
	}
	
	public void atajo(int letra, int act)
	{
		setAccelerator(KeyStroke.getKeyStroke(letra,act));
	}
	
	public int getID()
	{
		return id;
	}
	
}
