package Proyecto;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Pestanas extends JTabbedPane implements ChangeListener
{
	private static final long serialVersionUID = -6823696441108036253L;

	private int cont=0,acu=0;

	private Categorias cat;
	private AreaDibujo area;
	
	private ArrayList<Boolean> habilit;
	
	private int dimension;
	
	public Pestanas(Categorias c)
	{
//		setUI(new TabbedPanePersnalizable());
		addChangeListener(this);
		dimension = 1500;
		habilit = new ArrayList<Boolean>();
		cat = c;
	}
	
	public void crear()
	{
		
		JScrollPane sc = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		 area = new AreaDibujo();
		area.setBounds(0, 0,dimension,dimension); 
		area.setPreferredSize(new Dimension(dimension,dimension));
		
		area.setBackground(PanelFondos.colorFondo);
		area.espaciado(Appi.comboEspacios.getSelectedIndex());
		sc.setViewportView(area);
		
		addTab(String.format("*Grafica (%d)", acu), sc);
		
		acu++;
		setSelectedIndex(cont++);
	}
	
	public void crearConArchivo(String path,String file)
	{
		crear();
		loadTableFile(path, file);
	}
	
	public void loadTableFile(String path,String file)
	{
		File files = new File(path+"/"+file);
		try
		{
			Object[][] datos = (Object[][]) Serializa.writeObject(files);
			
			int cantxCat[],n;
			String cats[];
			
			n = datos.length;
			
			cantxCat = new int[n];
			cats = new String[n];
			
			for(int i=0; i<n; i++)
			{
				cats[i] = datos[i][0].toString();
				cantxCat[i] = Integer.parseInt(datos[i][1].toString());
			}

			area.gr.setDatos(cantxCat, cats);
			
			
		} catch (ClassNotFoundException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cerrar()
	{
		if(this.getComponentCount()!=0)
		{
			habilit.remove(this.getSelectedIndex());
			this.remove(this.getSelectedIndex());
			cont--;
		}
	}
	
	public void habilitar(boolean b)
	{
		if(this.getSelectedIndex()!=-1)
		habilit.set(this.getSelectedIndex(), b);
	}
	
	public void cambiarTitulo(String cad)
	{
		this.setTitleAt(getSelectedIndex(), cad);
	}
	
	public boolean estaVacia()
	{
		return this.getComponentCount()==0;
	}
	
	public AreaDibujo getAreaDibujo()
	{
		return area;
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		try
		{
			 area = 
					(AreaDibujo)(((JScrollPane)this.getSelectedComponent()).getViewport().getView());
			
			 PanelFondos.lblColor.setBackground(area.getBackground()); 
			 Appi.comboEspacios.setSelectedItem(area.gr.getEspaciado());
			 
			 if(habilit.size()==this.getComponentCount()-1)
				{
					habilit.add(true);
				}
				else cat.cbox.setSelected(habilit.get(this.getSelectedIndex())); 
			 
			if(area.gr.getCategorias()!=null)
				cat.update(area.gr.getFrecuenciasCat(),area.gr.getCategorias());
			
			else cat.reset();
		
			
		}
		catch(NullPointerException e) {}
	}
}
