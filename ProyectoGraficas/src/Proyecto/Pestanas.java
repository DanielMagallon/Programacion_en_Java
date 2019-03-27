package Proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class Pestanas extends JTabbedPane
{
	private static final long serialVersionUID = -6823696441108036253L;

	int cont=0;
	
	
	public Pestanas()
	{
//		setUI(new TabbedPanePersonalizable());
	}
	
	public void crear()
	{
		
		JScrollPane sc = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		AreaDibujo areaDibujo = new AreaDibujo();
		areaDibujo.setBounds(0, 0, 1000, 1000); 
		areaDibujo.setPreferredSize(new Dimension(1000, 1000));
		
		sc.setViewportView(areaDibujo);
		
		addTab(String.format("*Grafica (%d)", cont), sc);
		setSelectedIndex(cont++);
	}
	
	public void cerrar()
	{
		if(this.getComponentCount()!=0)
		{
			this.remove(this.getSelectedIndex());
			cont--;
		}
	}
	
	public void cambiarTitulo(String cad)
	{
		this.setTitleAt(getSelectedIndex(), cad);
	}
	
	public boolean estaVacia()
	{
		return this.getComponentCount()==0;
	}
	
	public AreaDibujo getAreaDibujo() throws NullPointerException
	{
		if(this.getComponentCount()!=0)
		{
			AreaDibujo ar = 
					(AreaDibujo)(((JScrollPane)this.getSelectedComponent()).getViewport().getView());
			
			return ar;
		}		
		else throw new NullPointerException("No se ha creado alguna grafica");
	}
}
