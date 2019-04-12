package UnidadBD;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class InterfazBD extends JFrame implements ActionListener
{

	JMenuBar barraMenu;
	JMenu menuAgregar,menuConsultas, menuUpdate,menuEliminar,menuIndiv,menuCEsp;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10;
	Conexion conexion;
	Desplegar desp = new Desplegar(this);
	
	public InterfazBD()
	{
		super("Compañia de Seguros SinSiniestro");
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		setExtendedState(MAXIMIZED_BOTH);
//		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		conexion = new Conexion("Ajedrez", "localhost");
		
		ponerMenu();
		
	}
	
	void ponerMenu()
	{
		menuAgregar = new JMenu("Agregar");
		mi1 = new JMenuItem("Clientes");
		mi1.addActionListener(this);
		
		mi2 = new JMenuItem("Automoviles");
		mi3 = new JMenuItem("Seguros");
		mi4 = new JMenuItem("Accidentes");
		menuAgregar.add(mi1);
		menuAgregar.add(mi2);
		menuAgregar.add(mi3);
		menuAgregar.add(mi4);
		
		menuConsultas = new JMenu("Consultas");
		menuIndiv = new JMenu("Individual");
		menuCEsp = new JMenu("Especiales");
		menuConsultas.add(menuIndiv);
		menuConsultas.add(menuCEsp);
		mi5 = new JMenuItem("Clientes");
		mi6 = new JMenuItem("Automoviles");
		mi7 = new JMenuItem("Seguros");
		mi8 = new JMenuItem("Accidentes");
		menuIndiv.add(mi5);
		menuIndiv.add(mi6);
		menuIndiv.add(mi7);
		menuIndiv.add(mi8);
		mi9 = new JMenuItem("Automoviles x cliente");
		mi10 = new JMenuItem("Seguro por automovil");
		menuCEsp.add(mi9);
		menuCEsp.add(mi10);
		
		menuUpdate = new JMenu("Modificar");
		menuEliminar = new JMenu("Eliminar");
		barraMenu.add(menuAgregar);
		barraMenu.add(menuConsultas);
		barraMenu.add(menuUpdate);
		barraMenu.add(menuEliminar);
		mi5.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource() == mi5)
		{
			Vector<Vector<String>> consulta;
			
			consulta = conexion.consulta("Select * From Jugadores");
			
			Vector<String> vec = new Vector<String>();
			vec.add("id");
			vec.add("Nombre");
			
			desp.visible("Consultas ", consulta, vec);
		}
		
		else if(arg0.getSource() == mi1)
		{
			PedirDatos d = new PedirDatos(this, "Agregar");
			RegistroJugadores r = d.getRegistros();
			
			conexion.agregarV(r.nombre, r.edad);
			
			
		}
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(()->new InterfazBD());
	}
}

class RegistroJugadores
{
	String nombre;
	int edad;
}

class PedirDatos extends JDialog
{
	RegistroJugadores r;
	
	public PedirDatos(InterfazBD i, String title)
	{
		super(i,true);
		setTitle(title);
		setSize(600, 300);
	}
	
	public RegistroJugadores getRegistros()
	{
		r = new RegistroJugadores();
		r.nombre = "Juan";
		r.edad = 20;
		
		return r;
	}
}

class Desplegar extends JDialog
{
	InterfazBD ref;
	JTable tablaDatos;
	DefaultTableModel modelo;
	
	public Desplegar(InterfazBD ref)
	{
		super(ref,true);
		this.ref = ref;
		setSize(800, 800);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		modelo = new DefaultTableModel();
		tablaDatos = new JTable(modelo);
		JScrollPane sc = new JScrollPane(tablaDatos);
		add(sc,"Center");
		
	}
	
	void visible(String title,Vector<Vector<String>> datos, Vector<String>titulosTabla)
	{
		setTitle(title);
		
		modelo = new DefaultTableModel(datos,titulosTabla);
		
		tablaDatos.setModel(modelo);
		
		setVisible(true);
	}
}
