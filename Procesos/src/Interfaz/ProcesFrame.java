  package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Perfomance.MonoProceso;
import Perfomance.Proceso;

import javax.swing.JTextField;

public class ProcesFrame extends JFrame implements ActionListener, MouseListener
{

	private static final long serialVersionUID = 981311907337251927L;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	
	public static MonoProceso monoP;
	public TablaPCB tablePCB;
	private JLabel lblPcb;
	
	public static JButton btnNuevoProceso,btnBorrarProceso,btnGuardarProcesos,btnEjecutarProcesos;
	
	private Restricciones restricciones; 
	
	public static Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);
	public static Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
	private JTextField txtEje;
	
	public ProcesFrame() 
	{
		setTitle("JAVA_ROUND ROBBIN");
		setCursor(new Cursor(0));
		monoP = new MonoProceso(this);
		restricciones = new Restricciones();
		monoP.setBackground(Color.WHITE);
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelExe = new JPanel();
		panelExe.setBackground(Color.WHITE);
		panelExe.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panelExe.add(scrollPane);
		
		scrollPane.setViewportView(monoP);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		tablePCB = new TablaPCB();
		tablePCB.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(tablePCB);
		
		btnEjecutarProcesos = new JButton("Ejecutar Procesos");
		btnEjecutarProcesos.setEnabled(false);
		btnEjecutarProcesos.setActionCommand("Exe");
		btnEjecutarProcesos.addMouseListener(this);
		btnEjecutarProcesos.addActionListener(this);
		btnEjecutarProcesos.setBackground(Color.WHITE);
		
		lblPcb = new JLabel("PCB");
		lblPcb.setHorizontalAlignment(SwingConstants.CENTER);
		lblPcb.setFont(new Font("Wide Latin", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		
		JLabel lblTiempoDeEjecucion = new JLabel("Tiempo de ejecucion General");
		lblTiempoDeEjecucion.setFont(new Font("Blackadder ITC", Font.PLAIN, 25));
		
		txtEje = new JTextField();
		txtEje.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelExe, GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(214)
							.addComponent(lblPcb, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(180)
							.addComponent(btnEjecutarProcesos)
							.addGap(210))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblTiempoDeEjecucion, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtEje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(80)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelExe, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblPcb)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEjecutarProcesos)
							.addGap(105)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTiempoDeEjecucion)
								.addComponent(txtEje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		
		btnNuevoProceso = new JButton("Nuevo Proceso");
		btnNuevoProceso.addActionListener(this);
		btnNuevoProceso.addMouseListener(this);
		btnNuevoProceso.setActionCommand("New");
		btnNuevoProceso.setBackground(Color.WHITE);
		panel.add(btnNuevoProceso);
		
		btnBorrarProceso = new JButton("Borrar Proceso");
		btnBorrarProceso.addActionListener(this);
		btnBorrarProceso.addMouseListener(this);
		btnBorrarProceso.setActionCommand("Delete");
		btnBorrarProceso.setBackground(Color.WHITE);
		panel.add(btnBorrarProceso);
		
		btnGuardarProcesos = new JButton("Guardar Procesos");
		btnGuardarProcesos.setActionCommand("Save");
		btnGuardarProcesos.addMouseListener(this);
		btnGuardarProcesos.addActionListener(this);
		btnGuardarProcesos.setBackground(Color.WHITE);
		panel.add(btnGuardarProcesos);
		
		contentPane.setLayout(gl_contentPane);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public double time;
	public boolean getTime()
	{
		try
		{
			time = Double.parseDouble(txtEje.getText());
			
			if(time>0)
				return true;
			
		}
		catch(NumberFormatException e){
		}
	
		JOptionPane.showMessageDialog(this, "El tiempo de ejecucion ingresado no es valido",
				"ERROR: Tiempo>0",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	public static ArrayList<Proceso> procesosList;
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "Exe":
				if(getTime())
				{
					habilitar(false);
					btnEjecutarProcesos.setEnabled(false);
					tablePCB.setEnabled(false);
					monoP.crearTabla(time, procesosList);
					monoP.ejecutar();
					
				}
				break;
				
			case "Save":
				if(tablePCB.getRowCount()!=0)
				{
					tablePCB.borrarContador();
					procesosList=tablePCB.getProcesos();
					restricciones.setVisible(true);
				}
				else JOptionPane.showMessageDialog(btnEjecutarProcesos, "No hay procesos aun","Error",
						JOptionPane.ERROR_MESSAGE);
				break;
				
			case "New":
				tablePCB.agregarProceso(1);
				break;
				
			case "Delete":
				tablePCB.borrarProcesos();
				break;
		}
	}
	
	public void habilitar(boolean hablitar)
	{
		btnNuevoProceso.setEnabled(hablitar);
		btnBorrarProceso.setEnabled(hablitar);
		btnGuardarProcesos.setEnabled(hablitar);
	}
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ProcesFrame frame = new ProcesFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		if(!monoP.timerProceso.isRunning())
			this.setCursor(handCursor);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!monoP.timerProceso.isRunning())
			this.setCursor(null);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
