package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class Categorias extends JDialog implements ChangeListener, ActionListener
{
	private static final long serialVersionUID = -5289217806338113929L;
	private DefaultTableModel modelo;
	private JTable tabla;
	private JTextArea txtArea;
	private JButton añadirCategoria,borrarCategoria,refrescar,btnAplicar,btnCargarTabla,
			btnSaveTabla,btnCargarList,btnSaveList;
	public JCheckBox cbox = new JCheckBox("Crear medinate tabla"),cboxPorce;
	private JPanel panelTabla,porDatos;
	private AreaDibujo areaD;
	private int i;
	private Pestanas pest;
	private JFileChooser chosser;
	private FileNameExtensionFilter ftable,flist;
	
	@SuppressWarnings("serial")
	public Categorias(String path)
	{
		chosser = new JFileChooser(new File(path+"/SerFiles/"));
		ftable = new FileNameExtensionFilter("Archivos formato table", "table");
		flist = new FileNameExtensionFilter("Archivos formato list", "list");
		
		setLayout(new BorderLayout(0,10));
		setSize(700, 600);
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		
		JPanel p = new JPanel();
		
		{
			btnAplicar = new JButton("Aplicar");
			btnAplicar.addActionListener(this);
			p.add(cbox);
			p.add(btnAplicar);
			cboxPorce = new JCheckBox("Graficar por porcentaje");
			p.add(cboxPorce);
			cbox.addChangeListener(this);
			add(p,"North");
		}
		
		JPanel gen = new JPanel();
		{
			gen.setLayout(new GridLayout(2,1,0,10));
			
			 panelTabla = new JPanel();
			setBackground(Color.white);
			panelTabla.setBackground(Color.white);
			TitledBorder titulo = new TitledBorder(BorderFactory.createLineBorder
					(Color.blue, 1, true), "Categorias por tabla");
			
			panelTabla.setBorder(titulo);
			
			{
				panelTabla.setLayout(new BorderLayout());
				modelo = new DefaultTableModel()
				{
					@Override
					public Class<?> getColumnClass(int columnIndex)
					{
						if(columnIndex==1)
							return Integer.class;
						
						else if(columnIndex==2)
							return BigDecimal.class;
						
						return String.class;
					}
				};
				
				modelo.addColumn("Categoria");
				modelo.addColumn("Por numero de datos");
				modelo.addColumn("Por porcentaje");
				
				tabla = new JTable(modelo);

				
				añadirCategoria = new JButton("Añadir categoria");
				añadirCategoria.addActionListener(this);
				
				borrarCategoria = new JButton("Borrar Categoria");
				borrarCategoria.addActionListener(this);
				
				refrescar = new JButton("Refrescar");
				refrescar.addActionListener(this);
				
				btnCargarTabla = new JButton("Cargar tabla");
				btnCargarTabla.addActionListener(this);
				
				btnSaveTabla = new JButton("Guadar tabla");
				btnSaveTabla.addActionListener(this);
				btnSaveTabla.setEnabled(false);
				
				
				JPanel panelBtns = new JPanel();
				{
					panelBtns.setBackground(Color.white);
					panelBtns.add(añadirCategoria);
					panelBtns.add(borrarCategoria);
					panelBtns.add(refrescar);
					panelBtns.add(btnCargarTabla);
					panelBtns.add(btnSaveTabla);
					
					panelTabla.add(panelBtns,"South");
				}
				
				panelTabla.add(new JScrollPane(tabla),"Center");			
				gen.add(panelTabla);
			}
			 
			
			porDatos = new JPanel();
			
			titulo = new TitledBorder(BorderFactory.createLineBorder
					(Color.blue, 1, true), "Categorias por datos");
			
			porDatos.setBorder(titulo);
			porDatos.setLayout(new BorderLayout());
			
			gen.add(porDatos);
			txtArea = new JTextArea();
			txtArea.setWrapStyleWord(true);
			txtArea.setLineWrap(true);
			
			JScrollPane sd = new JScrollPane(txtArea);
			
			porDatos.add(sd);
			
			JPanel panelConfD = new JPanel();
			
			{
				btnCargarList = new JButton("Cargar lista");
				btnSaveList = new JButton("Guardar Lista");
				btnCargarList.addActionListener(this);
				btnSaveList.addActionListener(this);
				
				panelConfD.add(btnCargarList);
				panelConfD.add(btnSaveList);
				
				porDatos.add(panelConfD,"South");
			}
			
			add(gen,"Center");
			
		}
	}
	
	public void setTabbed(Pestanas p)
	{
		pest = p;
		cbox.setSelected(true);
	}
	
	public void setAreaDibujo(AreaDibujo g)
	{
		areaD = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == añadirCategoria)
		{
			modelo.addRow(new Object[] {});
			
			if(!btnSaveTabla.isEnabled())
				btnSaveTabla.setEnabled(true);
		}
		else if(e.getSource() == borrarCategoria)
		{
			int ind = tabla.getSelectedRow();
			
			if(ind!=-1)
			{
				modelo.removeRow(ind);
				
				if(modelo.getRowCount()==0)
				btnSaveTabla.setEnabled(false);
			}
		}
		
		else if(e.getSource() == refrescar)
		{
			modelo.setRowCount(0);
			btnSaveTabla.setEnabled(false);
		}
		
		else if(e.getSource() == btnCargarTabla)
		{
			
			chosser.setFileFilter(ftable);
			
			int sel = chosser.showOpenDialog(this);
			
			if(sel == JFileChooser.APPROVE_OPTION)
			{
				try
				{
					Object[][] datos = (Object[][]) Serializa.writeObject(chosser.getSelectedFile());
					
					modelo.setRowCount(0);
					
					for(Object c[] : datos)
					{
						modelo.addRow(c);
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Archivo corrupto o formato no valido" , 
							"No se pudo abrir el archivo", JOptionPane.ERROR_MESSAGE);

				}
				
			}
		}
		else if(e.getSource() == btnSaveTabla)
		{
			int sel;
			chosser.setFileFilter(ftable);
			sel = chosser.showSaveDialog(this);
			
			if(sel == JFileChooser.APPROVE_OPTION)
			{
				Object[][] datos = new Object[modelo.getRowCount()][modelo.getColumnCount()];
				
				for(int i=0; i<datos.length; i++)
				{
					for(int j=0; j<datos[0].length; j++)
					{
						datos[i][j] = modelo.getValueAt(i, j);
					}
				}
				
				chosser.getSelectedFile().setWritable(false);
				Serializa.saveObject(datos, new File(chosser.getSelectedFile().
						getAbsolutePath()+".table"));
				
			}
		}
		else if(e.getSource() == btnSaveList)
		{
			int sel;
			chosser.setFileFilter(flist);
			
			sel = chosser.showSaveDialog(this);
			
			if(sel == JFileChooser.APPROVE_OPTION)
			{
				String lista = txtArea.getText();
				
				Serializa.saveObject(lista, new File(chosser.getSelectedFile().
						getAbsolutePath()+".list"));
			}
		}
		else if(e.getSource() == btnCargarList)
		{
			chosser.setFileFilter(flist);
			
			int sel = chosser.showOpenDialog(this);
			
			if(sel == JFileChooser.APPROVE_OPTION)
			{
				try
				{
					String txt = (String) Serializa.writeObject(chosser.getSelectedFile());
							
					txtArea.setText(txt);
				}
				catch(Exception ex)
				{
					
					JOptionPane.showMessageDialog(null,"Archivo corrupto o formato no valido" , 
							"No se pudo abrir el archivo", JOptionPane.ERROR_MESSAGE);

				}
			}
			
		}
		
		else
		{
			if(cbox.isSelected())
			{
				if(modelo.getRowCount()!=0)
				{
					if(!cboxPorce.isSelected())
					{
						if(getDataTable())
						{
							this.dispose();
						}
					}
					else
					{
						if(getPorncetajesTable())
						{
							this.dispose();
						}
					}
						
				}else JOptionPane.showMessageDialog(this, "Debe ingresar al menos una categoria",
						"Categoria Vacia", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(!txtArea.getText().trim().isEmpty())
				{
					determinarDatos();
					this.dispose();
				}
				else JOptionPane.showMessageDialog(this, "Debe ingresar al menos una categoria",
					"Categoria Vacia", JOptionPane.ERROR_MESSAGE);

			}
		}
	}
	
	
	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		habilitarTabla(cbox.isSelected());
		pest.habilitar(cbox.isSelected());
	}
	
	public void update(int x[],String y[])
	{
		reset();
		
		if(cbox.isSelected())
		{
			
			for(i=0; i<x.length; i++)
			{
				modelo.addRow(new Object[] {y[i],x[i]});
			}
		}
		else
		{
			for(String d : y)
				txtArea.append(d+"-");
			
		}
	}
	
	public void reset()
	{
		modelo.setRowCount(0);
		txtArea.setText("");
	}
	
	private boolean getDataTable()
	{
		int cantxCat[],n;
		String cats[];
		
		n = tabla.getRowCount();
		
		cantxCat = new int[n];
		cats = new String[n];
				
		try
		{
			for(i=0; i<n; i++)
			{
				cats[i] = modelo.getValueAt(i,0).toString();
				
				if(cats[i].trim().length()==0)
					throw new NullPointerException();
				
				cantxCat[i] = Integer.parseInt(modelo.getValueAt(i,1).toString());
			}
			areaD.gr.setDatos(cantxCat, cats);
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(this, "Los campos de las columnas Categoria y Por numero de datos\n"
					+ "deben ser rellenados totalmente",
					"Error en fila: "+i,
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	private boolean getPorncetajesTable()
	{
		BigDecimal porcen[];
		int n;
		String cats[];
		
		n = tabla.getRowCount();
		
		porcen = new BigDecimal[n];
		cats = new String[n];
				
		try
		{
			for(i=0; i<n; i++)
			{
				cats[i] = modelo.getValueAt(i,0).toString();
				
				if(cats[i].trim().length()==0)
					throw new NullPointerException();
				
				porcen[i] = new BigDecimal(modelo.getValueAt(i,2).toString());
			}
			areaD.gr.setPorcentajes(porcen, cats,350);
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(this, "Los campos de las columnas Categoria y Por porcentajes\n"
					+ "deben ser rellenados totalmente",
					"Error en fila: "+i,
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
		
	
	public void determinarDatos()
	{
		LinkedHashMap<String, Integer> datos = new LinkedHashMap<String, Integer>();
		
		String cat[] = txtArea.getText().split("-");
		
		for(String key: cat)
		{
			if(!key.equals("-"))
			if(datos.containsKey(key))
			{
				datos.replace(key, datos.get(key)+1);
			}
			else datos.put(key, 1);
		}
		
		String x[] = new String[datos.size()];
		int y[] = new int[datos.size()];
		
		i=0;
		
		for(String k : datos.keySet())
		{
			x[i] = k;
			y[i] = datos.get(k);
			i++;
		}
		
		areaD.gr.setDatos(y, x);
	}
	
	private void habilitarTabla(boolean hab)
	{
		añadirCategoria.setEnabled(hab);
		borrarCategoria.setEnabled(hab);
		refrescar.setEnabled(hab);
		btnCargarTabla.setEnabled(hab);
		tabla.setEnabled(hab);
		panelTabla.setEnabled(hab);
		cboxPorce.setEnabled(hab);
		
		porDatos.setEnabled(!hab);
		txtArea.setEnabled(!hab);
		btnCargarList.setEnabled(!hab);
		btnSaveList.setEnabled(!hab);
		
	}
}
