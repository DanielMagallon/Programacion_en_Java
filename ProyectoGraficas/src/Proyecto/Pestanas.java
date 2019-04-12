package Proyecto;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Libreria.Grafica;

import static Proyecto.FileSerGetter.*;

public final class Pestanas extends JTabbedPane implements ChangeListener
{
	private static final long serialVersionUID = -6823696441108036253L;

	private int cont = 0, acu = 0;

	private Categorias cat;
	private AreaDibujo area;
	private Appi ap; 
	private ArrayList<Boolean> habilit;

	private int dimension;

	
	
	public Pestanas(Categorias c, Appi api)
	{
		ap = api;
		addChangeListener(this);
		dimension = 1500;
		habilit = new ArrayList<Boolean>();
		cat = c;
		this.setTabPlacement(TOP);
	}

	public void crear()
	{

		JScrollPane sc = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		area = new AreaDibujo();
		area.setBounds(0, 0, dimension, dimension);
		area.setPreferredSize(new Dimension(dimension, dimension));

		area.setBackground(PanelFondos.colorFondo);
		area.espaciado(Appi.comboEspacios.getSelectedIndex());
		sc.setViewportView(area);

		addTab(String.format("*Grafica (%d)", acu),Appi.getImageIcon("analytics.png"), sc);

		acu++;
		setSelectedIndex(cont++);
	}

	public void openWithFile(String ruta)
	{
		File file = new File(ruta);
		String formato = file.getPath();
		
		if(formato.endsWith(".list"))
		{
			openFileList(file);
		}
		else if(formato.endsWith(".table"))
		{
			openTableFile(file);
		}
		else if(formato.endsWith(".jpg")|| formato.endsWith(".jpeg") || formato.endsWith(".png"))
		{
			File rutaSearch = new File(
					PathGeneral.rutaRecursos.getPath()+"/Wallpaper/"+file.getName());

			if(!rutaSearch.exists())
			{
				int opc = JOptionPane.showConfirmDialog(null, 
						"La imagen a pegar no existe en la carpeta"+PathGeneral.rutaRecursos.getPath
						()+"/Wallpaper/\n"
						+ "Desea guardarlo? De ser asi, la imagen podra ser escogida "
						+ "facilmente como fondo","?",JOptionPane.YES_NO_OPTION);
				
				if(opc == JOptionPane.YES_OPTION)
				{
					FileWorker.elimated=false;
					try
					{
						FileWorker.copyFile(file, 
								new File(PathGeneral.rutaRecursos.getPath()+"/Wallpaper/"+file.getName()));
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
			else JOptionPane.showMessageDialog(null, "La imagen ya existe en la carpeta");

			crear();
			area.fondo(new ImageIcon(formato).getImage());
		}
		else
		{
			if(!openFileList(file))
				openTableFile(file);
		}
	}

	private boolean openFileList(File file)
	{
		String text = FileSerGetter.getFormatText(file,false);
		
		if(text!=null)
		{
			crear();
			determinarDatosLista(text);
			area.setTypeGraph(ap.toggleBarras.isSelected() ? Grafica.BARRAS : Grafica.PASTEL);
			area.gr.setDatos(categoriasNum, nombreCat);
			
			return true;
		}
		
		return false;
		
		
	}
	
	private boolean openTableFile(File  file)
	{
		Object datos[][] = FileSerGetter.getFormatTable(file,false);
		
		if(datos!=null)
		{
			crear();
			area.setTypeGraph(ap.toggleBarras.isSelected() ? Grafica.BARRAS : Grafica.PASTEL);
			
			if(determinarDatosTable(datos))
				area.gr.setPorcentajes(porcentajes, nombreCat, PanelFondos.tamanio);
			
			else area.gr.setDatos(categoriasNum, nombreCat);
			
			
			return true;
		}
		
		return false;
	}

	public void cerrar()
	{
		if (this.getComponentCount() != 0)
		{
			habilit.remove(this.getSelectedIndex());
			this.remove(this.getSelectedIndex());
			cont--;
		}
	}

	public void habilitar(boolean b)
	{
		if (this.getSelectedIndex() != -1)
			habilit.set(this.getSelectedIndex(), b);
	}

	public void cambiarTitulo(String cad)
	{
		this.setTitleAt(getSelectedIndex(), cad);
	}

	public boolean estaVacia()
	{
		return this.getComponentCount() == 0;
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
			area = (AreaDibujo) (((JScrollPane) this.getSelectedComponent()).getViewport().getView());
			PanelFondos.btnCamColor.setBackground(area.getBackground());
			Appi.comboEspacios.setSelectedItem(area.gr.getEspaciado());
			
			if (habilit.size() == this.getComponentCount() - 1)
			{
				habilit.add(true);
			} else
				cat.cboxCrearTabla.setSelected(habilit.get(this.getSelectedIndex()));

			if (area.gr.getCategorias() != null)
			{
				if(area.gr.byPorcentaes)
					cat.updatePorc(porcentajes, nombreCat);
				
				else cat.update(area.gr.getFrecuenciasCat(), area.gr.getCategorias());
			}

			else
				cat.reset();

		} catch (NullPointerException e)
		{
			
		}
	}
	
}
