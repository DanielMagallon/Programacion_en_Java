package Practica1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

//import com.qoppa.pdf.PDFException;
//import com.qoppa.pdfText.PDFText;

public class Ejecutable extends JFrame {

	public static DefaultTableCellRenderer conf = new DefaultTableCellRenderer();
	private static final long serialVersionUID = 6369071396291484748L;
	
	private JPanel contentPane,panelTabla,panelFila;
	PanelGrafico panelGrafica;

	private TablaAleatoria tablaRnd;
	private TablaSimulada tablaSim;
	private JLabel lbl = new JLabel("Numero de lanzamientos");
	private JTextField txtNumero = new JTextField(10);
	public JButton btnCrearLan = new JButton("Crear lanzmientos");
	
	
	private JButton btnInvertir =  new JButton("Invertir valores");
	
	public JButton btnGenera = new JButton("Ejecutar");
	private JCheckBox box = new JCheckBox("Por segundo");
	private JCheckBox click = new 
			JCheckBox("Escoger dados");
	
	private int cantidad;
	
	int row=0;
	private Timer timer = new Timer(1000, 
			
	
			 (a) -> 
				{
					
					proceso();
					
					row++;
					
					if(row==cantidad)
						parar();
	    		}
			
			);
	
	private void parar()
	{
		row=0;
		timer.stop();
		btnGenera.setEnabled(true);
		btnCrearLan.setEnabled(true);
		txtNumero.setEditable(true);
		
	}
	
	static
	{
		conf.setHorizontalAlignment(SwingConstants.CENTER);
	}
	

	/**
	 * Create the frame.
	 */
	public Ejecutable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height-40);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 10));
		setContentPane(contentPane);
		
		tablaRnd = new TablaAleatoria();
		
		panelGrafica = new PanelGrafico(this);
		
		
		
		add(panelGrafica,BorderLayout.CENTER);
		add(panelTabla = new JPanel(),BorderLayout.WEST);
		add(panelFila = new JPanel(),BorderLayout.SOUTH);
		
		JScrollPane sc = new JScrollPane();
		
		panelTabla.setBorder(BorderFactory.createTitledBorder("Generacion de aleatorios"));
		panelTabla.setLayout(new BorderLayout(5,5));
		
		JPanel panel = new JPanel();
		panel.add(lbl);
		panel.add(txtNumero);
		panel.add(btnCrearLan);
		panel.add(click);
		
		
		panelTabla.add(panel,BorderLayout.NORTH);
		
		panelFila.setBorder(BorderFactory.createTitledBorder("Fila de espera"));
		
		
		sc.setViewportView(tablaRnd);
		panelTabla.add(sc);
		
		panelFila.setLayout(new BorderLayout(5,5));
		tablaSim = new TablaSimulada();
		
		
		JPanel p2 = new JPanel();
		JScrollPane sc2 = new JScrollPane();
		p2.add(btnInvertir);
		sc2.setViewportView(tablaSim);
		panelFila.add(sc2,BorderLayout.CENTER);
		
		panelFila.add(p2, BorderLayout.NORTH);

		
		p2.add(box);
		p2.add(btnGenera);
		
		agregarEventos();
	
//		try {
//			PDFText pdf = new PDFText(new URL("file:///C:/Users/Yeo/Documents/Ejercicio%202/Digitos%20Aleatorios.pdf"), null);
//			
//			System.out.println(pdf.getText());
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PDFException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private void convierte()
	{
		try
		{
			cantidad = Integer.parseInt(txtNumero.getText());
			generaAleatorios();
		}catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(panelTabla, "Solo debe ingresar datos numericos",
					"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void agregarEventos()
	{
		JPopupMenu pop = new JPopupMenu();
		JMenuItem men = new JMenuItem();
		men.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,Event.CTRL_MASK));
		men.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog d = new JDialog();
				JTable jt = new JTable(tablaRnd.getModel());
				
				jt.getColumnModel().getColumn(0).setCellRenderer(conf);
				jt.getColumnModel().getColumn(1).setCellRenderer(conf);
				jt.getColumnModel().getColumn(2).setCellRenderer(conf);
				
				d.add(new JScrollPane(jt));
				d.pack();
				d.setVisible(true);
			}
		});
		pop.add(men);
		
		tablaRnd.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.isPopupTrigger())
					pop.show(tablaRnd,e.getX(), e.getY());
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		txtNumero.addActionListener(
				
					new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							if(!click.isSelected())
								convierte();
						}
					}
				
				);
		
		
		
		btnCrearLan.addActionListener(
				
					new  ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(btnCrearLan.getText().equals("Parar"))
								panelGrafica.restablecer();
							
							else
							{
								if(click.isSelected())
								{
									btnCrearLan.setText("Parar");
									panelGrafica.timer.start();
									return;
								}
								convierte();
							}
						}
					}
				
				);
		
		btnGenera.setEnabled(false);
		btnGenera.addActionListener(
				
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						cantidad = tablaRnd.getRowCount();
						ejecutar();
					}
				}
				
				);
		
		KeyPres kp = new KeyPres(this);
		tablaRnd.addKeyListener(kp);
		tablaSim.addKeyListener(kp);
		
		/*
		 * Probabilidad de que haya uno,dos,tres, en la fila
		 * Usando la media de servicios y de llegada
		 * 		 */
		btnInvertir.addActionListener(
				
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try
						{
						int rows = tablaRnd.getRowCount();
						
						if(rows != 0)
						{
							int val;
							
							for(int i=0; i<rows; i++)
							{
								val = (int) tablaRnd.getValueAt(i, 2);
								tablaRnd.setValueAt(tablaRnd.getValueAt(i, 1), i, 2);
								tablaRnd.setValueAt(val, i, 1);
							}
						}
						}catch(NullPointerException ex){}
					}
				}
				
				);
	}
	
	
	Random lb = new Random();
	
	private void ejecutar()
	{
		if(box.isSelected())
		{
			btnGenera.setEnabled(false);
			btnCrearLan.setEnabled(false);
			txtNumero.setEditable(false);
			timer.start();
		}
		else
		{
			
				for(;row<cantidad; row++)
					proceso();
			
			row=0;
		}
	}
	
	private void proceso()
	{
		if(row==0)
			valoresDeafult();
		
		else
		{
			tablaSim.agregaValores(1, row, tablaRnd.getValIndexOf(1, row));
			
			tablaSim.agregaValores(2, row, 
					tablaSim.getValOf(1, row) + tablaSim.getValOf(2, row-1));
			
			tablaSim.agregaValores(4, row, tablaRnd.getValIndexOf(2, row));
			
			
			if(tablaSim.getValOf(5, row-1)>tablaSim.getValOf(2, row))
			{

				tablaSim.agregaValores(3, row, tablaSim.getValOf(5, row-1));

				tablaSim.agregaValores(7, row, 
						tablaSim.getValOf(3, row)-tablaSim.getValOf(2, row)
						);
				
				tablaSim.agregaValores(6, row, 0);
			}
			
			else
			{
				tablaSim.agregaValores(3, row, tablaSim.getValOf(2, row));
				
				tablaSim.agregaValores(6, row, 
						tablaSim.getValOf(3, row)-tablaSim.getValOf(5, row-1)
						);
				
				
				tablaSim.agregaValores(7, row, 0);

			}
			
			tablaSim.agregaValores(5, row, 
					tablaSim.getValOf(4, row) + tablaSim.getValOf(3, row));
		}
	}
	
	public void borrarDatos()
	{
		tablaRnd.reset();
		tablaSim.reset();
		btnGenera.setEnabled(false);
	}
	
	private void valoresDeafult()
	{
		{
			tablaSim.agregaValores(1, 0, 0);
			tablaSim.agregaValores(2, 0, 0);
			tablaSim.agregaValores(3, 0, 0);
			tablaSim.agregaValores(4, 0, tablaRnd.getValIndexOf(2, 0));
			tablaSim.agregaValores(5, 0, tablaRnd.getValIndexOf(2, 0));
			tablaSim.agregaValores(6, 0, 0);
			tablaSim.agregaValores(7, 0, 0);
		}
		
		
	}
	
	
	private void generaAleatorios()
	{
			if(cantidad>0)
			{
				int r1,r2,r3;
				
				btnGenera.setEnabled(true);
				tablaRnd.reset();
				tablaSim.reset();
				
				for(int i=0; i<cantidad; i++)
				{
					r1 = lb.nextInt(6)+1;
					r2 = lb.nextInt(6)+1;
					r3 = lb.nextInt(6)+1;
					
					
					tablaRnd.agregaFila(r1, r2+r3);
					tablaSim.agregaClientes();
				}
			}
		
	}
	
	public void nuevaFila(int val,int suma)
	{
		tablaRnd.agregaFila(val, suma);
		tablaSim.agregaClientes();
	}
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejecutable frame = new Ejecutable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/*//Si tiempo fin de servicio (columna5(reng-1)>tiempo de llagada (columna2[reng])):
				/*
				 * columna 1 (reng) = valorRandomTabla;
				 * columna 2(reng) = columna1(reng) + columna2(reng-1);
				 *  
				 */
				
				/*
				 * columna 4(reng) =  valor2RandomTabla;
				 * columna 5(reng) = columna4(reng) + columna5(reng-1)
				 */
				
				/*
				 * columna 3 (reng) = columna5(reng-1)
				 */
				
				/*
				 * columna7(reng) = Tinicio(3)-Tllegada(2);
				 * columna6(reng)= 0;
				 */

}
