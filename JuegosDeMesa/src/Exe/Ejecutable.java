package Exe;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import DiseñoAjedrez.TableroAjedrez;
import DiseñoTresEnRaya.TableroTicTac;

public class Ejecutable extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 5092170439846255586L;
	
	private TableroAjedrez taj = new TableroAjedrez();
	private TableroTicTac tabTicTac = new TableroTicTac();
	private JMenuBar menuBar;
	private JMenu menuJuego,menuNew;
	private JMenuItem mtmAjedrez,mtmTicTac,mtmExit;
	
	public JTextArea txtInfo = new JTextArea();
	
	public Ejecutable() 
	{
		setLayout(new GridLayout(1,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(600, 600);
		//setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1150,700));
		menuHerramientas();
//		setIconImage(new ImageIcon(getClass().getResource("/Recursos/Ajedrez/alfil1.png")).getImage());
//		
	}
	
	private void menuHerramientas()
	{
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuJuego = new JMenu("Juego");
		menuJuego.addActionListener(this);
		menuBar.add(menuJuego);
		
		menuNew = new JMenu("Nuevo");
		menuNew.setMnemonic('N');
		menuJuego.add(menuNew);

		menuJuego.addSeparator();
		mtmExit = new JMenuItem("Salir");
		mtmExit.setAccelerator(KeyStroke.getKeyStroke('W',InputEvent.CTRL_MASK));
		mtmExit.addActionListener(this);
		menuJuego.add(mtmExit);
		
		mtmAjedrez = new JMenuItem("Ajedrez");
		menuNew.add(mtmAjedrez);
		mtmAjedrez.setAccelerator(KeyStroke.getKeyStroke('A',InputEvent.ALT_MASK));
		mtmAjedrez.addActionListener(this);
		
		mtmTicTac = new JMenuItem("Tres en Raya");
		menuNew.add(mtmTicTac);
		mtmTicTac.setAccelerator(KeyStroke.getKeyStroke('T',InputEvent.ALT_MASK));
		mtmTicTac.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == mtmAjedrez)
		{
			add(taj);
			taj.acomodadoNormal();
			add(new JScrollPane(txtInfo));
			
		}
		
		else if(mtmTicTac == e.getSource())
		{
			add(tabTicTac);
			add(new JScrollPane(txtInfo));
		}
		
		else if(e.getSource() == mtmExit)
		{
			System.exit(0);
		}
		
		validate();
	}
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				new Ejecutable().setVisible(true);
			}
		});
	}
}