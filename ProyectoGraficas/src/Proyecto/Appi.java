package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Appi extends JFrame
{
	private Pestanas pestanas;
//	private JToolBar barraHerramientas;
	private JPanel panelFunciones;
	private JMenuBar menuBar;
	private JSplitPane split;
	private ActionListener[] actionesSecun;
	
	private Fuentes dialogFuentes;
	
	private int i;
	
	private JTextField txtTitulo;
	
	public Appi()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(new BorderLayout(10,10));

//		barraHerramientas = new JToolBar(JToolBar.HORIZONTAL);

		pestanas = new Pestanas();
		
		panelFunciones = new JPanel();
		
		dialogFuentes = new Fuentes(this);
		
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.setRightComponent(pestanas);
		
		add(split,"Center");
		
//		add(barraHerramientas,"North");
		
		accionesSecundarias();
//		crearButtons();
		funciones();
		menuBar();
		
	}
	
	private void accionesSecundarias()
	{
		actionesSecun = new ActionListener[]
			{
					(a)->pestanas.crear(),
					
					(a)->
					{
						try
						{
							pestanas.getAreaDibujo().crearPNG();
						}
						catch(NullPointerException e)
						{
							JOptionPane.showMessageDialog(this, 
									e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
						}
					},

					(a)-> dialogFuentes.setVisible(true)
					
			};
	}
	
	private void funciones()
	{
		add(panelFunciones,"North");
		
		panelFunciones.setBorder(BorderFactory.createTitledBorder
				(BorderFactory.createLineBorder(Color.black),"Funciones"));
		
		JLabel lblTitulo = new JLabel("Titulo Grafica");
		txtTitulo = new JTextField(15);
		
		txtTitulo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e)
			{
				pestanas.getAreaDibujo().cad = txtTitulo.getText();
				pestanas.getAreaDibujo().repaint();
			}
		});
		
		txtTitulo.addActionListener((a)-> pestanas.cambiarTitulo(txtTitulo.getText()));
		
		panelFunciones.add(lblTitulo);
		panelFunciones.add(txtTitulo);
		
		JButton aumnentar = new JButton("+");
		aumnentar.addActionListener((a)->pestanas.getAreaDibujo().cambiarTamaño());
		
		panelFunciones.add(aumnentar);
		
		
//		String tex[] = {"Cambiar Tamaño","Rotar","Establecer Titulo"};
//		JButton btns[] = new JButton[tex.length];
//		
//		ActionListener actins [] = 
//				{
//						(a)->pestanas.getAreaDibujo().cambiarTamaño(),
//						
//						(a)->pestanas.getAreaDibujo().rotar(),
//						
//						null
//				};
//		
//		panelFunciones.setLayout(new GridLayout(btns.length+5, 1,0,10));
//		
//		for(i=0; i<btns.length; i++)
//		{
//			btns[i] = new JButton(tex[i]);
//			btns[i].addActionListener(actins[i]);
//			panelFunciones.add(btns[i]);
//		}
	}
	
	private void menuBar()
	{
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Arhivo");
		
		menuBar.add(menu);

		JMenuItem mt1 = new JMenuItem("Nueva grafica");
		JMenuItem mt2 = new JMenuItem("Exportar como imagen");
		
		menu.add(mt1);
		menu.add(mt2);
		
		mt1.addActionListener(actionesSecun[0]);
		mt2.addActionListener(actionesSecun[1]);
		
		JMenu menuEdi = new JMenu("Editar");
		menuBar.add(menuEdi);
		
		JMenuItem menuF = new JMenuItem("Fuente");
		menuEdi.add(menuF);
		
		menuF.addActionListener(actionesSecun[2]);
	}
	
	

	public static ImageIcon getImageIcon(String path,String nombre)
	{
		return new ImageIcon(System.getProperty("user.dir") + "/src/"+path+nombre);
	}
	
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(
				
				()-> new Appi().setVisible(true)
				
				);
	}
}
