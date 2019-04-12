package Proyecto;

import static Proyecto.FileSerGetter.categoriasNum;
import static Proyecto.FileSerGetter.determinarDatosLista;
import static Proyecto.FileSerGetter.determinarDatosTable;
import static Proyecto.FileSerGetter.getFormatTable;
import static Proyecto.FileSerGetter.getFormatText;
import static Proyecto.FileSerGetter.nombreCat;
import static Proyecto.FileSerGetter.porcentajes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigDecimal;

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
	private JButton añadirCategoria, borrarCategoria, refrescar, btnAplicar, btnCargarTabla, btnSaveTabla,
			btnCargarList, btnSaveList;
	public JCheckBox cboxCrearTabla = new JCheckBox("Crear mediante tabla"), cboxPorce;
	private JPanel panelTabla, porDatos;
	private AreaDibujo areaD;
	private int i;
	private Pestanas pest;
	private JFileChooser chosser;
	private FileNameExtensionFilter ftable, flist;

	@SuppressWarnings("serial")
	public Categorias(String path)
	{
		chosser = new JFileChooser(new File(path + "/SerFiles/"));
		ftable = new FileNameExtensionFilter("Archivos formato table", "table");
		flist = new FileNameExtensionFilter("Archivos formato list", "list");

		setLayout(new BorderLayout(0, 10));
		setSize(700, 600);
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);

		JPanel p = new JPanel();
		{
			btnAplicar = new JButton("Aplicar");
			btnAplicar.addActionListener(this);
			p.add(cboxCrearTabla);
			p.add(btnAplicar);
			cboxPorce = new JCheckBox("Graficar por porcentaje");
			p.add(cboxPorce);
			cboxCrearTabla.addChangeListener(this);

			add(p, "North");
		}

		JPanel gen = new JPanel();
		{
			gen.setLayout(new GridLayout(2, 1, 0, 10));

			panelTabla = new JPanel();
			setBackground(Color.white);
			panelTabla.setBackground(Color.white);
			TitledBorder titulo = new TitledBorder(BorderFactory.createLineBorder(Color.blue, 1, true),
					"Categorias por tabla");

			panelTabla.setBorder(titulo);

			{
				panelTabla.setLayout(new BorderLayout());
				modelo = new DefaultTableModel()
				{
					@Override
					public Class<?> getColumnClass(int columnIndex)
					{
						if (columnIndex == 1)
							return Integer.class;

						else if (columnIndex == 2)
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

					panelTabla.add(panelBtns, "South");
				}

				panelTabla.add(new JScrollPane(tabla), "Center");
				gen.add(panelTabla);
			}

			porDatos = new JPanel();

			titulo = new TitledBorder(BorderFactory.createLineBorder(Color.blue, 1, true), "Categorias por datos");

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

				porDatos.add(panelConfD, "South");
			}

			add(gen, "Center");

		}
	}

	public void setTabbed(Pestanas p)
	{
		pest = p;
		cboxCrearTabla.setSelected(true);
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
				Object[][] p = getFormatTable(chosser.getSelectedFile(),true);
				
				if(p!=null)
				{
					modelo.setRowCount(0);
					
					for(Object c[] : p)
					{
						modelo.addRow(c);
					}
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
				String t = getFormatText(chosser.getSelectedFile(),true);
				
				if(t!=null)
				{
					txtArea.setText(t);
				}
			}
			
		}
		
		else
		{
			if(cboxCrearTabla.isSelected())
			{
				if(modelo.getRowCount()!=0)
				{
					int indTab;
					boolean byPorc;
					Object datos[][] = new Object[modelo.getRowCount()][3];
					String c;
					Number num;
					
					if(cboxPorce.isSelected())
					{
						indTab = 2;
						byPorc = true;
					}
					else
					{
						indTab = 1;
						byPorc = false;
					}
					
					scan:
					{
						for(int i=0; i<datos.length; i++)
						{
								
							c = (String) modelo.getValueAt(i, 0);

							if(c==null  || c.trim().isEmpty())
							{
								JOptionPane.showMessageDialog(null,
										"Los campos de las columnas 0 y"+indTab+" \n"
										+ "deben ser rellenados totalmente",
										"Error en fila: "+i+" - Columna: 0",
										JOptionPane.ERROR_MESSAGE);
								break scan;
							}
							
							datos[i][0] = c;
							
							if(byPorc)
								num = (BigDecimal) modelo.getValueAt(i, indTab);
							else 
								num = (Integer)  modelo.getValueAt(i, indTab);
							
							if(num==null)
							{
								JOptionPane.showMessageDialog(null,
										"Los campos de las columnas 0 y"+indTab+" \n"
										+ "deben ser rellenados totalmente",
										"Error en fila: "+i+" - Columna: 0",
										JOptionPane.ERROR_MESSAGE);
								break scan;
							}
							
							datos[i][indTab] = num;
						}
						
						determinarDatosTable(datos);
						
						if(byPorc)
							areaD.gr.setPorcentajes(porcentajes, nombreCat, PanelFondos.tamanio);
						
						else areaD.gr.setDatos(categoriasNum, nombreCat);
						
						this.dispose();
					}
					
						
				}
				else JOptionPane.showMessageDialog(this, "Debe ingresar al menos una categoria",
						"Categoria Vacia", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(!txtArea.getText().trim().isEmpty())
				{
					determinarDatosLista(txtArea.getText());
					areaD.gr.setDatos(categoriasNum, nombreCat);
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
		habilitarTabla(cboxCrearTabla.isSelected());
		pest.habilitar(cboxCrearTabla.isSelected());
	}

	public void update(int x[], String y[])
	{
		reset();

		if (cboxCrearTabla.isSelected())
		{
			for (i = 0; i < x.length; i++)
			{
				modelo.addRow(new Object[] { y[i], x[i] });
			}
		} else
		{
			for (String d : y)
				txtArea.append(d + "-");

		}
	}
	
	public void updatePorc(BigDecimal x[], String y[])
	{
		reset();

		for (i = 0; i < x.length; i++)
		{
			modelo.addRow(new Object[] { y[i],null,x[i] });
		}
	}

	public void reset()
	{
		modelo.setRowCount(0);
		txtArea.setText("");
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
