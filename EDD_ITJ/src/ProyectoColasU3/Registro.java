package ProyectoColasU3;

import static ProyectoColasU3.ClaseMain.valores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;

public class Registro extends JFrame
{

	private static final long serialVersionUID = 4685645590168579025L;

	private JPanel contentPane;
	
	private TablaAlumnos tabla = new TablaAlumnos();
	private JScrollPane jsc = new JScrollPane();
	private final JPanel panel = new JPanel();
	private final JButton btnBorrar;
	public static JButton btnNewButton = new JButton("Crear Cola");
	
	private Animacion animacion = new Animacion();
	private final JButton btnAyuda = new JButton("Ayuda");
	
	public Registro()
	{
		super("Registro de alumnos");
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(tabla.crearCola(Registro.this))
				{
					animacion.panelProceso.timerProceso1();
					animacion.setVisible(true);
					animacion.setLocationRelativeTo(Registro.this);
					btnNewButton.setEnabled(false);
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 586, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		panel.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		tabla.setBackground(Color.WHITE);
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		jsc.setViewportView(tabla);
		JButton btnNuevoRegistro = new JButton("Nuevo Registro");
		btnNuevoRegistro.setBackground(Color.WHITE);
		btnNuevoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tabla.cont==31)
						JOptionPane.showMessageDialog(Registro.this, "No puede agregar mas de 30 registros","Tabla llena",
								JOptionPane.INFORMATION_MESSAGE);
				else tabla.agregaRegistro();
			}
		});
		
		btnAyuda.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(Registro.this, 
						"1) La tabla solo admite 30 registros, si se ingresa uno mas, no lo agrega\n"
						+ "2) Los Defectos A, B y C, indican que tiene el alumno que ingresa\n"
						+ " A para personas embarazadas\n B para personas discapacitdas\n"
						+ " C para personas normales, que no tienen ningun defecto\n"
						+ "3) Los registros default añaden 12 registros creados en una matriz y los\n añade a "
						+ "la tabla, tambien el maximo que puede agregar son 30 registros",
						"INFO",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnBorrar = new JButton("Borrar Registro");
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla.delete();
			}
		});
		
		JButton btnAgregarRegistros = new JButton("Registros Default");
		btnAgregarRegistros.setBackground(Color.WHITE);
		btnAgregarRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String valorLetra="";
				
				if(tabla.cont<=30)
				for(int i=0; i<valores.length; i++)
				{
					valorLetra = Estudiante.getLetraValor((int)valores[i][1]);
					tabla.agregaRegistroDefault(valores[i][0].toString(), valorLetra);
					
					if(tabla.cont>=31)
						break;
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(jsc, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(jsc, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnNuevoRegistro);
		panel.add(btnBorrar);
		panel.add(btnAgregarRegistros);
		panel.add(btnNewButton);
		btnAyuda.setBackground(Color.WHITE);
		
		panel.add(btnAyuda);
		contentPane.setLayout(gl_contentPane);
		
	}
}
