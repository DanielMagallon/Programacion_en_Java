package Unidad1P2;

import java.io.Serializable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaSer extends JTable implements Serializable 
{
	
	private static final long serialVersionUID = 4574811437561562436L;
	DefaultTableModel moddelo = new DefaultTableModel();
	
	
	public TablaSer() 
	{
		setModel(moddelo);
		
		moddelo.addColumn("Cliente");
		moddelo.addColumn("Comida");
		moddelo.addColumn("Bebida");
		moddelo.addColumn("Total a pagar");
		
		

	}
	
	public void agregar(String nombre, String com,String beb,double tot)
	{
		moddelo.addRow(new Object[] {nombre,com,beb,tot});
	}
}
