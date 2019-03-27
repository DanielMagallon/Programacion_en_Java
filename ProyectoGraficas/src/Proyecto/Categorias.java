package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class Categorias extends JDialog implements ChangeListener
{
	private static final long serialVersionUID = -5289217806338113929L;
	DefaultTableModel modelo;
	JTable tabla;
	JButton añadirCategoria;
	JCheckBox cbox = new JCheckBox("Crear medinate tabla");
	JPanel panelTabla,porDatos;
	
	public Categorias()
	{
		setLayout(new BorderLayout(0,10));
		setSize(400, 600);
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		
		JPanel p = new JPanel();
		
		{
			p.add(cbox);
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
						
						return String.class;
					}
				};
				
				modelo.addColumn("Categoria");
				modelo.addColumn("Numero de datos");
				
				tabla = new JTable(modelo);
				
				añadirCategoria = new JButton("Añadir categoria");
				añadirCategoria.addActionListener((a)->{
					modelo.addRow(new Object[] {});
				});
				
				JPanel panelBtns = new JPanel();
				{
					panelBtns.setBackground(Color.white);
					panelBtns.add(añadirCategoria);
					panelTabla.add(panelBtns,"South");
				}
				
				panelTabla.add(new JScrollPane(tabla),"Center");			
				gen.add(panelTabla);
			}
			
			
			 porDatos = new JPanel();
			
			titulo = new TitledBorder(BorderFactory.createLineBorder
					(Color.blue, 1, true), "Categorias por datos");
			
			porDatos.setBorder(titulo);
			
			gen.add(porDatos);
			
			add(gen,"Center");
			
			cbox.setSelected(true);
		}
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		habilitarTabla(cbox.isSelected());
	}
	
	private void habilitarTabla(boolean hab)
	{
		añadirCategoria.setEnabled(hab);
		panelTabla.setEnabled(hab);
		
		porDatos.setEnabled(!hab);
		
	}
}
