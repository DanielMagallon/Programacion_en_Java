package Unidad1P2;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Tablas extends JFrame 
{
	JTable tabla;
	Vector <String> titulos;
	
	Vector<Vector> datos;
	
	DefaultTableModel modelo;
	
	JButton agregar;
	
	public Tablas() 
	{
		super("Jtable");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		titulos = new Vector<String>();
		titulos.add("Nombre");
		titulos.add("Edad");
		titulos.add("Sexo");
		
		
		datos = new Vector<Vector>();
		llenarDatos("Otho",45,'M');
		llenarDatos("Edgar",20,'M');
		llenarDatos("Berenice",15,'F');
		
		JScrollPane sc = new JScrollPane();
			
		//tabla = new JTable(datos,titulos);
		modelo = new DefaultTableModel(datos,titulos) 
		{
			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return (column==1);
					
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) 
			{
				if(columnIndex==1)
					return Integer.class;
					
				if(columnIndex==2)
					return Character.class;
				
				return String.class;
			}
			
			public void addRow(Vector<?> rowData) 
			{
				if((Integer) rowData.get(1) <=30)
					super.addRow(rowData);
				
				else System.out.println("No añado");
			}
		};
		
		
		Vector c = new Vector();
		c.add("Luis");
		c.add(67);
		c.add('2');
		modelo.addRow(c);
		tabla = new JTable(modelo);
		sc.setViewportView(tabla);	
		
//		modelo.insertRow(1, c);
	   
		add(sc,"Center");
		add(agregar = new JButton("Agregar")
				,"South");
		
		
	}
	
	void llenarDatos(String name,Integer val, Character c)
	{
		Vector r1 = new Vector();
		r1.add(name);
		r1.add(val);
		r1.add(c);
		
		datos.add(r1);
		
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(
				
					() -> new Tablas().setVisible(true)
					
				
				);
	}
}
