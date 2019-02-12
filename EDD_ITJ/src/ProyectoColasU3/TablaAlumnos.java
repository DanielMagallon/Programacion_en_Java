package ProyectoColasU3;

import static ProyectoColasU3.PanelCola.alumnos;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaAlumnos extends JTable
{
	private static final long serialVersionUID = -741622485099702414L;

	private DefaultTableModel modelo;
	
	public int cont=1,id=1;
	
	public TablaAlumnos()
	{
		modelo  = new DefaultTableModel(){
			
			private static final long serialVersionUID = -7424341432982576014L;

			@Override
			public boolean isCellEditable(int row, int column)
			{
				return (column!=0);
			}
			
		};
				
		getTableHeader().setReorderingAllowed(false);
		
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Problema (A | B | C)");
		this.setModel(modelo);
		
		setSelectionBackground(Color.cyan);
		
	}

	public void delete()
	{
			int rows[] = getSelectedRows();
		
			if(rows.length!=0)
			{
				for(int i=0; i<rows.length; i++)
				{
					modelo.removeRow(rows[i]-i);
					cont--;
				}
				setModel(modelo);
			}
			
			
	}
	
	public boolean crearCola(Component c)
	{
		if(cont==1)
		{
			JOptionPane.showMessageDialog(c,"No hay registros","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		String dato;
		int i;
		
		for(i=0; i<cont-1; i++)
		{
			if (modelo.getValueAt(i,1).toString().trim().equals(""))
			{
				JOptionPane.showMessageDialog(c,"La columna  'Nombre' deben tener registros en cada fila"
								,"Error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			dato = modelo.getValueAt(i,2).toString().trim();
			
			if(!dato.equalsIgnoreCase("A") && !dato.equalsIgnoreCase("B") && !dato.equalsIgnoreCase("C"))
			{
				JOptionPane.showMessageDialog(c,"Las defectos solo pueden ser A, B o C",
						"Error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
		}
		
		alumnos = new Estudiante[cont-1];
		
		for(i=0; i<cont-1; i++)
		{
			dato = modelo.getValueAt(i,2).toString().trim();
			
			alumnos[i] = new Estudiante(modelo.getValueAt(i,1).toString().trim(), 
							Estudiante.getValorDefecto(dato));
		}
		
		return true;
	}
	
	
	public void agregaRegistro()
	{
		agregaRegistroDefault("", "");
	}
	
	public void agregaRegistroDefault(String name, String val)
	{
			modelo.addRow(new Object[]{id++,name,val});
			cont++;
			setModel(modelo);
	}

}
