package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import Libreria.Grafica;

public class Appi extends JFrame
{
	private Pestanas pestanas;
	private JPanel panelFunciones;
	private JMenuBar menuBar;
	private JSplitPane split;
	private ActionListener[] actionesSecun;
	private Categorias tablaCategorias;
	private PanelFondos fondos;
	
	JToggleButton togglePastel,toggleBarras;
	JRadioButton rdNorte,rdSur;
	JButton btnAumentar,btnDecre, btnTablaCategrias,btnNuevaG,btnCrearGraf,btnCerrar,
			btnRotarD,btnRotarIz;
	
	private Fuentes dialogFuentes;
	
	private int i;
	
	private JTextField txtTitulo;
	
	public Appi()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(new BorderLayout(10,10));

		pestanas = new Pestanas();
		
		panelFunciones = new JPanel();
		
		dialogFuentes = new Fuentes(this);
		
		tablaCategorias = new Categorias();
		
		fondos = new PanelFondos();
		
		JScrollPane sc = new JScrollPane(fondos);
		sc.setPreferredSize(new Dimension(140,100));
		
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.setRightComponent(pestanas);
		split.setLeftComponent(sc);
		add(split,"Center");
		
		
		accionesSecundarias();
		funciones();
		menuBar();
		eventos();
		
		habilitarRadio(false);
	}
	
	private void accionesSecundarias()
	{
		actionesSecun = new ActionListener[]
			{
					(a)->{
						pestanas.crear();
						
						if(!rdNorte.isEnabled())
						{
							habilitarRadio(true);
						}
					},
					
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

					(a)-> dialogFuentes.setVisible(true),
					
					(a)-> {
						pestanas.cerrar();
						
						if(pestanas.estaVacia())
							habilitarRadio(false);
					}
					
			};
	}
	
	private void eventos()
	{
		
		btnRotarD.addActionListener((a)->
		{
			try
			{
				pestanas.getAreaDibujo().rotar(-45);
			}
			catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage(),
						"Grafica: null", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnRotarIz.addActionListener((a)->{
			
			try
			{
				pestanas.getAreaDibujo().rotar(45);
			}
			catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage(),
						"Grafica: null", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnAumentar.addActionListener((a)->
		{
			try
			{
				pestanas.getAreaDibujo().aumentar();
			}
			catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage(),
						"Grafica: null", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		
		btnDecre.addActionListener((a)->
		{
			try
			{
				pestanas.getAreaDibujo().disminuir();
			}
			catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage(),
						"Grafica: null", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
	
	private void habilitarRadio(boolean v)
	{
		rdNorte.setEnabled(v);
		rdSur.setEnabled(v);
	}
	
	private void funciones()
	{
			add(panelFunciones,"North");
			
			TitledBorder tl = new TitledBorder(BorderFactory.createLineBorder(Color.black));
			tl.setTitle("FUNCIONES");
			tl.setTitleJustification(TitledBorder.CENTER);
			
			panelFunciones.setBorder(tl);
			
			//panelFunciones.setLayout(new GridLayout(1,2,10,0));
			panelFunciones.setLayout(new BorderLayout());
			
			JPanel panelDatosG = new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					  super.paintComponents(g);
					  Graphics2D g2d=(Graphics2D)g;
					  g2d.setPaint(new GradientPaint(200, 0, Color.WHITE, 200, 100, Color.BLUE));
					  g2d.fillRect(3, 8, this.getWidth(),this.getHeight()-10);
				 }
			};
			
			{
				
				tl = new TitledBorder(BorderFactory.createLineBorder(Color.black));
				tl.setTitle("ASIGNACIONES");
				tl.setTitleJustification(TitledBorder.CENTER);
				panelDatosG.setBorder(tl);
				panelDatosG.setLayout(null);
				panelDatosG.setPreferredSize(new Dimension(300, 110));
				
				btnNuevaG = new JButton(getImageIcon("Images/","barras.png"));
				btnNuevaG.setBackground(Color.white);
				btnNuevaG.addActionListener(actionesSecun[0]);
				btnNuevaG.setBounds(20, 20, 36, 36);
				
				btnCerrar = new JButton(getImageIcon("Images/","barras.png"));
				btnCerrar.setBackground(Color.white);
				btnCerrar.setBounds(20, 60, 36, 36);
				btnCerrar.addActionListener(actionesSecun[3]);
				
				JLabel lblTitulo = new JLabel("Titulo Grafica");
				lblTitulo.setBounds(110, 35, 100, 10);
				txtTitulo = new JTextField();
				txtTitulo.setBounds(90, 55, 130, 20);
				
				txtTitulo.addActionListener((a)-> pestanas.cambiarTitulo(txtTitulo.getText()));
				txtTitulo.addKeyListener(new KeyAdapter()
				{
					@Override
					public void keyReleased(KeyEvent e)
					{
						try
						{
							pestanas.getAreaDibujo().cad = txtTitulo.getText();
							pestanas.getAreaDibujo().repaint();
						}catch(NullPointerException ex) {}
					}
				});
				
				btnTablaCategrias = new JButton(getImageIcon("Images/", "barras.png"));
				btnTablaCategrias.setBackground(Color.white);
				btnTablaCategrias.addActionListener((a)->
					tablaCategorias.setVisible(true)
				
				);
				btnTablaCategrias.setBounds(245, 20, 36, 36);
				
				btnCrearGraf = new JButton(getImageIcon("Images/", "barras.png"));
				btnCrearGraf.setBackground(Color.white);
				btnCrearGraf.setBounds(245, 60, 36, 36);
				
				panelDatosG.add(btnTablaCategrias);
				panelDatosG.add(lblTitulo);
				panelDatosG.add(txtTitulo);
				panelDatosG.add(btnCerrar);
				panelDatosG.add(btnNuevaG);
				panelDatosG.add(btnCrearGraf);
				
				panelFunciones.add(panelDatosG,"West");
			}
			
		
		
		JPanel panelCongG = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				  super.paintComponents(g);
				  Graphics2D g2d=(Graphics2D)g;
				  g2d.setPaint(new GradientPaint(200, 20, Color.WHITE, 200, 400, Color.BLACK));
				  g2d.fillRect(3, 8, this.getWidth(),this.getHeight()-10);
			 }
		};
		
		{
			tl = new TitledBorder(BorderFactory.createLineBorder(Color.black));
			tl.setTitle("CONFIGURACIONES");
			tl.setTitleJustification(TitledBorder.CENTER);
			
			panelCongG.setBorder(tl);
			panelCongG.setLayout(null);
			
			JLabel lblTamaño = new JLabel("Escalar grafica");
			lblTamaño.setBounds(20, 15, 110, 35);
			
			btnAumentar = new JButton(getImageIcon("Images/", "barras.png"));
			btnAumentar.setBackground(Color.white);
			btnAumentar.setBounds(25, 45, 36, 36);
			
			btnDecre = new JButton(getImageIcon("Images/", "barras.png"));
			btnDecre.setBackground(Color.white);
			btnDecre.setBounds(75, 45, 36, 36);
			
			
			JLabel lblTipoG = new JLabel("Tipo de grafica");
			lblTipoG.setBounds(200, 15, 110, 35);
			
			toggleBarras = new JToggleButton(getImageIcon("Images/", "barras.png"));
			toggleBarras.setBounds(205, 45, 36, 36);
			toggleBarras.setBackground(Color.white);
			
			togglePastel = new JToggleButton(getImageIcon("Images/", "pastel.png"));
			togglePastel.setBounds(255, 45, 36, 36);
			togglePastel.setBackground(Color.white);
			

			{
				ButtonGroup bg = new ButtonGroup();
				bg.add(toggleBarras);
				bg.add(togglePastel);
			}
			
			JLabel lblPos = new JLabel("Posicion del titulo");
			lblPos.setBounds(370, 15, 130, 30);
			
			rdNorte = new JRadioButton("Norte");
			rdNorte.setSelected(true);
			rdNorte.addItemListener((a)->
			{
				pestanas.getAreaDibujo().setPositionTitle(Grafica.NORTE);
			});
			
			rdNorte.setBackground(new Color(0,0,0,0));
			rdNorte.setBounds(390, 45, 63, 20);
			
			rdSur = new JRadioButton("Sur");
			rdSur.addItemListener((a)->
			{
				pestanas.getAreaDibujo().setPositionTitle(Grafica.SUR);
			});
			
			rdSur.setBackground(new Color(0,0,0,0));
			rdSur.setBounds(390, 70, 50, 20);
			
			{
				ButtonGroup bg = new ButtonGroup();
				bg.add(rdNorte);
				bg.add(rdSur);
			}
			
			JLabel rotar = new JLabel("Rotar");
			rotar.setBounds(550, 15, 90, 30);
			
			btnRotarIz = new JButton(getImageIcon("Images/", "pastel.png"));
			btnRotarIz.setBounds(530, 45, 36, 36);
			btnRotarIz.setBackground(Color.white);
			
			btnRotarD = new JButton(getImageIcon("Images/", "pastel.png"));
			btnRotarD.setBounds(575, 45, 36, 36);
			btnRotarD.setBackground(Color.white);
			
			panelCongG.add(btnRotarD);
			panelCongG.add(btnRotarIz);
			panelCongG.add(rotar);
			panelCongG.add(rdSur);
			panelCongG.add(rdNorte);
			panelCongG.add(lblPos);
			panelCongG.add(toggleBarras);
			panelCongG.add(togglePastel);
			panelCongG.add(lblTipoG);
			panelCongG.add(btnAumentar);
			panelCongG.add(btnDecre);
			panelCongG.add(lblTamaño);
			panelFunciones.add(panelCongG,"Center");
		}
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
		try
		{
			return new ImageIcon(Appi.class.getResource("/"+path+nombre));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static ImageIcon getScaledImageIcon(String path,String nombre, int w, int h)
	{
		Image img = new ImageIcon(Appi.class.getResource("/"+path+nombre)).getImage();
		
		return new  ImageIcon(img.getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING));
	}
	
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(
				
				()-> new Appi().setVisible(true)
				
				);
	}
}
