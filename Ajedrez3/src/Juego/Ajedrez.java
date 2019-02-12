package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Abstract.Variables;
import Eventos.Almacena;
import Eventos.MoveListener;
import Interfaz.Busquedas;
import Interfaz.Evaluador;
import Interfaz.TableroAjedrez;
import Partidas.Descodificador;
import Partidas.Estados;
import Partidas.Mostra;
import Partidas.Serializa;
import Piezas.Pieza;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.InputEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

import static Abstract.Variables.torreBlancaCM;
import static Abstract.Variables.torreBlancaLM;
import static Abstract.Variables.torreNegraCM;
import static Abstract.Variables.torreNegraLM;
import static Abstract.Variables.reyBlancoMeneado;
import static Abstract.Variables.reyNegroMeneado;
import static Abstract.Variables.turnoBlancas;

public class Ajedrez extends JFrame implements ActionListener 
{

	private static final long serialVersionUID = 754714662536573761L;
	private JPanel contentPane;
	private TableroAjedrez tablero;
	public static Pieza piezaPremio=Variables.reina;
	private Busquedas ventana;

//	private Evaluador eval = new Evaluador();
	
	public static Descodificador desc = new Descodificador();
	public static Descodificador desc2 = new Descodificador();
	
	private  JFileChooser chosser = new JFileChooser();
	private int ruta;
	private File file;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			
			public void run() {
				try {
					//System.out.println("\u2654||A");
					Ajedrez frame = new Ajedrez();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
	}

	private JLabel[] indicador = new JLabel[8];
	private JLabel[] indicador2 = new JLabel[8];
	
	private JPanel panelNorte = new JPanel();
	private JPanel panelIzq = new JPanel();
	
	private JButton btnMostrar;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmGuardarJuego;
	private JMenuItem mntmCargarJuego;
	private JMenu mnGuardar;
	private JMenuItem mntmGuardarJugadas;
	private JMenu mnCargar;
	private JMenuItem mntmCargarJugadas;
	private JMenu mnEstado;
	private JMenuItem mntmRetroceder;
	private JMenuItem mntmAvanzar;
	private JMenu mnCoronacion;
	private JRadioButtonMenuItem rdbtnmntmReina;
	private JRadioButtonMenuItem rdbtnmntmTorre;
	private JRadioButtonMenuItem rdbtnmntmCaballo;
	private JRadioButtonMenuItem rdbtnmntmAlfil;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenuItem mntmVistaAyuda;
	
	public Ajedrez() 
	{
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 600, 600);

		chosser.setCurrentDirectory(new File
									("C:/Users/edgar/Documents/workspace_mars/Ajedrez3.0/Recursos/Partidas"));
		
		ventana = new Busquedas();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setMnemonic('N');
		mnJuego.add(mntmNuevo);
		mntmNuevo.addActionListener(this);
		
		mnGuardar = new JMenu("Guardar");
		mnJuego.add(mnGuardar);
		
		mntmGuardarJugadas = new JMenuItem("Guardar jugadas");
		mnGuardar.add(mntmGuardarJugadas);
		mntmGuardarJugadas.addActionListener(this);
		
		mntmGuardarJuego = new JMenuItem("Guardar juego");
		mnGuardar.add(mntmGuardarJuego);
		mntmGuardarJuego.addActionListener(this);
		
		mnCargar = new JMenu("Cargar");
		mnJuego.add(mnCargar);
		
		mntmCargarJugadas = new JMenuItem("Cargar jugadas");
		mnCargar.add(mntmCargarJugadas);
		mntmCargarJugadas.addActionListener(this);
		
		mntmCargarJuego = new JMenuItem("Cargar juego");
		mnCargar.add(mntmCargarJuego);
		mntmCargarJuego.addActionListener(this);
		
		mnEstado = new JMenu("Estado");
		mnJuego.add(mnEstado);
		
		mntmAvanzar = new JMenuItem("Avanzar");
		mntmAvanzar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.SHIFT_MASK));
		mnEstado.add(mntmAvanzar);
		mntmAvanzar.addActionListener(this);
		
		mntmRetroceder = new JMenuItem("Retroceder");
		mntmRetroceder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
		mntmRetroceder.addActionListener(this);
		mnEstado.add(mntmRetroceder);
		
		mnCoronacion = new JMenu("Coronacion");
		mnJuego.add(mnCoronacion);
		
		rdbtnmntmReina = new JRadioButtonMenuItem("Reina");
		rdbtnmntmReina.setSelected(true);
		rdbtnmntmReina.setActionCommand("Reina");
		buttonGroup.add(rdbtnmntmReina);
		mnCoronacion.add(rdbtnmntmReina);
		rdbtnmntmReina.addActionListener(this);;
		
		rdbtnmntmTorre = new JRadioButtonMenuItem("Torre");
		rdbtnmntmTorre.setActionCommand("Torre");
		buttonGroup.add(rdbtnmntmTorre);
		mnCoronacion.add(rdbtnmntmTorre);
		rdbtnmntmTorre.addActionListener(this);;
		
		rdbtnmntmCaballo = new JRadioButtonMenuItem("Caballo");
		rdbtnmntmCaballo.setActionCommand("Caballo");
		buttonGroup.add(rdbtnmntmCaballo);
		mnCoronacion.add(rdbtnmntmCaballo);
		rdbtnmntmCaballo.addActionListener(this);
		
		rdbtnmntmAlfil = new JRadioButtonMenuItem("Alfil");
		rdbtnmntmAlfil.setActionCommand("Alfil");
		buttonGroup.add(rdbtnmntmAlfil);
		mnCoronacion.add(rdbtnmntmAlfil);
		
		mntmVistaAyuda = new JMenuItem("Vista Ayuda");
		mntmVistaAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
//				eval.activa();
			}
		});
		mnJuego.add(mntmVistaAyuda);
		rdbtnmntmAlfil.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(panelIzq,BorderLayout.WEST);
		contentPane.add(panelNorte,BorderLayout.NORTH);
		
		panelIzq.setLayout(new GridLayout(8, 1));
		panelNorte.setLayout(new GridLayout(1, 8));
		
		for (int i=0; i<indicador.length; i++)
		{
			indicador[i] = new JLabel(i+"");
			indicador2[i] = new JLabel(i+"");
			indicador[i].setHorizontalAlignment(SwingConstants.CENTER);
			indicador2[i].setHorizontalAlignment(SwingConstants.CENTER);
			panelIzq.add(indicador[i]);
			panelNorte.add(indicador2[i]);
		}
		
		btnMostrar = new JButton("Mostrar");
				
		btnMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.setVisible(true);
				
			}
		});
		
		getContentPane().add(btnMostrar, BorderLayout.SOUTH); 
		
		tablero = new TableroAjedrez(8,8,new Color(0xD8D8D8), new Color(0x0080FF),0,0);
		contentPane.add(tablero,BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == mntmNuevo)
		{
			tablero.acomodadoPrincipal();
			validate();
		}
		
		if(e.getSource() == mntmGuardarJugadas)
		{
			 ruta = chosser.showSaveDialog(this);
			  
			  if(ruta == JFileChooser.APPROVE_OPTION)
			  {
				  file = chosser.getSelectedFile();
				  Serializa.saveObject(MoveListener.almacena,file);
			  }
		}
			
		else if(e.getSource() == mntmGuardarJuego)
		{
			 
			  ruta = chosser.showSaveDialog(this);
			  
			  if(ruta == JFileChooser.APPROVE_OPTION)
			  {
				  file = chosser.getSelectedFile();
				  Estados est = new Estados();

				  est.charge(TableroAjedrez.estado.saveStringTablero(), 
						  	turnoBlancas, reyNegroMeneado, reyBlancoMeneado, torreNegraCM, 
						  	torreNegraLM, torreBlancaCM, torreBlancaLM);
				 
				  Serializa.saveObject(est,file);
			  }
			  
			  
		}
//			
		else if (e.getSource() == mntmCargarJuego)
		{
			  ruta = chosser.showOpenDialog(this);
			  
			  if(ruta == JFileChooser.APPROVE_OPTION)
			  {
				    file = chosser.getSelectedFile();
				  
				    desc.valores = (Estados) Serializa.writeObject(file);
				    desc2.valores = desc.valores;
					tablero.acomodadoEspecial();
					validate();
			  }
			
			
		}
		
		else if(e.getSource() == mntmCargarJugadas)
		{
			 ruta = chosser.showOpenDialog(this);
			  
			  if(ruta == JFileChooser.APPROVE_OPTION)
			  {
				    file = chosser.getSelectedFile();
				  
				    Mostra mostra = new Mostra((Almacena) Serializa.writeObject(file));
				    mostra.timer.start();
				    
			  }
		}
		
		else
		{
//			switch(e.getActionCommand())
//			{
//				case "Reina":
//					piezaPremio=Variables.reina;
//					break;
//					
//				case "Alfil":
//					piezaPremio=Variables.alfil;
//					break;
//
//				case "Caballo":
//					piezaPremio=Variables.caballo;
//					break;
//					
//				case "Torre":
//					piezaPremio=Variables.torre;
//					
//			}
		}
		
//		else if(e.getSource() == mntmRetroceder)
//		{
//			ClickMoved.rest.last();
//		}
//		
//		else if(e.getSource() == mntmAvanzar)
//		{
//			ClickMoved.rest.next();
//		}
		
	}
}
