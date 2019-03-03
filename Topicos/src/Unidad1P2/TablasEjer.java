package Unidad1P2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TablasEjer extends JFrame
{
	DefaultTableModel modelo = new DefaultTableModel() {
		
		public Class<?> getColumnClass(int columnIndex)
		{
			if(columnIndex==2)
				return Double.class;
			
			return String.class;
		}
	};
	JTable tabla;
	JButton btnCrear;
	Dialogo di = new Dialogo(this, false);
	
	public TablasEjer() 
	{
		setLayout(new BorderLayout(5,5));
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		modelo.addColumn("Nombre");
		modelo.addColumn("Tipo de servicio");
		modelo.addColumn("Costo");
		
		btnCrear = new JButton("Crear registro");
	
		
		tabla = new JTable(modelo);
		
		add(new JScrollPane(tabla),"Center");
		
		JPanel panelBtns = new JPanel();
		
		panelBtns.add(btnCrear);
		
		btnCrear.addActionListener(
				
					(a) -> di.setVisible(true)
				
				);
		
		add(panelBtns,"South");
	}
	
	public static void main(String[] args) 
	{
		new TablasEjer().setVisible(true);
	}
}
class Dialogo extends JDialog
{
	JLabel etn,ets,etc;
	JTextField txtN,txtS,txtC;
	JButton ba,bc;
	TablasEjer ejer;
	
	public Dialogo(JFrame f, boolean modal) 
	{
		super(f, modal);
		ejer = (TablasEjer) f;
		
		setSize(500, 200);
		setLocationRelativeTo(f);
		setLayout(new GridLayout(4,2,10,10));
		
		etn = new JLabel("Nombre del cliente: ");
		ets = new JLabel("Tipo de servicio: ");
		etc = new JLabel("Costo estimado: ");
		
		txtN = new JTextField(10);
		txtS = new JTextField(10);
		txtC = new JTextField(10);
		
		ba = new JButton("Aceptar");
		
		ba.addActionListener(
					
					(a)->{
						
						String nombre = txtN.getText();
						String serv = txtS.getText();
						
						if(getCosto(txtC.getText()))
						{
							ejer.modelo.addRow(new Object[] {nombre,serv,c});
							this.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(f, "Solo datos numericos", "Error en el campo costo", 
									JOptionPane.ERROR_MESSAGE);
						}
						
					}
				
				);
		
		bc = new JButton("Cancelar");
		
		bc.addActionListener(
				
					(a)->{
						this.dispose();
					}
				
				);
		
		add(etn);
		add(txtN);
		add(ets);
		add(txtS);
		add(etc);
		add(txtC);
		
		add(ba);
		add(bc);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	double  c;

	public boolean validar(String c1,String c2,String c3)
	{
		if(c1.trim().isEmpty() || c2.trim().isEmpty() || c3.trim().isEmpty())
		{
			JOptionPane.showMessageDialog(ejer, "Debe registrar datos");
			return false;
		}
		
		return true;
		
	}
	
	public boolean getCosto(String texto)
	{
		try {
			
			c = Double.parseDouble(texto);
			return true;
			
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
